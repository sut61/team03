import { Component, OnInit } from '@angular/core';
import { CoursemusicService } from '../shared/coursemusic/coursemusic.service';
import {Router} from '@angular/router';
import { TokenService } from '../shared/token/token.service';

@Component({
  selector: 'app-coursemusic',
  templateUrl: './coursemusic.component.html',
  styleUrls: ['./coursemusic.component.css']
})
export class CoursemusicComponent implements OnInit {

  members: Array<any>;
  instruments: Array<any>;
  paymentTypes: Array<any>;
  classrooms: Array<any>;
  courseTimes: Array<any>;
  courseMusics: Array<any>;

  inputFname: String ;
  inputLname: String ;
  inputnickname: String ;
  inputPhoneNum: String ;
  instrumentSelect: number;
  courseTimeSelect: number ;
  classRoomSelect: number  ;
  paymentTypeSelect: number ;

  courseMusicSelect2: number;
  instrumentSelect2: number;
  courseTimeSelect2: number;
  classRoomSelect2: number;
  paymentTypeSelect2: number;

  showCheck: String;
  showCheck2: String;

  constructor(private courseMusicService: CoursemusicService , private route: Router, private token: TokenService) { }

  ngOnInit() {
    this.getCourseMusicItem();
    this.courseMusicService.getMember().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.courseMusicService.getInstrument().subscribe(data => {
      this.instruments = data;
      console.log(this.instruments);
    });
    this.courseMusicService.getCourseTime().subscribe(data => {
      this.courseTimes = data;
      console.log(this.courseTimes);
    });
    this.courseMusicService.getClassroom().subscribe(data => {
      this.classrooms = data;
      console.log(this.classrooms);
    });
    this.courseMusicService.getPaymentType().subscribe(data => {
      this.paymentTypes = data;
      console.log(this.paymentTypes);
    });
  }
  getCourseMusicItem(){
    this.courseMusicService.getCourseMusic().subscribe(data => {
      this.courseMusics = data;
      console.log(this.courseMusics);
    });
  }

  InsertCoursemusic(){
    this.courseMusicService.addcourseMusic( this.inputFname, this.inputLname, this.inputnickname, this.inputPhoneNum,this.instrumentSelect,
      this.courseTimeSelect, this.classRoomSelect, this.paymentTypeSelect, this.token.getUsername()).subscribe(
      data => {
        this.getCourseMusicItem();
        this.showCheck = "เพิ่มข้อมูลสำเร็จ"
      },
      error => {
        console.log("Error", error);
        this.showCheck = "เพิ่มข้อมูลไม่สำเร็จ"
      }
    );
}

UpdateCoursemusic(){
  this.courseMusicService.editcourseMusic( this.courseMusicSelect2, this.instrumentSelect2,
    this.courseTimeSelect2, this.classRoomSelect2, this.paymentTypeSelect2, this.token.getUsername()).subscribe(
    data => {
      this.getCourseMusicItem();
      this.showCheck2 = "แก้ไขข้อมูลสำเร็จ"
    },
    error => {
      console.log("Error", error);
      this.showCheck2 = "แก้ไขข้อมูลไม่สำเร็จ"
    }
  );

}

}
