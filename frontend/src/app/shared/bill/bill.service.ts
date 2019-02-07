import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BillService {

  private API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getPaidStatus(): Observable<any> {
    return this.http.get(this.API + '/PaidStatus');
  }

  getRooms(): Observable<any> {
    return this.http.get(this.API + '/Room');
  }
  getBillRoom(): Observable<any> {
    return this.http.get(this.API + '/BillRoom');
  }
  getRoom(roomId, billId): Observable<any> {
    return this.http.get(this.API + '/Bill/BillRoom/' + roomId + '/' + billId);
  }
  getMember(): Observable<any> {
    return this.http.get(this.API + '/pay/member');
  }

  getBill(): Observable<any> {
    return this.http.get(this.API + '/bill');
  }

  postBill(data : any): Observable<any> {
    return this.http.post(this.API + '/bill', data);
  }

}
