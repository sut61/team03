import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }

  getMember(): Observable<any> {
    return this.http.get(this.API + '/comment/member');
  }
  getServiceType(): Observable<any> {
    return this.http.get(this.API + '/comment/service');
  }
  getScore(): Observable<any> {
    return this.http.get(this.API + '/comment/score');
  }
  getReview(): Observable<any> {
    return this.http.get(this.API + '/comment/review');
  }
}
