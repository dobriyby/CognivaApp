import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {SessionService} from "../service/session.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {error} from "util";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private session: SessionService,private rout: Router, private http: HttpClient) {
    this.loginForm = new FormGroup({
      login: new FormControl(),
      password: new FormControl()
    })
  }

  ngOnInit() {
    sessionStorage.clear();
  }

  login(){
    let user = new FormData();
    user.append("username",this.loginForm.controls.login.value);
    user.append("password",this.loginForm.controls.password.value);
    this.session.login(user).subscribe( res => this.successHandler(res), error => console.log(error.error.message));
  }

  successHandler(res){
    this.session.setUser(res.body);
    this.session.setToken(res.headers.get('Authorization'));
    this.rout.navigateByUrl("/");
  }

}
