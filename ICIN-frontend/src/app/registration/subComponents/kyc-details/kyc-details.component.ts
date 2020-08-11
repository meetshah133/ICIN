import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormGroup,FormControl,Validators,FormBuilder, Form}  from "@angular/forms"

@Component({
  selector: 'app-kyc-details',
  templateUrl: './kyc-details.component.html',
  styleUrls: ['./kyc-details.component.css']
})
export class KycDetailsComponent implements OnInit {

  constructor(private router:Router,private formbuilder:FormBuilder) { }
  kycForm:FormGroup;
  ngOnInit(): void {
    this.kycForm = this.formbuilder.group({
      pan : ["",[Validators.required]],
      dob : ["",[Validators.required]]    
    })
  }
  validateKyc(){
    if(!this.kycForm.invalid)
       this.router.navigate(["register","addressDetails"])
  }

  get f() { return this.kycForm.controls; }
}
