import { Component, OnInit } from '@angular/core';
import { MainService } from '../shared/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-delivery2',
  templateUrl: './delivery2.component.html',
  styleUrls: ['./delivery2.component.css']
})
export class Delivery2Component implements OnInit {
  sub: any;
  item: any;
  districtSelect: '';
  province: any;
  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.item = params;
        console.log(this.item);
    })

    this.mainService.getDistrict(this.item.province).subscribe(data => {
      this.province = data;
      console.log(this.province);
    });

  }
  next(){
    this.router.navigate(['transport_final/' + this.districtSelect,{item:this.item.item,
      itemNum:this.item.itemNum, province:this.item.province, district:this.districtSelect}]);
  }
}
