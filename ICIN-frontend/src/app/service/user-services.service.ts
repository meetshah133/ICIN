import { Injectable } from '@angular/core';
import { HttpClient,HttpParams,HttpHeaders} from '@angular/common/http';

import { User } from '../registration/subComponents/user-registration/user-registration.component';
import {Transaction} from '../transfer-funds/transfer-funds.component';
import { Deposit } from '../deposit-funds/deposit-funds.component';
import { ChequeBook } from '../chequebook-request/chequebook-request.component';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {

  constructor(private http:HttpClient) { }
  

  addUSerToDb(){
    
    console.log("Calling backend end point");
    //this.http.post("http://localhost:8090/register",user);
    //return this.http.get("http://localhost:8090/hello",{responseType: 'text'})
    return this.http.post("http://localhost:8090/register",
    new User(sessionStorage.getItem("firstName"),sessionStorage.getItem("lastName"),sessionStorage.getItem("mailid"),Number(sessionStorage.getItem("phonenumber")),sessionStorage.getItem("address"),sessionStorage.getItem("password"),null,null));
    
  }

  authenticateUser(user:User){
      console.log("Verifying user");
      return this.http.post("http://localhost:8090/login",user);
  }
  isUserLogin(){
    let user = sessionStorage.getItem("isAuthenticatedUser");
    return !(user===null);
  }

  getUserName(){
    return (sessionStorage.getItem("isAuthenticatedUser"));
  }

  transferFund(obj:Transaction){
    return this.http.post("http://localhost:8090/transfer",obj);
  }

  getAccountBalance(accountId){
    return this.http.get(`http://localhost:8090//accounts/${accountId}/balance`)
  }

  depositMoney( accType:String, accNo:number, amount:number){
  
  

    return this.http.get(`http://localhost:8090/deposit/${accType}/${accNo}/${amount}`);
  }

  requestChequeBook(chequeObj:ChequeBook,userObj:User){
    let objs = {
      "chequebook":chequeObj,
      "user":userObj
    }
    return this.http.post("http://localhost:8090//createcheque",chequeObj);
  }

  withdrawMoney(accType:String, accNo:number, amount:number){
    return this.http.get(`http://localhost:8090/withdraw/${accType}/${accNo}/${amount}`);
  }

  getTransactions(accountId){
    console.log(accountId);
    return this.http.get(`http://localhost:8090//accounts/${accountId}/transactions`)
  }
}
