import {Component, OnInit} from '@angular/core';
import {RoomSelectService} from '../shared/room-select/room-select.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {RoomReserveService} from '../shared/room-reserve/room-reserve.service';
import {TokenService} from '../shared/token/token.service';

class BookingModel {
  bookingName: string;
  bookingTel: string;
  bookingNameSecond: string;
  bookingTelSecond: string;
  timeData = [];
  username: string;
}

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
  reportText: any;

  failText = 'พบปัญหา';
  passText = 'เพิ่มสำเร็จ';

  isPractice: boolean;

  booking = new BookingModel();

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
        this.isPractice = (this.roomType.type === 'practice');
      });
    });
    this.roomReserveService.getDate().subscribe(value => {
      this.date = value;
    });
    this.timeForm = this.fb.group({
      'time': new FormControl('', Validators.required)
    });
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
    });
    this.timeData = [];
  }

  onSubmit() {
    this.booking.username = this.token.getUsername();
    this.booking.timeData = this.timeData;
    this.reportText = '';
    this.roomReserveService.putReserve(this.room.id, this.dateSelectID, this.booking)
      .subscribe(value => {
        this.reportText = value;
        }, error => {
        this.reportText = 'booking fail';
      });
  }
}
