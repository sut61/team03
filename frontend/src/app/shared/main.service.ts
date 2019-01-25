import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MainService {

public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getProvince(): Observable<any>  {
    return this.http.get(this.API + '/Provinces');
  }
  getDistrict(province): Observable<any>  {
    return this.http.get(this.API + '/District/' + province);
  }
  getItem(): Observable<any>  {
    return this.http.get(this.API + '/Items');
  }
  getTransport(): Observable<any>  {
    return this.http.get(this.API + '/Transports');
  }
  getCustomer(): Observable<any>  {
    return this.http.get(this.API + '/Customers');
  }
  getShop(shopId): Observable<any> {
    return this.http.get(this.API + '/Shop/' + shopId);
  }
}
