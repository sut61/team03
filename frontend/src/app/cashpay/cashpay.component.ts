import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {PaidService} from '../shared/pay/paid.service';

  @Component({
  selector: 'app-cashpay',
  templateUrl: './cashpay.component.html',
  styleUrls: ['./cashpay.component.css']
})
export class CashpayComponent implements OnInit {
  paidstatuss: Array<any>;
  members: Array<any>;
  bills: Array<any> ;
  cashs: Array<any>;

  memberSelect = '';
  totalSelect = '';
  statusSelect = '';

  cashreceive: string;
  price: string;
  constructor(private paidService: PaidService , private router: Router , private  httpClient: HttpClient) { }

  ngOnInit() {
    this.paidService.getMember().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.paidService.getBill().subscribe(data => {
      this.bills = data;
      console.log(this.bills);
    });
    this.paidService.getPaidStatus().subscribe(data => {
      this.paidstatuss = data;
      console.log(this.paidstatuss);
    });
    this.paidService.getCash().subscribe(data => {
      this.cashs = data;
      console.log(this.cashs);
    });
  }
  insert() {
    if ( this.price == null || this.cashreceive == null  || this.memberSelect == null || this.totalSelect == null || this.statusSelect == null) {
      alert('กรอกข้อมูลให้ครบ');
    } else {
      this.httpClient.post('http://localhost:8080/pay/cash/' + this.cashreceive + '/' +  this.price + '/'  + this.totalSelect + '/' + this.memberSelect + '/' + this.statusSelect , {}).subscribe()
      alert('สำเร็จ');
      this.router.navigate(['']);
    }
  }
}
