import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CheckmainService {
public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getDatainfo(): Observable<any>  {
    return this.http.get(this.API + '/Datainfos');
  }
  getInstruType(): Observable<any>  {
    return this.http.get(this.API + '/InstruTypes');
  }
  getItem(): Observable<any>  {
    return this.http.get(this.API + '/ItemFixes');
  }
  getCustomer(): Observable<any>  {
    return this.http.get(this.API + '/CustomerFixes');
  }
  getManager(): Observable<any>  {
    return this.http.get(this.API + '/Managers');
  }
  getFixmain(fixmainId): Observable<any> {
    return this.http.get(this.API + '/FixMain/' + fixmainId);
  }
}
