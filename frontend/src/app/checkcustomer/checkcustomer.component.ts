import { Component, OnInit } from '@angular/core';
import { CheckmainService } from '../shared/CheckService/checkmain.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-checkcustomer',
  templateUrl: './checkcustomer.component.html',
  styleUrls: ['./checkcustomer.component.css']
})
export class CheckcustomerComponent implements OnInit {
  item: any;
  sub: any;

  name = '';
  tel = '';
  email = '';

  constructor(private checkmainService:CheckmainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.item = params;
        console.log(this.item);
    });
  }
   next(){
  this.router.navigate(['managerinfo/'+this.item.itemName,{itemName:this.item.itemName, data:this.item.data, instruType:this.item.instruType,
                          name:this.name, tel:this.tel, email:this.email}]);
  }
}
