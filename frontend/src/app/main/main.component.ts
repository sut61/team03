import { Component, OnInit } from '@angular/core';
import { MainService } from '../shared/main.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';


@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {

  private customer :any;

  cus : any ={
    id : '',
    customerName : '',
    tel : '',
    email : ''
  };

  item: any = {
    itemId: '',
    itemName: '',
    price: '',
    numItem: ''
  };


  constructor(private mainService:MainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute){}

  ngOnInit() {
    this.rout.params.subscribe(prams=>{
        this.customer = prams
        console.log(this.customer)
    })

    this.mainService.getItem().subscribe(data => {
      this.item = data;
      console.log(this.item);
    });

  }

  add(itemId,itemNum){
    this.router.navigate(['transport/' + itemId,{itemId:itemId, itemNum:itemNum}]);
  }

}
