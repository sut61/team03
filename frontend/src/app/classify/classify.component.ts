import { Component, OnInit } from '@angular/core';
import {ClassifyService} from '../shared/classify/classify.service';
import {TokenService} from '../shared/token/token.service';
import {Router} from '@angular/router';

class ClassifyModel {
  name: string;
  detail: string;
  amount = 0;
  decreaseAble = false;
  classifyStatus: any;
}

@Component({
  selector: 'app-classify',
  templateUrl: './classify.component.html',
  styleUrls: ['./classify.component.css']
})
export class ClassifyComponent implements OnInit {

  classify: any;
  item: any;
  status: any;
  type: any;

  statusText: string;

  typeName: any;

  selectClassStatus: any;
  selectClassManage: any;
  selectItem: any;
  selectStatus: any;
  selectItemType: any;
  selectTypeItem: any;

  model = new ClassifyModel();

  errorMsg = 'something went wrong';

  constructor(private classifyService: ClassifyService, private token: TokenService, private route: Router) { }

  ngOnInit() {
    if (this.token.getUsername() !== 'admin') {
      this.route.navigate(['select']);
    }
    this.classifyService.getItem().subscribe(data => {
      this.item = data;
    });
    this.classifyService.getStatus().subscribe(data => {
      this.status = data;
    });
  }

  getClassify() {
    this.classifyService.getClass().subscribe(data => {
      this.classify = data;
    });
  }

  getType() {
    this.classifyService.getType().subscribe(data => {
      this.type = data;
    });
  }

  addClass() {
    this.statusText = undefined;
    this.classifyService.addClass(this.model).subscribe(data => {
      this.statusText = data;
    }, error => {
      this.statusText = this.errorMsg;
    });
  }

  addType() {
    this.statusText = undefined;
    this.classifyService.addType(this.typeName).subscribe(data => {
      this.statusText = data;
    }, error => {
      this.statusText = this.errorMsg;
    });
  }

  editClassStatus() {
    this.statusText = undefined;
    this.classifyService.manageStatus(this.selectStatus, this.selectClassStatus).subscribe(data => {
      this.statusText = data;
    }, error => {
      console.log(error);
      this.statusText = error.error;
    });
  }

  manageType() {
    this.statusText = undefined;
    this.classifyService.manageType(this.selectTypeItem, this.selectItemType).subscribe(data => {
      this.statusText = data;
    }, error => {
      this.statusText = error.error;
    });
  }

  manageClass() {
    this.statusText = undefined;
    this.classifyService.manageClass(this.selectClassManage, this.selectItem).subscribe(data => {
      this.statusText = data;
    }, error => {
      this.statusText = error.error;
    });
  }

}
