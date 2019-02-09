import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CoursemusicService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getCourseMusic(): Observable<any> {
    return this.http.get(this.API + '/courseMusic/CourseMusic');
  }

  getMember(): Observable<any> {
    return this.http.get(this.API + '/courseMusic/Member');
  }

  getInstrument(): Observable<any> {
    return this.http.get(this.API + '/courseMusic/Instrument');
  }

  getClassroom(): Observable<any> {
    return this.http.get(this.API + '/courseMusic/Classroom');
  }

  getPaymentType(): Observable<any> {
    return this.http.get(this.API + '/courseMusic/PaymentType');
  }

  getCourseTime(): Observable<any> {
    return this.http.get(this.API + '/courseMusic/CourseTime');
  }


  addcourseMusic(inputFname: String,inputLname: String,inputnickname: String,inputPhoneNum: String,instrumentSelect: number,courseTimeSelect: number,classroomSelect: number,paymentTypeSelect: number, username: String){
    return this.http.post(this.API + '/courseMusic/createCourseMusic/' + username + '/' + inputFname + '/' + inputLname+ '/' +'/' + inputnickname + '/' + inputPhoneNum+ '/' +  instrumentSelect + '/' +  courseTimeSelect + '/' + classroomSelect + '/' + paymentTypeSelect,{
    });
  }

}
