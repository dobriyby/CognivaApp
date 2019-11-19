import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Observer} from "rxjs";
import { of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpControlService {
  private listPush;
  constructor(private http: HttpClient) { }

  getAllPush(): Observable<any>{
    return  this.http.get('http://localhost:8080/push/all');
  }

  addPushToUsername(push, name): Observable<any>{
    console.log(push.sendtime,name);
    let body = { 'push': JSON.stringify(push), 'name': name};
   return this.http.post('http://localhost:8080/push/AddPushToUserName',body);
  }

  getUsers(){
    return this.http.get('http://localhost:8080/users')
  }

  addUser(user) : Observable<any> {
    return this.http.post('http://localhost:8080/users/create',user)
  }
}
