import { Component, OnInit } from '@angular/core';
import { CheckmainService } from '../shared/CheckService/checkmain.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-checkmain',
  templateUrl: './checkmain.component.html',
  styleUrls: ['./checkmain.component.css']
})
export class CheckmainComponent implements OnInit {
    item: any;
    sub: any;

  FixAdd: any = {
    data: '',
    itemName: ''
    };

  instruType: Array <any>;
  instruTypeSelect: '';
  constructor(private checkmainService:CheckmainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.item = params;
        this.FixAdd.item = params.item;
        this.FixAdd.itemName = params.itemName;
        this.FixAdd.data = params.data;
        console.log(this.item);
    });

    this.checkmainService.getItem().subscribe(data => {
      this.item = data;
      console.log(this.item);
    });

    this.checkmainService.getInstruType().subscribe(data => {
      this.instruType = data;
      console.log(this.instruType);
    });

  }

  next(){
  this.router.navigate(['cusinfo/'+ this.FixAdd.itemName,{itemName:this.FixAdd.itemName, data:this.FixAdd.data, instruType:this.instruTypeSelect}]);
  }
}
