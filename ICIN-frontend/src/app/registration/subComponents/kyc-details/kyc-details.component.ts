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
  age:number;
  kycForm:FormGroup;
  invalidPan:any;
  invalidAge = false;
  ngOnInit(): void {
    this.kycForm = this.formbuilder.group({
      pan : ["",[Validators.required]],
      dob : ["",[Validators.required]]    
    })
  }
  validateKyc(){
    console.log(this.kycForm.get("dob").value);
    let currentDate:any =  new Date(this.kycForm.get("dob").value);
    let timeDiff =  Math.abs(Date.now() - currentDate)
    this.age = Math.floor((timeDiff / (1000 * 3600 * 24))/365);
    console.log(this.age);
    if(this.age<10){
      this.invalidAge = true;
      return;
    }
    if(!this.checkPancardValidity(this.kycForm.get("pan").value)){
      this.invalidPan = true;
      return;
    }
    

    //age =  2020-this.kycForm.get("dob").value;
    if(!this.kycForm.invalid)
       this.router.navigate(["register","addressDetails"])
  }

  checkPancardValidity(pan) {
    let letter = /[a-zA-Z]/; 
    let number = /[0-9]/;
    let valid = number.test(pan) && letter.test(pan); //match a letter _and_ a number
    console.log(valid);
    return valid;
}

  get f() { return this.kycForm.controls; }
}
