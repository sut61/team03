import { Component, OnInit } from '@angular/core';
import {AllserviceService} from "../shared/allservice.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-promotion-show',
  templateUrl: './promotion-show.component.html',
  styleUrls: ['./promotion-show.component.css']
})
export class PromotionShowComponent implements OnInit {

  constructor(private controller:AllserviceService,private httpClient:HttpClient,private router:Router) { }
promotions:Array<any>;
  ngOnInit() {

    this.controller.getPromotion().subscribe(data =>{
      this.promotions = data;
      console.log(this.promotions);
    })
  }

}
