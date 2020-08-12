import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder,FormControl,FormGroup,Validators}  from '@angular/forms';
@Component({
  selector: 'app-transfer-funds',
  templateUrl: './transfer-funds.component.html',
  styleUrls: ['./transfer-funds.component.css']
})
export class TransferFundsComponent implements OnInit {

  constructor(private route:Router,private formBuilder:FormBuilder) { }
  account:String=history.state.data;
  balanceFund = this.getBalance(this.account)
  transferFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.transferFundForm = this.formBuilder.group({
      accountType: [this.account],
      balance : [this.balanceFund],
      beneficiaryName : ["",Validators.required],
      beneficiaryAccountNumber : ["",Validators.required],
      beneficiaryIFSCCode : ["",Validators.required],
      amountToBeTransfered : ["",[Validators.required,Validators.pattern('/^-?(0|[1-9]\d*)?$/')]],
      optionalMessage : [""]
    })
    this.balanceFund = this.getBalance(this.account);
  }

  get f(){
    return this.transferFundForm.controls;
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
    if(this.transferFundForm.invalid){
      console.log("Invalid")
    }
    else{
      console.log("Valid form");
    }
  }

}
