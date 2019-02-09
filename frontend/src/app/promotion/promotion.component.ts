import { Component, OnInit } from '@angular/core';
import {AllserviceService} from "../shared/allservice.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-promotion',
  templateUrl: './promotion.component.html',
  styleUrls: ['./promotion.component.css']
})
export class PromotionComponent implements OnInit {

  constructor(private controller:AllserviceService,private httpClient:HttpClient,private router:Router) { }

  // private String addproduct;
  addproducts:Array<any>;
  addproductSelect:'';

  // private String promotinoName;
  // private String code;
  // Date startDate;
  //
  // @Temporal(TemporalType.DATE)
  // private @io.micrometer.core.lang.NonNull
  // Date stopDate;
  promotinoName:string;
  code:string;
  startDate:null;
  stopDate:null;
  // stopDate:null;
  betweens:string;
  // private String betweens



  // private String staffName;
  staffNams:Array<any>;
  staffNameSelect:'';

  // private String typePromotinos;
  typePromotinoss:Array<any>;
  typePromotinosSelect:'';

  ngOnInit() {
    this.controller.getProduct().subscribe(on =>{
      this.addproducts = on;
      console.log(this.addproducts);
    });

    this.controller.getStaff().subscribe(on =>{
      this.staffNams = on;
      console.log(this.staffNams);
    });

    this.controller.getTypepromotion().subscribe(on =>{
      this.typePromotinoss = on;
      console.log(this.typePromotinoss);
    });


  }


// @PostMapping(path = "/promotion/{addproduct}/{promotinoName}/{code}/{startDate}/{stopDate]/{staffName}/{typePromotinos}")
//   insert(){
//     this.httpClient.post('http://localhost:8080/point/'+this.other+'/'+this.date+'/'+this.addPointSelect+'/'+this.nameCustomerSelect+'/'+this.nameStaffSelect,   {})
//       .subscribe()
//     alert("สำเร็จ");
//     this.router.navigate(['']);
//
//   }

  // @PostMapping(path = "/promotion/{addproduct}/{promotinoName}/{code}/{startDate}/{endDate}/{betweens]/{staffName}/{typePromotinos}")
  insert(){
    this.httpClient.post('http://localhost:8080/promotion/'+this.addproductSelect+'/'+this.promotinoName+'/'+this.code+'/'+this.startDate+'/'+this.stopDate+'/'+this.betweens+'/'+this.staffNameSelect+'/'+this.typePromotinosSelect,{})
      .subscribe()
  alert("บันทึกเรียบร้อย");
    this.router.navigate(['']);

}
show(){
  this.router.navigate(['promotion-show']);
}





}
