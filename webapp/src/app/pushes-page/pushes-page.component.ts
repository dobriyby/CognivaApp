import { Component, OnInit } from '@angular/core';
import {HttpControlService} from "../service/http-control.service";
import {formatDate} from "@angular/common";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";

class CPush {
  sendDate:string;
  name:string;
  text:string;
  title:string;
}

@Component({
  selector: 'app-pushes-page',
  templateUrl: './pushes-page.component.html',
  styleUrls: ['./pushes-page.component.css']
})


export class PushesPageComponent implements OnInit {
  listPushes;
  listUsers;
  pushForm: FormGroup;


  constructor(private _http:  HttpControlService) {
   this._http.getAllPush().subscribe(value => this.fetchPushes(value));
   this._http.getUsers().subscribe(value=>this.fetchUsers(value));
  }

  ngOnInit() {
    this.pushForm =new FormGroup({
      text: new FormControl(),
      name: new FormControl(),
      date: new FormControl(),
      title: new FormControl()
    })
  }

  private fetchPushes(val){
    this.listPushes = val;
  }

  private fetchUsers(val) {
    this.listUsers = val;
    this.pushForm.controls.name.setValue(val[0].name);
  }

  private changeDateToText(date: Date){
    return formatDate(date,'dd MMMM yyyy HH:mm','ru');
  }

  add() {
    if(this.pushForm.valid){
      let push = new CPush();
      push.sendDate = this.pushForm.controls.date.value;
      push.name = this.pushForm.controls.name.value;
      push.text = this.pushForm.controls.text.value;
      push.title = this.pushForm.controls.title.value;
      console.log(push);
      this._http.addPushToUsername(push).subscribe((value) =>this._http.getAllPush().subscribe(value => this.fetchPushes(value)), (error) => console.log(error));
    }else{
      console.log('invalid form')
    }
  }


  onChangeUser(user) {
    this.pushForm.controls.name.setValue(user);
  }
}
