import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HttpControlService} from "../service/http-control.service";
import {SessionService} from "../service/session.service";

@Component({
  selector: 'app-roles-page',
  templateUrl: './roles-page.component.html',
  styleUrls: ['./roles-page.component.css']
})
export class RolesPageComponent implements OnInit {

  listRoles;
  formGroup:FormGroup;

  constructor(private _http: HttpControlService, private session: SessionService) {
    this._http.getRoles().subscribe(value => this.listRoles = value);
  }

  ngOnInit() {
    this.formGroup = new FormGroup({
      name: new FormControl()
    })
  }

  add() {
    if(this.formGroup.valid){
      this._http.addRole(this.formGroup.controls.name.value).subscribe( () => this._http.getRoles().subscribe(value => this.listRoles = value));
    }else{
      console.log('Form invalid')
    }

  }
}
