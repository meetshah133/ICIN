import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {UserServicesService}  from '../service/user-services.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  view:boolean=true;
  constructor(private router:Router,
    public service: UserServicesService) { }

  ngOnInit(): void {
  
  }

  isView(){
    this.view=false;
  }

  handleChequeBookRequest(account){
   this.router.navigate(["user","chequeBookRequest"],{state:{data:account}}); 
  }

  handleTransferFundRequest(account){
    this.router.navigate(["user","transferFundRequest"],{state:{data:account}}); 
  }
  handleLogout(){
    sessionStorage.removeItem("isAuthenticatedUser");
    sessionStorage.clear();
    this.router.navigate(["login"]);
  }
  viewProfile(){
    this.router.navigate(["user","profile"]);
  }

  handleHome(){
    if(this.service.isUserLogin()){
      this.router.navigate(["user","home"]);
    }
    else{
      this.router.navigate(["login"]);
    }
  }
  handleAccount(account){
    if(account==="Primary")
        this.router.navigate(["user","primaryAccount"])
    else
      this.router.navigate(["user","savingAccount"])
  }

}
