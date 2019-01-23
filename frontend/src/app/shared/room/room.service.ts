import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RoomService {
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }
  
  getRoom(): Observable<any> {
    return this.http.get(this.API + '/room/Room');
  }
  getRoomType(): Observable<any> {
    return this.http.get(this.API + '/room/RoomType');
  }
  getRoomSize(): Observable<any> {
    return this.http.get(this.API + '/room/RoomSize');
  }
  getStatusRoom(): Observable<any> {
    return this.http.get(this.API + '/room/StatusRoom');
  }
  getInstrumen(): Observable<any> {
    return this.http.get(this.API + '/room/Instrument');
  }

  addRoom(inputName: string,inputRate: number,roomSizeSelect: number,roomTypeSelect: number,statusRoomSelect: number){
    return this.http.post(this.API + '/room/addRoom/'+inputName+'/'+inputRate+'/'+roomSizeSelect+'/'+roomTypeSelect+'/'+statusRoomSelect,{
    });
  }
  putRoom(roomSelect1: number,inputRate1: number,roomSizeSelect1: number,roomTypeSelect1: number,statusRoomSelect1: number){
    return this.http.put(this.API + '/room/addRoom/'+roomSelect1+'/'+inputRate1+'/'+roomSizeSelect1+'/'+roomTypeSelect1+'/'+statusRoomSelect1,{
    });
  }
  addInstrumen(roomSelect: number,instrumenSelect: number){
    return this.http.post(this.API + '/RoomInstrument/addInstrument/'+roomSelect+'/'+instrumenSelect,{
    });
  }
}
