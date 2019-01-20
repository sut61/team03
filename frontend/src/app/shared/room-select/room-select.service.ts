import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomSelectService {

  constructor(private http: HttpClient) { }

  getType(): Observable<any> {
    return this.http.get('//localhost:8080/reserve/type');
  }

  getSize(): Observable<any> {
    return this.http.get('//localhost:8080/reserve/size');
  }

  getRoom(type, size): Observable<any> {
    return this.http.get('//localhost:8080/reserve/rooms/' + type + '/' + size);
  }

  getInstrument(roomID): Observable<any> {
    return this.http.get('//localhost:8080/reserve/inst/' + roomID);
  }
}
