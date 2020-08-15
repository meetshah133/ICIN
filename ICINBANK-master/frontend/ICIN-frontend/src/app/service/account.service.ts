import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { User } from '../registration/subComponents/user-registration/user-registration.component';


@Injectable({
  providedIn: 'root'
})
export class AccountService {

  constructor( private http: HttpClient) { }

  public getBal()
  {
    console.log(sessionStorage.getItem("mailid"));
    return this.http.post("http://localhost:8090/home",sessionStorage.getItem("mailid"));
  }
  /* public getBalance()
  {
    return this.http.get("http://localhost:8090/home");
  } */

}
