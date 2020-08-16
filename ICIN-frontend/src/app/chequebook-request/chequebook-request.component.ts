import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { visitValue } from '@angular/compiler/src/util';
import { User } from '../registration/subComponents/user-registration/user-registration.component';
import { UserServicesService } from '../service/user-services.service';

export class ChequeBook {
  constructor(private accepted:boolean,private user:User){}
}
@Component({
  selector: 'app-chequebook-request',
  templateUrl: './chequebook-request.component.html',
  styleUrls: ['./chequebook-request.component.css']
})
export class ChequebookRequestComponent implements OnInit {

  constructor(private route:Router,
    private formbuilder:FormBuilder,
    private service:UserServicesService) { }
  chequeBookRequestForm:FormGroup;  
  account= this.getAccountPassedByParent();
  ngOnInit(): void {
    this.chequeBookRequestForm = this.formbuilder.group({
      accountType:[this.account,[Validators.required]]
    })
  }

  getAccountPassedByParent(){
    return  history.state.data;
  }

  get f(){
    return this.chequeBookRequestForm.controls;
  }
  handleChequebookRequest(){
    let userObj = JSON.parse(sessionStorage.getItem("userObj"));
    this.service.requestChequeBook(new ChequeBook(false,userObj),userObj).subscribe(
      response =>{ 
        alert("Chequebook request submiited")
        console.log(response
          )
          this.route.navigate(["user","home"]);
        },
      error => { 
        alert("Chequebook request failed")
        console.log(error)},
    )
  }


  

}
