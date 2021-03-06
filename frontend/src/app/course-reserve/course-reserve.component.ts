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
  inputNameFacebook: String;
  inputPhone: String;

  CouseMusicSelect: number;
  StatusCourseSelect: number;

  accept: boolean;
  reporterror: boolean;

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
    this.accept = false;
    this.reporterror = false;
    this.coursereserveservice.addCourseReserve( this.inputNickName,this.inputNameFacebook, this.inputPhone, this.CouseMusicSelect, this.StatusCourseSelect, this.token.getUsername()).subscribe(
      data => {
        this.getCourseMusicList();
        this.accept = true;
      },
      error => {
        this.reporterror = true;
      }
    );
  }

}
