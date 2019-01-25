import { Component, OnInit } from '@angular/core';
import { MainService } from '../shared/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-delivery1',
  templateUrl: './delivery1.component.html',
  styleUrls: ['./delivery1.component.css']
})
export class Delivery1Component implements OnInit {
  sub: any;
  item: any;
  province: Array <any>;
  provinceSelect: '';
  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
      this.item = params;
      console.log(this.item);
    });

    this.mainService.getProvince().subscribe(data => {
      this.province = data;
      console.log(this.province);
    });
  }
 next(){
  this.router.navigate(['transport_next/' + this.provinceSelect,{
      item:this.item.itemId, itemNum:this.item.itemNum, province:this.provinceSelect}]);
  }

 }


