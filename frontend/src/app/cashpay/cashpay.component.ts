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
  memberinfos: Array<any>;
  bills: Array<any> ;
  cashs: Array<any>;
  memberInfoSelect = '';
  totalSelect = '';
  statusSelect = '';

  cashreceive: string;
  price: string;
  constructor(private paidService: PaidService , private router: Router , private  httpClient: HttpClient) { }

  ngOnInit() {
    this.paidService.getMemInfo().subscribe(data => {
      this.memberinfos = data;
      console.log(this.memberinfos);
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
    if ( this.price == null || this.cashreceive == null  || this.memberinfos == null || this.totalSelect == null || this.statusSelect == null) {
      alert('กรอกข้อมูลให้ครบ');
    } else {
      this.httpClient.post('http://localhost:8080/pay/cash/' + this.cashreceive + '/' +  this.price + '/'  + this.totalSelect + '/' + this.memberInfoSelect + '/' + this.statusSelect , {}).subscribe()
      alert('สำเร็จ');
      this.router.navigate(['']);
    }
  }
}
