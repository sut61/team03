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
  showError : String;

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
    console.log(this.token.getUsername());
    console.log(this.inputFname);
    console.log(this.inputLname);
    console.log(this.inputnickname);
    console.log(this.inputPhoneNum);
    console.log(this.instrumentSelect);
    console.log(this.courseTimeSelect);
    console.log(this.classRoomSelect);
    console.log(this.paymentTypeSelect);
    if(this.inputFname === '' || this.inputLname === ''|| this.inputnickname === '' || this.inputPhoneNum === ''|| this.instrumentSelect === 0 ||
    this.courseTimeSelect === 0 || this.classRoomSelect === 0 || this.paymentTypeSelect === 0){
    alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    this.showError = "กรุณากรอกข้อมูลให้ครบถ้วน"
  }
    else{
      this.courseMusicService.addcourseMusic( this.inputFname, this.inputLname, this.inputnickname, this.inputPhoneNum,this.instrumentSelect,
        this.courseTimeSelect, this.classRoomSelect, this.paymentTypeSelect, this.token.getUsername()).subscribe(
        data => {
          this.getCourseMusicItem();
          alert("การเพิ่มข้อมูลสำเร็จ");
          this.showError = "การเพิ่มข้อมูลสำเร็จ"
        },
        error => {
          alert("เกิดข้อผิดพลาด");
          console.log("Error", error);
          this.showError = "เกิดข้อผิดพลาด"
        }
      );

  }
}

}
