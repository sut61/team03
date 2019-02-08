import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {CommentService} from '../shared/comment/comment.service';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent implements OnInit {
  members: Array<any>;
  memberSelect = '';

  servicetypes: Array<any>;
  servicetypeSelect = '';

  scores: Array<any>;
  scoreSelect = '';

  reviews: Array<any>;
  review: string;
  review2: string;

  displayedColumns: string[] = [ 'id' , 'userName' , 'typeService' , 'score' , 'commentPositive' , 'commentNegative' ];

  constructor(private router: Router , private  httpClient: HttpClient , private commentSerivce: CommentService) { }
  ngOnInit() {
    this.commentSerivce.getMember().subscribe(data => {
      this.members = data;
      console.log(this.members);
    });
    this.commentSerivce.getServiceType().subscribe(data => {
      this.servicetypes = data;
      console.log(this.servicetypes);
    });
    this.commentSerivce.getScore().subscribe(data => {
      this.scores = data;
      console.log(this.scores);
    });
    this.commentSerivce.getReview().subscribe(data => {
      this.reviews = data;
      console.log(this.reviews);
    });
 }


  insert() {
    if (this.review == null || this.memberSelect == null || this.servicetypeSelect == null || this.scoreSelect == null || this.review2 == null ) {
      alert('กรอกข้อมูลให้ครบ');
    } else {
      this.httpClient.post('http://localhost:8080/comment/review/' + this.review + '/' + this.review2 + '/' + this.memberSelect + '/' + this.servicetypeSelect + '/' + this.scoreSelect  , {}).subscribe()
      alert('สำเร็จ');
      this.router.navigate(['']);
    }
  }


}
