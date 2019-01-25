import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AllserviceService {
  public API = '//localhost:8080';
  constructor(private httpClient:HttpClient) { }


  getProduct(): Observable<any>{
    return this.httpClient.get(this.API+'/product');
  }

  getPromotion(): Observable<any>{
    return this.httpClient.get(this.API+'/promotion');
  }

  getStaff(): Observable<any>{
    return this.httpClient.get(this.API+'/staff');
  }

  getTypepromotion(): Observable<any>{
    return this.httpClient.get(this.API+'/typepromotion');
  }

}
