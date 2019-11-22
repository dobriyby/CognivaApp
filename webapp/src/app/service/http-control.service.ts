import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

const host = "http://localhost:8080/api";

@Injectable({
  providedIn: 'root'
})

export class HttpControlService {
  private listPush;



  constructor(private http: HttpClient) { }

  getAllPush(): Observable<any>{
    return  this.http.get(host+'/push/all');
  }

  addPushToUsername(push, name): Observable<any>{
    let body = { 'push': JSON.stringify(push), 'name': name};
    return this.http.post(host+'/push/AddPushToUserName',body);
  }

  getUsers(){
    return this.http.get(host+'/users')
  }

  getRoles(){
    return this.http.get(host+'/roles')
  }

  addUser(user) : Observable<any> {
    console.log(user);
    return this.http.post(host+'/users/create',user)
  }

  addRole(role) : Observable<any> {
    return this.http.post(host+'/roles/create',role)
  }

  login(login: string, password: string): Observable<any>{
    let user = { name: login, password: password};
    return this.http.post(host+"/login",user);
  }
}
