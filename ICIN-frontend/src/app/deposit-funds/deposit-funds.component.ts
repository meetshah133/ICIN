import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from '../service/user-services.service';

export class Deposit {
  constructor(private accType:String,private accNo:String,private amount){}
}
@Component({
  selector: 'app-deposit-funds',
  templateUrl: './deposit-funds.component.html',
  styleUrls: ['./deposit-funds.component.css']
})
export class DepositFundsComponent implements OnInit {

 
  constructor(private route:Router,private formBuilder:FormBuilder,private service:UserServicesService) { }
  account:String=history.state.data;
  balanceFund:number;
  depositFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.depositFundForm = this.formBuilder.group({
      accountType: [this.account],
      balance : [this.balanceFund],
      amountToBeDeposited : ["",Validators.required]

    })
    this.getBalanceAsPerAccountType(this.depositFundForm.get("accountType").value);
  }

  getBalanceAsPerAccountType(accountType){
    if(accountType==="Primary Account"){
      this.getBalance(sessionStorage.getItem("primaryAccountNumber"));
    }
    else{
      this.getBalance(sessionStorage.getItem("savingAccountNumber"));
    }
  }

  get f(){
    return this.depositFundForm.controls;
  }

  getBalance(account){
    this.service.getAccountBalance(Number(account)).subscribe(
      response => {
        this.balanceFund = Number(response);
      },
      error =>{
        console.log(error);
      }
    )
  }

  handleTransferFund(){
    this.submitted = true;
    if(this.depositFundForm.invalid){
      console.log("Invalid")
    }
    else{
     this.service.depositMoney("Primary",sessionStorage.getItem("primaryAccountNumber"),this.depositFundForm.get("amountToBeDeposited").value).subscribe(  
     response => console.log(response),
        error => console.log(error)
      )
    }
  }

  public onChange(event): void {  // event will give you full breif of action
    const newVal = event.target.value;
    this.getBalanceAsPerAccountType(newVal);
   // console.log(newVal);
  }


}
