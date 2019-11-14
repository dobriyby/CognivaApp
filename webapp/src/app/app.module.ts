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

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    UsersPageComponent,
    PushesPageComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [ HttpControlService  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
