import { Component, OnInit } from '@angular/core';
import { AllserviceService } from "../shared/allservice.service";
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent implements OnInit {

  constructor(private controller: AllserviceService, private httpClient: HttpClient, private router: Router) { }

  addproducts: Array<any>;
  addproductSelect: '';
  promotinoName: string;
  code: string;
  startDate: null;
  stopDate: null;
  betweens: string;
  staffNams: Array<any>;
  staffNameSelect: '';

  typePromotinoss: Array<any>;
  typePromotinosSelect: '';

  ngOnInit() {
    this.controller.getProduct().subscribe(on => {
      this.addproducts = on;
      console.log(this.addproducts);
    });

    this.controller.getStaff().subscribe(on => {
      this.staffNams = on;
      console.log(this.staffNams);
    });

    this.controller.getTypepromotion().subscribe(on => {
      this.typePromotinoss = on;
      console.log(this.typePromotinoss);
    });


  }


  insert() {
    if ( this.addproductSelect ==null ||this.promotinoName == null || this.code ==null || this.staffNameSelect == null || this.typePromotinosSelect == null) {
      alert('กรุณากรอกให้ครบถ้วน');}

    else {
      this.httpClient.post('http://localhost:8080/promotion/' + this.addproductSelect + '/' + this.promotinoName + '/' + this.code + '/' + this.startDate + '/' + this.stopDate + '/' + this.staffNameSelect + '/' + this.typePromotinosSelect, {})
      .subscribe()
    alert("บันทึกเรียบร้อย");
      }

    }




  show() {
    this.router.navigate(['promotion-show']);
  }





}
