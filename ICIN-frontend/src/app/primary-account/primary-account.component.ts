import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-primary-account',
  templateUrl: './primary-account.component.html',
  styleUrls: ['./primary-account.component.css']
})
export class PrimaryAccountComponent implements OnInit {

  constructor() { }
  acocuntNumber = "515615661651165";
  balance=1000;
  ngOnInit(): void {
  }

}
