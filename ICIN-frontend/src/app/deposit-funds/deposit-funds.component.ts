import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-deposit-funds',
  templateUrl: './deposit-funds.component.html',
  styleUrls: ['./deposit-funds.component.css']
})
export class DepositFundsComponent implements OnInit {

 
  constructor(private route:Router,private formBuilder:FormBuilder) { }
  account:String=history.state.data;
  balanceFund = this.getBalance(this.account)
  depositFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.depositFundForm = this.formBuilder.group({
      accountType: [this.account],
      balance : [this.balanceFund],
      amountToBeDeposited : ["",Validators.required]

    })
    this.balanceFund = this.getBalance(this.account);
  }

  get f(){
    return this.depositFundForm.controls;
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
    if(this.depositFundForm.invalid){
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
