import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-withdraw-fund',
  templateUrl: './withdraw-fund.component.html',
  styleUrls: ['./withdraw-fund.component.css']
})
export class WithdrawFundComponent implements OnInit {
 
  constructor(private route:Router,private formBuilder:FormBuilder) { }
    account:String=history.state.data;
    balanceFund = this.getBalance(this.account)
    withdrawFundForm: FormGroup;
    submitted:boolean = false;
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
  
    getBalance(account){
      if(account==="Primary Account"){
        return "1000";
      }
      else
        return "500";
    }
  
    handleTransferFund(){
      this.submitted = true;
      if(this.withdrawFundForm.invalid){
        console.log("Invalid")
      }
      else{
        console.log("Valid form");
      }
    }
  
    public onChange(event): void {  // event will give you full breif of action
      const newVal = event.target.value;
      this.balanceFund = this.getBalance(newVal);
     // console.log(newVal);
    }
  
  
  }
  

