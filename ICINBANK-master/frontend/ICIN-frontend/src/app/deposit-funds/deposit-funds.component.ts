import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {TransactionService} from '../service/transaction.service'

@Component({
  selector: 'app-deposit-funds',
  templateUrl: './deposit-funds.component.html',
  styleUrls: ['./deposit-funds.component.css']
})
export class DepositFundsComponent implements OnInit {

   
  constructor(private route:Router,private formBuilder:FormBuilder, private transaction : TransactionService) { }
  accountType:String
  accountNo:number
  amount:bigint
  acc:any
  account:String= history.state.data;
  balanceFund = this.getBalance(this.accountType)
  depositFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.depositFundForm = this.formBuilder.group({
      accountType: [this.account],
      balance : [this.balanceFund],
      amountToBeDeposited : ["",Validators.required]

    })
    this.balanceFund = this.getBalance(this.accountType);

    
  }

  get f(){
    return this.depositFundForm.controls;
  }

  getBalance(accountType){
    let response = this.transaction.forDeposit();
    console.log(response.subscribe(data => this.acc= data));

    if(accountType==="Primary Account"){
      this.accountNo = Number(sessionStorage.getItem("primaryAccNo"));
      return this.acc["accountBalance"];
    }
    else{
      this.accountNo = Number(sessionStorage.getItem("savingsAccNo"));
      return this.acc["accountBalance"];
    }
      
  }

  sendAccNo(){
    this.transaction.accountNo = this.accountNo;
  }
  handleTransferFund(){
    this.submitted = true;
    if(this.depositFundForm.invalid){
      console.log("Invalid")
    }
    else{
      console.log("Valid form");
      this.amount = this.balanceFund;
      this.transaction.amount = this.amount;
    }
  }

  public onChange(event): void {  // event will give you full breif of action
    this.accountType = event.target.value;
    const newVal = this.accountType;
    this.balanceFund = this.getBalance(newVal);
    console.log(newVal);
  }


}