import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {SessionService} from "../service/session.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  loginForm: FormGroup;

  constructor(private session: SessionService) {
    this.loginForm = new FormGroup({
      login: new FormControl(),
      password: new FormControl()
    })
  }

  ngOnInit() {
  }

  login(){
    this.session.login(this.loginForm.controls.login.value, this.loginForm.controls.password.value);
  }

}
