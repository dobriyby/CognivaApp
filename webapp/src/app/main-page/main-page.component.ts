import {Component, NgModule, OnInit} from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {UsersPageComponent} from "../users-page/users-page.component";
import {PushesPageComponent} from "../pushes-page/pushes-page.component";
import {RolesPageComponent} from "../roles-page/roles-page.component";


@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})


export class MainPageComponent implements OnInit {

  constructor() {

  }

  ngOnInit() {
  }

}
