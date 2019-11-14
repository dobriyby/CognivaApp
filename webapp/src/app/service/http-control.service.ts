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
}
