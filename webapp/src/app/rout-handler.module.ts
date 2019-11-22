import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, ROUTES} from "@angular/router";
import {SessionService} from "./service/session.service";
import {MainPageComponent} from "./main-page/main-page.component";
import {UsersPageComponent} from "./users-page/users-page.component";
import {PushesPageComponent} from "./pushes-page/pushes-page.component";
import {RolesPageComponent} from "./roles-page/roles-page.component";
import {LoginPageComponent} from "./login-page/login-page.component";



@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ],
  providers: [
    {
      provide: ROUTES,
      useFactory: RoutHandler,
      deps: [SessionService],
      multi: true
    }]
})

export class RoutHandlerModule { }

export function RoutHandler(session: SessionService ){
  let routes: Routes = [];
  if(session.isLogin()){
    routes =  [
      {path: '' , component: MainPageComponent, children: [
          {path: 'users' , component: UsersPageComponent},
          {path: 'pushes' , component: PushesPageComponent},
          {path: 'roles' , component: RolesPageComponent}
        ]},
      {path: 'login' , component: LoginPageComponent}
     ]
  }else{
    routes = [
      {path: '**', component: LoginPageComponent}
    ]
  }
  return routes
}
