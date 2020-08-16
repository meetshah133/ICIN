import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserServicesService } from '../service/user-services.service';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  constructor(private router:Router,private service:UserServicesService) { }
  primaryAccountBalance;
  savingAccountBalance;
  ngOnInit(): void {
    
    this.savingAccountBalance = sessionStorage.getItem("savingAccountBalance")
    this.service.getAccountBalance(Number(sessionStorage.getItem("primaryAccountNumber"))).subscribe(
      response => {
        this.primaryAccountBalance = response;
        sessionStorage.setItem("primaryAccountBalance",this.primaryAccountBalance)
      },
      error =>{
        console.log(error);
      }
    )
    this.service.getAccountBalance(Number(sessionStorage.getItem("savingAccountNumber"))).subscribe(
      response => {
        this.savingAccountBalance = response;
        sessionStorage.setItem("savingAccountBalance",this.savingAccountBalance)
      },
      error =>{
        console.log(error);
      }
    )
  }
  

  handleDeposit(account){
    this.router.navigate(["user","depositFund"]);

  }
  handleWithdraw(account){
    this.router.navigate(["user","withdrawFund"]);

  }
  handleAccount(account){
    if(account==="Primary"){
      this.router.navigate(["user","primaryAccount"]);
    }
  }
  handlePrimaryAccount(){
    this.router.navigate(["user","primaryAccount"])
  }

  handleSavingAccount(){
    this.router.navigate(["user","savingAccount"])
  }

}
