import { Component, OnInit } from '@angular/core';
import { BillService } from '../shared/bill/bill.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  paidStatuses: Array<any>;
  rooms: Array<any>;
  billRooms: Array<any>;
  members: Array<any>;
  inputContent: string = '';
  inputPrice: number = 0;
  date: any;
  paidStatusSelect: number = 0;
  selectBillRoom: number = 0;
  bills: Array<any>;

  constructor(private billService: BillService, private router: Router) { }

  ngOnInit() {
    this.getBillList();
    this.billService.getPaidStatus().subscribe(data => {
      this.paidStatuses = data;
      console.log(this.paidStatuses);
    });
    this.billService.getBillRoom().subscribe(data => {
      this.billRooms = data;
      console.log(this.billRooms);
    });
    this.billService.getRooms().subscribe(data => {
      this.rooms = data;
      console.log(this.rooms);
    });

    this.billService.getMember().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });


  }
  getBillList() {
    this.billService.getBill().subscribe(data => {
      this.bills = data;
      console.log(this.bills);
    });
  }

  putBill(sdata) {
    console.log(sdata);

    this.billService.postBill(sdata).subscribe(data => {
      console.log(data);

    },
    err => {
      console.log(err);
    })
  }


}
