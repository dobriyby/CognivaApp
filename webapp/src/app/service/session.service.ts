import { Injectable } from '@angular/core';
import {HttpControlService} from "./http-control.service";
import {Observable} from "rxjs";
import {RouterModule, Routes} from "@angular/router";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor(private _http: HttpControlService) {
  }

  login(user): Observable<any>{
   return this._http.login(user);
  }

  isLogin() {
    console.log(this.getUser()!=undefined);
    return sessionStorage.getItem("user")!=undefined;
  }

  getUser(){
    return JSON.parse(sessionStorage.getItem("user"));
  }
  public setUser(user){
    sessionStorage.setItem("user",JSON.stringify(user));
  }

  hasRole(roleName: string): boolean{
    let result = false;
    let user = this.getUser();
    if(user !=undefined){
      user.role.forEach((role) =>  {
        if(role.name == roleName){
          result = true;
        }
      });
    }
    return result;
  }

}


