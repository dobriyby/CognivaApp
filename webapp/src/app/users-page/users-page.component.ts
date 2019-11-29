import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {HttpControlService} from "../service/http-control.service";
import {FormControl, FormGroup} from "@angular/forms";
import {SessionService} from "../service/session.service";

class CUser{
  name: string;
  email: string;
  role: bigint [];
  password: string;

  constructor(user: string, role, email: string, password: string){
    this.name = user;
    this.email = email;
    this.role = [ role ];
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

  constructor(private _http: HttpControlService, private session: SessionService) {
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
    this.formGroup.controls.role.setValue(listRoles[0]);
  }

  add() {
    if(this.formGroup.valid){
      let user = new CUser(this.formGroup.controls.name.value,this.formGroup.controls.role.value,this.formGroup.controls.email.value,this.formGroup.controls.password.value);
      this._http.addUser(user).subscribe(()=> {this._http.getUsers().subscribe(value => this.listUsers = value)});
    }else{
      console.log('Form invalid');
    }
  }

  getListRole(role): String {
    let list = "";
    role.forEach(role => list+=role.name);
    return list;
  }
}
