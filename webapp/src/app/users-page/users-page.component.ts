import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpControlService} from "../service/http-control.service";
import {FormControl, FormGroup} from "@angular/forms";

class CUser{
  name: string;
  email: string;
  role_id: bigint;
  password: string;

  constructor(user: string, role, email: string, password: string){
    this.name = user;
    this.email = email;
    this.role_id = role;
    this.password = password;
  }
}

@Component({
  selector: 'app-users-page',
  templateUrl: './users-page.component.html',
  styleUrls: ['./users-page.component.css']
})
export class UsersPageComponent implements OnInit {

  listRoles;
  listUsers;
  formGroup: FormGroup;

  constructor(private _http: HttpControlService) {
    this._http.getUsers().subscribe(value => this.fetchUser(value));
    this._http.getRoles().subscribe(value => this.fetchRole(value));

  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl(),
      role: new FormControl(),
      password: new FormControl(),
      email: new FormControl()
    })
  }

  fetchUser(listUsers){
    this.listUsers = listUsers;
  }

  fetchRole(listRoles){
    this.listRoles = listRoles;
    console.log(this.listRoles[0]);
    this.formGroup.controls.role.setValue(listRoles[0]);
  }

  add() {
    console.log(this.formGroup.controls.role.value);
    if(this.formGroup.valid){
      console.log(this.formGroup.controls.role.value);
      let user = new CUser(this.formGroup.controls.name.value,this.formGroup.controls.role.value,this.formGroup.controls.email.value,this.formGroup.controls.password.value);
      this._http.addUser(user).subscribe(()=> {this._http.getUsers().subscribe(value => this.listUsers = value)});
    }else{
      console.log('Form invalid');
    }
  }

  onChangeRole(role) {
    this.listUsers.controls.role.setValue(role);
  }
}
