import { Component, OnInit } from '@angular/core';
import {CourseReserveService} from '../shared/course-reserve/course-reserve.service';
import {TokenService} from '../shared/token/token.service';

@Component({
  selector: 'app-course-reserve',
  templateUrl: './course-reserve.component.html',
  styleUrls: ['./course-reserve.component.css']
})
export class CourseReserveComponent implements OnInit {
  coursemusics: Array<any>;
  statuscourses: Array<any>;
  inputNickName: String;
  inputPhone: String;

  CouseMusicSelect: number;
  StatusCourseSelect: number;

  constructor(private coursereserveservice:CourseReserveService,private token: TokenService) { }

  ngOnInit() {
    this.getStatusCourseList();
    this.getCourseMusicList();
  }

  getStatusCourseList(){
    this.coursereserveservice.getStatusCourse().subscribe(data => {
      this.statuscourses = data;
      console.log(this.statuscourses);
    });
  }

  getCourseMusicList(){
    this.coursereserveservice.getCourseMusic().subscribe(data => {
      this.coursemusics = data;
      console.log(this.coursemusics);
    });
  }

  postCourseReserve(){
    console.log(this.inputNickName);
    console.log(this.inputPhone);
    console.log(this.CouseMusicSelect);
    console.log(this.StatusCourseSelect);
    console.log(this.token.getUsername());
    this.coursereserveservice.addCourseReserve( this.inputNickName, this.inputPhone, this.CouseMusicSelect, this.StatusCourseSelect, this.token.getUsername()).subscribe(
      data => {
        this.getCourseMusicList();
        alert("การเพิ่มข้อมูลสำเร็จ");
      },
      error => {
        alert("การเพิ่มข้อมูลเกิดข้อผิดพลาด");
        console.log("Error", error);
      }
    );
  }

}
