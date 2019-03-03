import { Component, OnInit } from '@angular/core';
import { BillService } from '../shared/bill/bill.service';
import { Router } from '@angular/router';
import { TokenService } from '../shared/token/token.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.css']
})
export class BillComponent implements OnInit {
  paidStatuses: Array<any>;
  members: Array<any>;
  bills: Array<any>;
  contacts: Array<any>;

  billSelect: number;
  InputName: String;
  InputTel: String;
  Inputdetail: String;
  Inputprice: number;
  paidStatusSelect: number;

  showCheck: String;

  constructor(private billService: BillService, private route: Router, private token: TokenService) { }

  ngOnInit() {
    this.getBillList();
    this.billService.getPaidStatus().subscribe(data => {
      this.paidStatuses = data;
      console.log(this.paidStatuses);
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

  postBill() {
    if(this.billSelect === 0 || this.InputName === '' || this.InputTel === '' || this.Inputdetail === ''|| this.Inputprice === 0 ||
    this.paidStatusSelect === 0) {

    this.showCheck = "กรุณากรอกข้อมูลให้ครบถ้วน"
  }
    else{
      this.billService.addDamageBill( this.billSelect, this.InputName, this.InputTel, this.Inputdetail, this.Inputprice,
        this.paidStatusSelect, this.token.getUsername() ).subscribe(
        data => {
          this.getBillList();
          this.showCheck = "การเพิ่มข้อมูลสำเร็จ"
        },
        error => {
          console.log("Error", error);
          this.showCheck = "เกิดข้อผิดพลาด"
        }
      );

  }


}
}
