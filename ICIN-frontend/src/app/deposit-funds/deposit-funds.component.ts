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
  account:String;
  balanceFund:number;
  depositFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.depositFundForm = this.formBuilder.group({
      accountType: ["Primary Account"],
      balance : [this.balanceFund],
      amountToBeDeposited : ["",Validators.required]

    })
    this.getBalanceAsPerAccountType(this.depositFundForm.get("accountType").value);
  }

  getBalanceAsPerAccountType(accountType){
    if(accountType==="Primary Account")
      this.getBalance(sessionStorage.getItem("primaryAccountNumber"));
    else
      this.balanceFund = Number(sessionStorage.getItem("savingAccountBalance"))
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
    if(Number(this.depositFundForm.get("amountToBeDeposited").value)>0){
      if(this.depositFundForm.get("accountType").value === "Primary Account"){
        this.service.depositMoney("Primary",Number(sessionStorage.getItem("primaryAccountNumber")),Number(this.depositFundForm.get("amountToBeDeposited").value)).subscribe(
          response =>{ 
            console.log(response)
            alert("Money deposited successfully!!")
            this.route.navigate(["user","home"]);
            },
          error => {
            alert("Transaction Failed")
            console.log(error)
          }
        )
        }
        else{
          this.service.depositMoney("Savings",Number(sessionStorage.getItem("savingAccountNumber")),Number(this.depositFundForm.get("amountToBeDeposited").value)).subscribe(
            response =>{ 
              console.log(response)
              let updatedBalance = Number(this.depositFundForm.get("amountToBeDeposited").value) + Number(sessionStorage.getItem("savingAccountBalance"))
              sessionStorage.setItem("savingAccountBalance",String(updatedBalance));
              alert("Money deposited successfully!!")
              this.route.navigate(["user","home"]);
              },
            error => {
              alert("Transaction Failed")
              console.log(error)
            }
          )
        }

    }
    else{
      alert("Amount to be deposited cannot be negative")
    }
    
  }
}

  public onChange(event): void {  // event will give you full breif of action
    const newVal = event.target.value;
    this.getBalanceAsPerAccountType(newVal);
   // console.log(newVal);
  }


}
