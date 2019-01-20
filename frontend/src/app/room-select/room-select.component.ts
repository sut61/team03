import { Component, OnInit } from '@angular/core';
import {RoomSelectService} from '../shared/room-select/room-select.service';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Router} from '@angular/router';

@Component({
  selector: 'app-room-select',
  templateUrl: './room-select.component.html',
  styleUrls: ['./room-select.component.css']
})
export class RoomSelectComponent implements OnInit {

  rooms: any;
  roomTypes: any;
  roomSizes: any;
  roomForm: FormGroup;

  constructor(private roomSelectService: RoomSelectService, private fb: FormBuilder,
              private router: Router) { }

  ngOnInit() {
    this.roomSelectService.getSize().subscribe(data => {
      this.roomSizes = data;
    });
    this.roomSelectService.getType().subscribe(data => {
      this.roomTypes = data;
    });
    this.createRoomForm();
  }

  selectSize(event) {
    this.roomForm.patchValue({'size': event});
  }

  selectType(event) {
    this.roomForm.patchValue({'type': event});
  }

  createRoomForm() {
    this.roomForm = this.fb.group({
      'type' : new FormControl('', Validators.required),
      'size' : new FormControl('', Validators.required)
    });
  }

  findRoom() {
    this.roomSelectService.getRoom(this.roomForm.get('type').value, this.roomForm.get('size').value)
      .subscribe(data => {
        this.rooms = data;
      });
  }

  roomSelect(id: any) {
    console.log('room id => ' + id);
    this.router.navigate(['/reserve', id]);
  }

}
