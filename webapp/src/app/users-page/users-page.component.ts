import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpControlService} from "../service/http-control.service";
import {FormControl, FormGroup} from "@angular/forms";

class CUser{
  name: string;
  email: string;

  constructor(user: string, email: string){
    this.name = user;
    this.email = email;
  }
}

@Component({
  selector: 'app-users-page',
  templateUrl: './users-page.component.html',
  styleUrls: ['./users-page.component.css']
})
export class UsersPageComponent implements OnInit {
  listUsers;
  formGroup: FormGroup;

  constructor(private _http: HttpControlService) {
    this._http.getUsers().subscribe(value => this.listUsers = value);

  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl(),
      email: new FormControl()
    })
  }

  add() {
    if(this.formGroup.valid){
      let user = new CUser(this.formGroup.controls.name.value,this.formGroup.controls.email.value);
      this._http.addUser(user).subscribe(()=> {this._http.getUsers().subscribe(value => this.listUsers = value)});
    }else{
      console.log('Form invalid');
    }
  }
}
