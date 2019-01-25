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
//
//   other:String;
//   date:null;
//
// //Addpoint
//   addPoints : Array<any>;
//   addPointSelect: '';
//   // constructor() { }
//
//   //nameStaff
//   nameStaffs : Array<any>;
//   nameStaffSelect:'';
//
//   //nameCustomer
//   nameCustomers : Array<any>;
//   nameCustomerSelect:'';
//
//
//
//   data:any = {
//
//
//   }
//
//   ngOnInit() {
//     this.controller.getAddpoint().subscribe(on =>{
//       this.addPoints = on;
//       console.log(this.addPoints);
//     });
//
//     this.controller.getStaffxy().subscribe(on =>{
//       this.nameStaffs = on;
//       console.log(this.nameStaffs);
//     });
//
//     this.controller.getMemberxy().subscribe(on =>{
//       this.nameCustomers = on;
//       console.log(this.nameCustomers);
//     });
//   }
//
//
//
//   // SubmittedData(){
//   //   console.log(this.data)
//   //   const data  = this.data
//   //   if (this.select.usernameSelect === '' || this.select.paymentSelect === '' || this.select.areaSelect === '' || this.pickLocation === '' || this.dropLocation === '') {
//   //     alert('กรุณากรอกข้อมูลให้ครบถ้วน');
//   //   } else {
//   //     this.router.navigate(['bike-show',{
//   //       username: data.username = this.cus.name,
//   //       payments:  data.payments = this.pm.paymentType,
//   //       areas:     data.areas = this.ap.areaType,
//   //       pickLocation: data.pickLocation = this.pickLocation,
//   //       dropLocation: data.dropLocation = this.dropLocation,
//   //       totalPrice: data.totalPrice = 20 + this.ap.areaPrice
//   //     }])
//   //   }
//   // }
//
// //   SubmittedData(){
// //     console.log(this.data)
// //     const data = this.data
// //
// //     this.router.navigate(['point-check',{
// // date: data.date = this.date;
// //
// //
// //
// //     }])
// //
// //   }
//
//
//
//
//   insert(){
//     this.httpClient.post('http://localhost:8080/point/'+this.other+'/'+this.date+'/'+this.addPointSelect+'/'+this.nameCustomerSelect+'/'+this.nameStaffSelect,   {})
//       .subscribe()
//     alert("สำเร็จ");
//     this.router.navigate(['']);
//
//   }





}
