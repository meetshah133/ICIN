import { Component, OnInit } from '@angular/core';
import { UserServicesService } from '../service/user-services.service';
import { Transaction } from '../transfer-funds/transfer-funds.component';

@Component({
  selector: 'app-primary-account',
  templateUrl: './primary-account.component.html',
  styleUrls: ['./primary-account.component.css']
})
export class PrimaryAccountComponent implements OnInit {

  constructor(private service:UserServicesService) { }
  acocuntNumber = sessionStorage.getItem("primaryAccountNumber");
  balance=sessionStorage.getItem("primaryAccountBalance");
  transactions
  ngOnInit(): void {
        this.getUserTransactions();      
    
  }
  getUserTransactions(){
    this.service.getTransactions(sessionStorage.getItem("primaryAccountNumber")).subscribe(
      response =>{
        this.transactions = response;
        console.log(this.transactions);
      },
      error => console.log(error)
      )
    
  }

}
