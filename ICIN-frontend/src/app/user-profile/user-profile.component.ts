import { Component, OnInit } from '@angular/core';
import { LoginComponent } from '../login/login.component';
import { UserServicesService } from '../service/user-services.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  constructor(private service:UserServicesService) { }
  savingAccountNumber;
  savingAccountBalance;
  primaryAccountNumber;
  primaryAccountBalance;
  userName = this.service.getUserName();
  ngOnInit(): void {
    this.savingAccountNumber = "123478151616161";
    this.savingAccountBalance = 1000;
    this.primaryAccountBalance = 500;
    this.primaryAccountNumber = "94841515616166";
  }

}
