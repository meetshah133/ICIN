import { Component, OnInit } from '@angular/core';
import {AccountService} from 'src/app/service/account.service';
import { Router } from '@angular/router';
// export class Savings{
//   private id:number
//     private  balance:bigint
//     private  accountNo:number
//   constructor( ){
      
//     }
 
// }
@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  savings : any ; 
  responseData: any;
  constructor( private account : AccountService, private router:Router) { }

  ngOnInit(): void {
    // since there is no button to call an api, you need to use oninit
    this.getBalance();
  }

  getBalance(){
    console.log("entered");
    let response = this.account.getBal();
    console.log(response.subscribe(data => this.savings = data));
    console.log(this.savings);
  }
  handleDeposit(){
    this.router.navigate(["user","deposit"]);

  }
  handleWithdraw(){
    this.router.navigate(["user","withdraw"]);

  }

}
