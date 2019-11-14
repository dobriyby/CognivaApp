import { Component, OnInit } from '@angular/core';
import {HttpControlService} from "../service/http-control.service";
import {formatDate} from "@angular/common";


@Component({
  selector: 'app-pushes-page',
  templateUrl: './pushes-page.component.html',
  styleUrls: ['./pushes-page.component.css']
})
export class PushesPageComponent implements OnInit {
  listPush;

  constructor(private _http:  HttpControlService) {
   this._http.getAllPush().subscribe(value => this.fetch(value));
  }

  ngOnInit() {
  }

  private fetch(val){
    this.listPush = val;
  }

  private changeDateToText(date: Date){
    return formatDate(date,'dd MMMM yyyy HH:mm','ru');
  }

}
