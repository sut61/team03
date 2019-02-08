import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CourseReserveService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getStatusCourse(): Observable<any> {
    return this.http.get(this.API + '/coursereserve/StatusCourse');
  }

  getCourseMusic(): Observable<any> {
    return this.http.get(this.API + '/coursereserve/CourseMusic');
  }

  addCourseReserve(inputNickName: String,inputPhone: String,CourseMusicSelect: number,StatusCourseSelect: number, username: String){
    return this.http.post(this.API + '/coursereserve/reserve/' + CourseMusicSelect + '/' + inputNickName + '/' + inputPhone + '/' +  StatusCourseSelect + '/' + username,{
    });
  }

}
