import { Component, OnInit } from '@angular/core';
import {ProserviceService} from '../shared/proservice/proservice.service';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-product-show',
  templateUrl: './product-show.component.html',
  styleUrls: ['./product-show.component.css']
})
export class ProductShowComponent implements OnInit {

  constructor(private controller:ProserviceService,private httpClient:HttpClient,private router:Router) { }
  product:Array<any>;
  ngOnInit() {
    this.controller.getProduct().subscribe(data =>{
      this.product = data;
      console.log(this.product);
    })
  }

}
