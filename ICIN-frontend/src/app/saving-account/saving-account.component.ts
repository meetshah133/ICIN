import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-saving-account',
  templateUrl: './saving-account.component.html',
  styleUrls: ['./saving-account.component.css']
})
export class SavingAccountComponent implements OnInit {

  constructor() { }
  acocuntNumber = sessionStorage.getItem("savingAccountNumber");
  balance=sessionStorage.getItem("savingAccountBalance");
  ngOnInit(): void {
  }

}
