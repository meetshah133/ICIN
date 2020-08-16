import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-saving-account',
  templateUrl: './saving-account.component.html',
  styleUrls: ['./saving-account.component.css']
})
export class SavingAccountComponent implements OnInit {

  constructor() { }
  acocuntNumber = "515615661651189";
  balance=500;
  ngOnInit(): void {
  }

}
