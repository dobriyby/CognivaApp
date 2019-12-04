import {Component, OnInit} from '@angular/core';
import {Router, RouterModule} from "@angular/router";
import {Title} from "@angular/platform-browser";
import localeRu from '@angular/common/locales/ru'
import { registerLocaleData } from '@angular/common'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  titleMain = 'Cogniva WebUI';

  constructor(private title: Title){
    this.title.setTitle(this.titleMain);
    registerLocaleData(localeRu);
  }
  ngOnInit() {
  }
}
