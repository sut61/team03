import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../shared/login/login.service';
import {TokenService} from '../shared/token/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: any = {
    username: '',
    password: ''
  };

  constructor(private route: Router, private loginService: LoginService, private token: TokenService) { }

  ngOnInit() {
  }

  login() {
    this.loginService.signin(this.user).subscribe(value => {}, error1 => {}, () => {
      this.token.saveUsername(this.user.username);
      // redirect to component
      // this.route.navigate(['select']);
    });
  }

}
