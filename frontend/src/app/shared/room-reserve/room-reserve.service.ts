import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomReserveService {

  private API = '//localhost:8080/reserve/';
  private dateURL = 'date';
  private timeURL = 'select';
  private reserveTimeURL = 'reserve';
  private roomTypeURL = 'room';

  constructor(private http: HttpClient) { }

  getRoomInfo(roomID): Observable<any> {
    return this.http.get(this.API + roomID);
  }

  getDate(): Observable<any> {
    return this.http.get(this.API + this.dateURL);
  }

  getTime(roomID, dateID): Observable<any> {
    return this.http.get(this.API + this.timeURL + '/' + roomID + '/' + dateID);
  }

  getRoomType(roomID): Observable<any> {
    return this.http.get(this.API + this.roomTypeURL + '/' + roomID);
  }

  putReserve(roomID, dateID, booking) {
    return this.http.put(this.API + this.reserveTimeURL + '/' + roomID + '/' + dateID, booking, {responseType: 'text'});
  }

}
