import { Component, OnInit } from '@angular/core';
import { MainService } from '../shared/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-delivery3',
  templateUrl: './delivery3.component.html',
  styleUrls: ['./delivery3.component.css']
})
export class Delivery3Component implements OnInit {
  sub: any;
  item: any;

  shopAdd: any = {
    name: '',
    tel: '',
    email: '',
    address: '',
    username: '',
    item: '',
    itemNum: '',
    district: ''
  };

  shop: any;

  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) {}

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.item = params;
        this.shopAdd.username = params.username;
        this.shopAdd.item = params.item;
        this.shopAdd.itemNum = params.itemNum;
        this.shopAdd.district = params.district
        console.log(this.item);
    });
  }
   next(){
      if (this.shopAdd.name === '' || this.shopAdd.tel === '' || this.shopAdd.email === '' || this.shopAdd.address === ''){
        alert('กรุณากรอกข้อมูลให้ครบถ้วน');
    }else {
      this.httpClient.post('http://localhost:8080/Customer/add/' + this.shopAdd.username + '/' + this.shopAdd.name + '/' +
        this.shopAdd.tel + '/' + this.shopAdd.email + '/' + this.shopAdd.address + '/' + this.shopAdd.item
         + '/' + this.shopAdd.itemNum + '/' + this.shopAdd.district ,this.shopAdd)
      .subscribe(
        data => {
          this.shop = data;
          console.log('PUT Request is successful', data);
          if(data){
            this.router.navigate(['infomation_final/' + this.shop.shopId,{username:this.item.username, shop:this.shop.shopId, province:this.item.province}]);
            alert('สั่งซื้อสำเร็จ');
          }
        },
        error => {
          console.log('Error', error);
        }
      );
    }

  }
}
