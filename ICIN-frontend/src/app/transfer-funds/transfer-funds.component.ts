import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder,FormControl,FormGroup,Validators}  from '@angular/forms';
import { UserServicesService } from '../service/user-services.service';

export class Transaction{
  constructor(
  private  creationDate:Date,

  private  description:string,

  private  transactionAmount:number,

  private  sourceAccountId:number,

  private  destinationAccountId:number,
  
  private  IFSC:string,
  ){

  }
}

@Component({
  selector: 'app-transfer-funds',
  templateUrl: './transfer-funds.component.html',
  styleUrls: ['./transfer-funds.component.css']
})
export class TransferFundsComponent implements OnInit {

  constructor(private route:Router,private formBuilder:FormBuilder,private service:UserServicesService) { }
  account:String=history.state.data;
  balanceFund:number
  transferFundForm: FormGroup;
  submitted:boolean = false;
  ngOnInit(): void {
    this.transferFundForm = this.formBuilder.group({
      accountType: ["Primary Account"],
      balance : [this.balanceFund],
      beneficiaryName : ["",Validators.required],
      beneficiaryAccountNumber : ["",Validators.required],
      beneficiaryIFSCCode : ["",Validators.required],
      amountToBeTransfered : ["",[Validators.required]],
      transferType : ["IMPS"],
      optionalMessage : [""]
    })
    this.getBalance();
  }

  get f(){
    return this.transferFundForm.controls;
  }

  getBalance( ){
   
     (this.service.getAccountBalance(sessionStorage.getItem("primaryAccountNumber"))).subscribe(
        response => {
          this.balanceFund = Number(response);
        }
     );
  }

  handleTransferFund(){
    this.submitted = true;
    if(this.transferFundForm.invalid){
      console.log("Invalid")
    }
    else{
      let newTransaction = new Transaction(new Date(),"Fund Transfer",
      Number(this.transferFundForm.get("amountToBeTransfered").value),
      Number(sessionStorage.getItem("primaryAccountNumber")),
      Number(this.transferFundForm.get("beneficiaryAccountNumber").value),"ICN0001");
      this.service.transferFund(newTransaction).subscribe(
        response => alert("Transaction Successfull"),
        error => alert("Transaction failed")
      );
    } 
  }

  public onChange(event): void {  // event will give you full breif of action
    const newVal = event.target.value;
   // this.balanceFund = this.getBalance(newVal);
   // console.log(newVal);
  }

}
