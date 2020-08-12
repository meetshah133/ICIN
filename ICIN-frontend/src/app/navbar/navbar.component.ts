import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  view:boolean=true;
  constructor(private router:Router) { }

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

}
