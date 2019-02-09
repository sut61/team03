import { Component, OnInit } from '@angular/core';
import { ProserviceService } from '../shared/proservice/proservice.service';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";

@Component({
  selector: 'app-addproduct',
  templateUrl: './addproduct.component.html',
  styleUrls: ['./addproduct.component.css']
})
export class AddproductComponent implements OnInit {
  constructor(private controller: ProserviceService, private httpClient: HttpClient, private router: Router) { }

  typeproducts: Array<any>;
  selecttypeproduct: '';


  nameproduct: string;
  number: '';
  price: '';
  saleprice: '';
  date: null;

  ngOnInit() {
    this.controller.getTypeproduct().subscribe(data => {
      this.typeproducts = data;
      console.log(this.typeproducts);
    });
  }
  insert() {
    if ( this.selecttypeproduct ==null ||this.nameproduct == null || this.number ==null || this.price == null || this.saleprice == null) {
      alert('กรุณากรอกให้ครบถ้วน');}

    else {
        this.httpClient.post('http://localhost:8080/product/' + this.selecttypeproduct + '/' + this.nameproduct + '/' + this.number + '/' + this.price + '/' + this.saleprice + '/' + this.date, {})
          .subscribe()
        alert("บันทึกเรียบร้อย");
        this.router.navigate(['product']);
      }

    }
    
       show(){
       this.router.navigate(['product-show']);
     }

  }





