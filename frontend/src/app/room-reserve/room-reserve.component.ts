import {Component, OnInit} from '@angular/core';
import {RoomSelectService} from '../shared/room-select/room-select.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {RoomReserveService} from '../shared/room-reserve/room-reserve.service';
import {TokenService} from '../shared/token/token.service';

@Component({
  selector: 'app-room-reserve',
  templateUrl: './room-reserve.component.html',
  styleUrls: ['./room-reserve.component.css']
})
export class RoomReserveComponent implements OnInit {

  name: '';
  room: any;
  date: any;
  dateSelectID: any;
  timeTable: any;
  timeData = [];
  timeForm: FormGroup;
  roomType: any;

  constructor(private roomSelectService: RoomSelectService, private router: ActivatedRoute,
              private fb: FormBuilder, private roomReserveService: RoomReserveService,
              private token: TokenService, private route: Router) { }

  ngOnInit() {
    if (this.token.getUsername() === undefined) {
      this.route.navigate(['login']);
    }
    this.router.params.subscribe(data => {
      this.roomReserveService.getRoomInfo(data['id']).subscribe(value => {
        this.room = value;
        this.name = this.room.name;
      });
      this.roomReserveService.getRoomType(data['id']).subscribe(value => {
        this.roomType = value;
      });
    });
    this.roomReserveService.getDate().subscribe(value => {
      this.date = value;
    });
    this.timeForm = this.fb.group({
      'time': new FormControl('', Validators.required)
    });
  }

  isTrue(reserve: boolean) {
    return reserve;
  }

  onChange(event, time) {
    if (event.checked === true) {
      this.timeData.push(time);
    } else {
      this.timeData = this.timeData.filter(item => item !== time);
    }
    this.timeForm.setValue({time: this.timeData});
  }

  selectDate(event) {
    this.dateSelectID = event;
    this.roomReserveService.getTime(this.room.id, event).subscribe(value => {
      this.timeTable = value;
      console.log(this.timeTable);
    });
  }

  onSubmit() {
    console.log(this.timeData);
    console.log(this.dateSelectID);
    console.log(this.room.id);
    this.roomReserveService.putReserve(this.room.id, this.dateSelectID, this.timeData, this.token.getUsername()).subscribe(
      value => {},
      error1 => {
        if (alert('error')) {
          window.location.reload();
        }
      }, () => {
        if (alert('complete')) {
          window.location.reload();
        }
      });
    window.location.reload();
  }

  isPractice() {
    return this.roomType.type === 'practice';
  }

}
