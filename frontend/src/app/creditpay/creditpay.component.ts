import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {PaidService} from '../shared/pay/paid.service';

  @Component({
  selector: 'app-creditpay',
  templateUrl: './creditpay.component.html',
  styleUrls: ['./creditpay.component.css']
})
export class CreditpayComponent implements OnInit {
  credittypes: Array<any>;
  bills: Array<any> ;
  credittypeSelect = '';
  paidstatuss: Array<any>;
  statusSelect = '';
  payments: Array<any>;
  memberInfos: Array<any>;
  memberInfoSelect = '';
  totalSelect = '';
  price: string;
  receive: string;
  timeSelect = null;

  constructor(private paidService: PaidService , private router: Router , private  httpClient: HttpClient) { }
  ngOnInit() {
    this.paidService.getCreditType().subscribe(data => {
      this.credittypes = data;
      console.log(this.credittypes);
    });
    this.paidService.getPayment().subscribe(data => {
      this.payments = data;
      console.log(this.payments);
    });
    this.paidService.getMemInfo().subscribe(data => {
      this.memberInfos = data;
      console.log(this.memberInfos);
    });
    this.paidService.getBill().subscribe(data => {
      this.bills = data;
      console.log(this.bills);
    });
    this.paidService.getPaidStatus().subscribe(data => {
      this.paidstatuss = data;
      console.log(this.paidstatuss);
    });
  }
  insert() {
    if (this.credittypeSelect == null || this.price == null || this.receive == null || this.timeSelect == null || this.memberInfoSelect == null || this.totalSelect == null || this.statusSelect == null) {
      alert('กรอกข้อมูลให้ครบ');
    } else {
      this.httpClient.post('http://localhost:8080/pay/payment/' + this.timeSelect + '/' + this.price + '/' + this.receive + '/' + this.credittypeSelect + '/' + this.memberInfoSelect + '/' + this.totalSelect + '/' + this.statusSelect , {}).subscribe()
      alert('สำเร็จ');
      this.router.navigate(['']);
    }
  }
}
