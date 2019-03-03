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

  getMember(): Observable<any> {
    return this.http.get(this.API + '/bill/Member');
  }

  getBill(): Observable<any> {
    return this.http.get(this.API + '/Bill');
  }

  addDamageBill(billSelect: number,InputName: String,InputTel: String,Inputdetail: String,Inputprice: number,paidStatusSelect: number,username: String){
    return this.http.post(this.API + '/bill/'+username+ '/' +billSelect+ '/' +InputName+ '/' +InputTel+ '/' +Inputdetail+ '/' +  Inputprice+ '/' +paidStatusSelect,{
    });
  }

}
