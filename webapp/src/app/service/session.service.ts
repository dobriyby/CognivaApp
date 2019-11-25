import { Injectable } from '@angular/core';
import {HttpControlService} from "./http-control.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private _http: HttpControlService) { }

  login(login: string, password: string): Observable<any>{
   return this._http.login(login, password);
  }

  isLogin() {
    return true;
  }
}
