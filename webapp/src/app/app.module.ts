import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MainPageComponent } from './main-page/main-page.component';
import { UsersPageComponent } from './users-page/users-page.component';
import { PushesPageComponent } from './pushes-page/pushes-page.component';
import {HttpControlService} from "./service/http-control.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {HeaderComponent} from "./header/header.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { LeftmenuComponent } from './leftmenu/leftmenu.component';
import { RolesPageComponent } from './roles-page/roles-page.component';
import { LoginPageComponent } from './login-page/login-page.component';
import {SessionService} from "./service/session.service";
import {RoutHandler, RoutHandlerModule} from "./rout-handler.module";

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    UsersPageComponent,
    PushesPageComponent,
    HeaderComponent,
    LeftmenuComponent,
    RolesPageComponent,
    LoginPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [ HttpControlService , SessionService ],
  bootstrap: [AppComponent],
  entryComponents: [MainPageComponent,UsersPageComponent,PushesPageComponent,HeaderComponent,LeftmenuComponent,RolesPageComponent,LoginPageComponent]
})
export class AppModule {
}
