import { Component, OnInit } from '@angular/core';
import {RoomService} from '../shared/room/room.service';

@Component({
  selector: 'app-room',
  templateUrl: './room.component.html',
  styleUrls: ['./room.component.css']
})
export class RoomComponent implements OnInit {
  roomsizes: Array<any>;
  roomtypes: Array<any>;
  statusrooms: Array<any>;
  rooms: Array<any>;
  inputName: string;
  inputRate: number;
  inputRate1: number;
  roomSizeSelect: number = 0;
  roomTypeSelect: number = 0;
  statusRoomSelect: number = 0;

  roomSizeSelect1: number = 0;
  roomTypeSelect1: number = 0;
  statusRoomSelect1: number = 0;
  roomSelect1: number = 0;

  roomSelect: number = 0;
  instrumentSelect: number = 0;
  instruments: Array<any>;

  constructor(private roomService:RoomService) { }

  ngOnInit() {
    this.getRoomSizeList();
    this.getRoomTypeList();
    this.getStatusRoomList();
    this.getRoomList();
    this.getInstrumentList();
  }
  getRoomSizeList(){
    this.roomService.getRoomSize().subscribe(data => {
      this.roomsizes = data;
      console.log(this.roomsizes);
    });
  }
  getRoomTypeList(){
    this.roomService.getRoomType().subscribe(data => {
      this.roomtypes = data;
      console.log(this.roomtypes);
    });
  }
  getStatusRoomList(){
    this.roomService.getStatusRoom().subscribe(data => {
      this.statusrooms = data;
      console.log(this.statusrooms);
    });
  }
  getRoomList(){
    this.roomService.getRoom().subscribe(data => {
      this.rooms = data;
      console.log(this.rooms);
    });
  }
  getInstrumentList(){
    this.roomService.getInstrumen().subscribe(data => {
      this.instruments = data;
      console.log(this.instruments);
    });
  }
  postRoom(){
    this.roomService.addRoom(this.inputName, this.inputRate, this.roomSizeSelect, this.roomTypeSelect, this.statusRoomSelect).subscribe(
      data => {
        this.inputName = '';
        this.inputRate = 0;
        this.getRoomList();
        alert("การเพิ่มข้อมูลสำเร็จ");
      },
      error => {
        alert("การเพิ่มข้อมูลเกิดข้อผิดพลาด");
        console.log("Error", error);
      }
    );
  }

  putRoom(){
    this.roomService.putRoom( this.roomSelect1, this.inputRate1, this.roomSizeSelect1, this.roomTypeSelect1, this.statusRoomSelect1).subscribe(
      data => {
        this.inputRate = 0;
        this.getRoomList();
        alert("การแก้ไขข้อมูลสำเร็จ");
      },
      error => {
        alert("การเพิ่มข้อมูลเกิดข้อผิดพลาด");
        console.log("Error", error);
      }
    );
  }

  postInstrumen(){
    this.roomService.addInstrumen( this.roomSelect, this.instrumentSelect).subscribe(
      data => {
        this.getRoomList();
        alert("การเพิ่มข้อมูลสำเร็จ");
      },
      error => {
        alert("การเพิ่มข้อมูลเกิดข้อผิดพลาด");
        console.log("Error", error);
      }
    );
  }

}
