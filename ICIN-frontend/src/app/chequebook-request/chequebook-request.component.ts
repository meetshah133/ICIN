import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormGroup,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import { ValueConverter } from '@angular/compiler/src/render3/view/template';
import { visitValue } from '@angular/compiler/src/util';

@Component({
  selector: 'app-chequebook-request',
  templateUrl: './chequebook-request.component.html',
  styleUrls: ['./chequebook-request.component.css']
})
export class ChequebookRequestComponent implements OnInit {

  constructor(private route:Router,
    private formbuilder:FormBuilder) { }
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
  
  

}
