import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TransactionService } from '../service/transaction.service';

@Component({
  selector: 'app-withdraw-fund',
  templateUrl: './withdraw-fund.component.html',
  styleUrls: ['./withdraw-fund.component.css']
})
export class WithdrawFundComponent implements OnInit {
 
  constructor(private route:Router,private formBuilder:FormBuilder,private transaction : TransactionService) { }
    accountType:String
    account:String=history.state.data;
    accountNo:number
    amount:bigint
    balanceFund = this.getBalance(this.accountType)
    withdrawFundForm: FormGroup;
    submitted:boolean = false;
    acc:any
    ngOnInit(): void {
      this.withdrawFundForm = this.formBuilder.group({
        accountType: [this.account],
        balance : [this.balanceFund],
        amountToBeDeposited : ["",Validators.required]
  
      })
      this.balanceFund = this.getBalance(this.account);
    }
  
    get f(){
      return this.withdrawFundForm.controls;
    }
  
    getBalance(accountType){
      let response = this.transaction.forWithdraw();
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
      if(this.withdrawFundForm.invalid){
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