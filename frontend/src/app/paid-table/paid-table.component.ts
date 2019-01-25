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
  memberinfos: Array<any>;
  displayedColumns: string[] = ['id'  , 'userName'  , 'CreditPay' , 'CashPay'];

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
   this.paidService.getMemInfo().subscribe(data => {
     this.memberinfos = data;
     console.log(this.memberinfos);
   });
  }
  viewCreditpay(element): void {
    this.router.navigate(['creditpay/' + element.id]);
  }
  viewCashpay(element): void {
    this.router.navigate(['cashpay/' + element.id]);
  }
}
