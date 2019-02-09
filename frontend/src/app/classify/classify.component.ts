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

  constructor(private classifyService: ClassifyService, private token: TokenService, private route: Router) { }

  ngOnInit() {
    if (this.token.getUsername() !== 'admin') {
      this.route.navigate(['select']);
    }
    this.classifyService.getClass().subscribe(data => {
      this.classify = data;
    });
    this.classifyService.getItem().subscribe(data => {
      this.item = data;
    });
    this.classifyService.getStatus().subscribe(data => {
      this.status = data;
    });
    this.classifyService.getType().subscribe(data => {
      this.type = data;
    });
  }

  addClass() {
    this.statusText = undefined;
    this.classifyService.addClass(this.model).subscribe(data => {}, error => {
      this.statusText = 'บางอย่างไม่ถูกต้อง';
    }, () => {
      this.statusText = 'บันทึกสำเร็จ';
    });
  }

  addType() {
    this.statusText = undefined;
    this.classifyService.addType(this.typeName).subscribe(data => {}, error => {
      this.statusText = 'บางอย่างไม่ถูกต้อง';
    }, () => {
      this.statusText = 'บันทึกสำเร็จ';
    });
  }

  editClassStatus() {
    this.statusText = undefined;
    this.classifyService.manageStatus(this.selectStatus, this.selectClassStatus).subscribe(data => {}, error => {
      this.statusText = 'บางอย่างไม่ถูกต้อง';
    }, () => {
      this.statusText = 'บันทึกสำเร็จ';
    });
  }

  manageType() {
    this.statusText = undefined;
    this.classifyService.manageType(this.selectTypeItem, this.selectItemType).subscribe(data => {}, error => {
      this.statusText = 'บางอย่างไม่ถูกต้อง';
    }, () => {
      this.statusText = 'บันทึกสำเร็จ';
    });
  }

  manageClass() {
    this.statusText = undefined;
    this.classifyService.manageClass(this.selectClassManage, this.selectItem).subscribe(data => {}, error => {
      this.statusText = 'บางอย่างไม่ถูกต้อง';
    }, () => {
      this.statusText = 'บันทึกสำเร็จ';
    });
  }

}
