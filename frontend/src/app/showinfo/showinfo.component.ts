import { Component, OnInit } from '@angular/core';
import { MainService } from '../shared/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-showinfo',
  templateUrl: './showinfo.component.html',
  styleUrls: ['./showinfo.component.css']
})
export class ShowinfoComponent implements OnInit {
  sub: any;
  customer: any;
  shop: any;
  province: any;

  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.customer = params;
        console.log(this.customer);
    });

    this.mainService.getShop(this.customer.shop).subscribe(data => {
      this.shop = data;
      console.log(this.shop);
    });

    this.mainService.getDistrict(this.customer.province).subscribe(data => {
      this.province = data;
      console.log(this.province);
    });
  }



}
