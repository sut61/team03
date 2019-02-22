import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClassifyService {

  private API = '//localhost:8080/classify';

  constructor(private http: HttpClient) { }

  getStatus() {
    return this.http.get(this.API + '/queue/status');
  }

  getItem() {
    return this.http.get(this.API + '/queue/item');
  }

  getClass() {
    return this.http.get(this.API + '/queue/class');
  }

  getType() {
    return this.http.get(this.API + '/queue/type');
  }

  addClass(classify) {
    return this.http.post(this.API + '/add/class', classify, {responseType: 'text'});
  }

  addType(typeName) {
    return this.http.post(this.API + '/add/type/' + typeName, null, {responseType: 'text'});
  }

  manageStatus(status, classify) {
    return this.http.post(this.API + '/manage/status/' + status + '/' + classify, null, {responseType: 'text'});
  }

  manageClass(classify, item) {
    return this.http.post(this.API + '/manage/class/' + classify + '/' + item, null, {responseType: 'text'});
  }

  manageType(type, item) {
    return this.http.post(this.API + '/manage/type/' + type + '/' + item, null, {responseType: 'text'});
  }

}
