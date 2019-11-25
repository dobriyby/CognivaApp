import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {SessionService} from "../service/session.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private session: SessionService, private http: HttpClient) {
    this.loginForm = new FormGroup({
      login: new FormControl(),
      password: new FormControl()
    })
  }

  ngOnInit() {
  }

  // login(){
  //   this.session.login(this.loginForm.controls.login.value, this.loginForm.controls.password.value).subscribe( value => console.log(value));
  // }

  login(){
    let user = {"name":"dobriy", "password":"pass","email":"test","active":true}
    this.http.post("http://localhost:8080/api/login",user).subscribe((isValid)=> console.log(isValid));
  }
}
