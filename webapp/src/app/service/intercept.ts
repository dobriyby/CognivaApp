import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {SessionService} from "./session.service";
import {Injectable} from "@angular/core";

@Injectable()
export class Intercept implements HttpInterceptor {

  constructor(private session: SessionService){}


  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token = this.session.getToken();
    console.log('Intercept with token: '+token);
    if(token!=null){
      let clone = req.clone({headers:req.headers.set("Authorization",token as string)});
      return next.handle(clone)//.pipe(tap(ev => console.log(ev)))
    }else{
      return next.handle(req)//.pipe(tap(ev => console.log(ev)))
    }
  }
}
