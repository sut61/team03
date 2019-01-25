import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable()
export class PaidService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }
    getMember(): Observable<any> {
    return this.http.get(this.API + '/pay/member');
  }
    getBill(): Observable<any> {
    return this.http.get(this.API + '/pay/bill');
    }
    getPayment(): Observable<any> {
    return this.http.get(this.API + '/pay/payment');
    }
    getCreditType(): Observable<any> {
    return this.http.get(this.API + '/pay/creditType');
    }
    getPaidStatus(): Observable<any> {
    return this.http.get(this.API + '/pay/status');
    }
    getCash(): Observable<any> {
    return this.http.get(this.API + '/pay/cash');
    }
    getMemInfo(): Observable<any> {
    return this.http.get(this.API + '/pay/memberinfo');
    }
}
