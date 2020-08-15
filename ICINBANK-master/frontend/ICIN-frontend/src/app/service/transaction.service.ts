import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {

  constructor(private http: HttpClient) { }

  accountNo:number
  amount:bigint
  forDeposit(){
    return this.http.post("http://localhost:8090/deposit",{accType : "Primary",accNo : this.accountNo, amount : this.amount});
  }
  forWithdraw(){
    return this.http.post("http://localhost:8090/withdraw",{accType : "Primary",accNo : this.accountNo, amount : this.amount});
  }
}
