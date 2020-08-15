import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-home',
  templateUrl: './user-home.component.html',
  styleUrls: ['./user-home.component.css']
})
export class UserHomeComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  handleDeposit(account){
    this.router.navigate(["user","depositFund",{state:{data:account}}]);

  }
  handleWithdraw(account){
    this.router.navigate(["user","withdrawFund",{state:{data:account}}]);

  }
  handleAccount(account){
    if(account==="Primary"){
      this.router.navigate(["user","primaryAccount"]);
    }
  }

}
