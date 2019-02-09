import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {TokenService} from './shared/token/token.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private route: Router, private token: TokenService) {}

  isLogin(): boolean {
    return !!this.token.getUsername();
  }

  isAdmin(): boolean {
    return (this.isLogin() && this.token.getUsername() === 'admin');
  }

  isUser(): boolean {
    return (this.isLogin() && this.token.getUsername() !== 'admin');
  }

  gotoRoom() {
    this.route.navigate(['/room']);
  }

  gotoCourseReserve() {
    this.route.navigate(['/coursereserve']);
  }

  gotoSelect() {
    this.route.navigate(['select']);
  }

  gotoLogin() {
    this.route.navigate(['login']);
  }

  signOut() {
    this.token.signOut();
    this.gotoLogin();
  }
  gotoPay() {
    this.route.navigate(['/paidtable']);
  }
  gotoMain() {
    this.route.navigate(['main']);
  }

  gotoBill() {
    this.route.navigate(['/bill']);
  }
  gotoComment() {
    this.route.navigate(['/comment']);
  }
  gotoPromotion() {
    this.route.navigate(['/promotion']);
  }

  gotoClassify() {
    this.route.navigate(['/classify']);
  }

}
