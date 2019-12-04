import { Component, OnInit } from '@angular/core';
import {SessionService} from "../service/session.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  userName: string;

  constructor(private session: SessionService) { }

  ngOnInit() {
    // console.log(this.session.getUser());
    if (this.session.getUser() != undefined) {
      this.userName = this.session.getUser().name
    }
  }

}
