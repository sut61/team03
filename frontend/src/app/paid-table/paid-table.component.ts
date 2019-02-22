import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {PaidService} from '../shared/pay/paid.service';
   @Component({
  selector: 'app-paid-table',
  templateUrl: './paid-table.component.html',
  styleUrls: ['./paid-table.component.css']
})
export class PaidTableComponent implements OnInit {
  bills: Array<any>;
  members: Array<any>;
  payments: Array<any>;
  paidstatuss: Array<any>;
  cashs: Array<any>;

  displayedColumns: string[] = ['id'  , 'userName' , 'totalPrice' , 'CreditPay' , 'CashPay'];
  displayedColumns2: string[] = ['userName'  , 'price', 'type' , 'receive' , 'name'];
  displayedColumns3: string[] = ['userName'  , 'cashprice', 'cashreceive', 'name' ];
  constructor(private paidService: PaidService , private router: Router) { }

  ngOnInit() {
   this.paidService.getBill().subscribe(data => {
     this.bills = data;
     console.log(this.bills);
   });
   this.paidService.getMember().subscribe(data => {
     this.members = data;
     console.log(this.members);
   });
   this.paidService.getPayment().subscribe(data => {
     this.payments = data;
     console.log(this.payments);
   });
   this.paidService.getPaidStatus().subscribe(data => {
     this.paidstatuss = data;
     console.log(this.paidstatuss);
   });
   this.paidService.getCash().subscribe(data =>{
     this.cashs = data;
     console.log(this.cashs);
   });
  }
  viewCreditpay(element): void {
    this.router.navigate(['creditpay/' + element.id]);
  }
  viewCashpay(element): void {
    this.router.navigate(['cashpay/' + element.id]);
  }
}
