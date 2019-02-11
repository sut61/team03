import { Component, OnInit } from '@angular/core';
import { CheckmainService } from '../shared/CheckService/checkmain.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-checkmanager',
  templateUrl: './checkmanager.component.html',
  styleUrls: ['./checkmanager.component.css']
})
export class CheckmanagerComponent implements OnInit {

  item: any;
  sub: any;

  setFix:any = {
    managerName : '',
    cost : '',
    itemName: '',
    data: '',
    instruType: '',
    name: '',
    tel: '',
    email: ''
  }

  fix: any;
  showError : String;
  constructor(private checkmainService:CheckmainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.item = params;
        this.setFix.itemName = this.item.itemName;
        this.setFix.data = this.item.data;
        this.setFix.instruType = this.item.instruType;
        this.setFix.name = this.item.name;
        this.setFix.tel = this.item.tel;
        this.setFix.email = this.item.email;
        //this.setFix.cost = this.item.cost;
        //this.setFix.managerName = this.item.managerName;
        console.log(this.item);
        console.log(this.setFix);
    });
  }

  next(){
    this.httpClient.post('http://localhost:8080/FixMain/add/' + this.setFix.managerName + '/' + this.setFix.cost + '/' +
        this.setFix.itemName + '/' + this.setFix.data + '/' + this.setFix.instruType + '/' + this.setFix.name
         + '/' + this.setFix.tel + '/' + this.setFix.email ,this.setFix)
      .subscribe(
        data => {
          console.log('PUT Request is successful', data);
          this.fix = data;
          if(data){
            this.router.navigate(['showdata/' + this.fix.fixMainId]);
            this.showError = "บันทึกรายละเอียดสำเร้จ"
          }
        },
        error => {
          console.log('Error', error);
            this.showError = "การทำบันทึกรายละเอียดไม่สำเร้จ"
        }
      );
  }

}
