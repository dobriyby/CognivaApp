import { Injectable } from '@angular/core';
import {HttpControlService} from "./http-control.service";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private _http: HttpControlService) { }

  login(login: string, password: string){
    this._http.login(login, password).subscribe(value => console.log('asd'));
  }

  isLogin() {
    return true;
  }
}
