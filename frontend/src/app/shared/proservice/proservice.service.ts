import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProserviceService {

  public API = '//localhost:8080';
  constructor(private httpClient:HttpClient) { }

  getProduct(): Observable<any>{
    return this.httpClient.get(this.API+'/product');
  }

  getTypeproduct(): Observable<any>{
    return this.httpClient.get(this.API+'/typeproduct');
  }


}
