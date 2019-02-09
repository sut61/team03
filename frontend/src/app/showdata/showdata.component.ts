import { Component, OnInit } from '@angular/core';
import { CheckmainService } from '../shared/CheckService/checkmain.service';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-showdata',
  templateUrl: './showdata.component.html',
  styleUrls: ['./showdata.component.css']
})
export class ShowdataComponent implements OnInit {
  fix: any;
  sub: any;

  fixData: any;
  constructor(private checkmainService:CheckmainService,private httpClient: HttpClient,private router: Router,private rout: ActivatedRoute) { }

  ngOnInit() {
    this.sub = this.rout.params.subscribe(params => {
        this.fix = params;
        console.log(this.fix);
    });

    this.checkmainService.getFixmain(this.fix.idFix).subscribe(data => {
      this.fixData = data;
      console.log(this.fixData);
    });
  }

}
