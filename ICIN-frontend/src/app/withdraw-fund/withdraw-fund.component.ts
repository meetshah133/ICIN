import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from '../service/user-services.service';

@Component({
  selector: 'app-withdraw-fund',
  templateUrl: './withdraw-fund.component.html',
  styleUrls: ['./withdraw-fund.component.css']
})
export class WithdrawFundComponent implements OnInit {
 
  constructor(private route:Router,private formBuilder:FormBuilder,private service:UserServicesService) { }
  account:String;
  balanceFund:number;
  withdrawFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.withdrawFundForm = this.formBuilder.group({
      accountType: ["Primary Account"],
      balance : [this.balanceFund],
      amountToBeDeposited : ["",Validators.required]

    })
    this.getBalanceAsPerAccountType(this.withdrawFundForm.get("accountType").value);
  }

  getBalanceAsPerAccountType(accountType){
    if(accountType==="Primary Account")
      this.getBalance(sessionStorage.getItem("primaryAccountNumber"));
    else
      this.balanceFund = Number(sessionStorage.getItem("savingAccountBalance"))
  }

  get f(){
    return this.withdrawFundForm.controls;
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
    if(this.withdrawFundForm.invalid){
      console.log("Invalid")
    }
    else{
    if(Number(this.withdrawFundForm.get("amountToBeDeposited").value)>0){ 
      if(this.withdrawFundForm.get("accountType").value === "Primary Account"){
        if(this.withdrawFundForm.get("amountToBeDeposited").value<=Number(sessionStorage.getItem("primaryAccountBalance"))){
        this.service.withdrawMoney("Primary",Number(sessionStorage.getItem("primaryAccountNumber")),Number(this.withdrawFundForm.get("amountToBeDeposited").value)).subscribe(
          response =>{ 
            console.log(response)
            alert("Money Withdrawn successfully!!")
            this.route.navigate(["user","home"]);
            },
          error => {
            alert("Transaction Failed")
            console.log(error)
          }
        )
        }else{
          alert("Insufficient Funds")
        }
        }
        else{
         if(this.withdrawFundForm.get("amountToBeDeposited").value<=Number(sessionStorage.getItem("savingAccountBalance"))){
          this.service.withdrawMoney("Savings",Number(sessionStorage.getItem("savingAccountNumber")),Number(this.withdrawFundForm.get("amountToBeDeposited").value)).subscribe(
            response =>{ 
              let updatedBalance 
              console.log(response)
              if(this.withdrawFundForm.get("amountToBeDeposited").value<=Number(sessionStorage.getItem("savingAccountBalance")))
              {
              updatedBalance =   Number(sessionStorage.getItem("savingAccountBalance")) - Number(this.withdrawFundForm.get("amountToBeDeposited").value)
              sessionStorage.setItem("savingAccountBalance",String(updatedBalance));
              }
              alert("Money Withdrawn successfully!!")
              this.route.navigate(["user","home"]);
              },
            error => {
              alert("Transaction Failed")
              console.log(error)
            }
          )}else{
            alert("Insufficient Funds")
          }
        }
    }
    else{
      alert("Amount to be withdrawn cannot be negative!!")
    }
    
  }
}

  public onChange(event): void {  // event will give you full breif of action
    const newVal = event.target.value;
    this.getBalanceAsPerAccountType(newVal);
   // console.log(newVal);
  }


}
