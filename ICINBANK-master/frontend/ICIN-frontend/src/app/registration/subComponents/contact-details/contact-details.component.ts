import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormGroup,FormControl,Validators,FormBuilder, Form}  from "@angular/forms"

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {
  
  constructor(private router:Router, private formbuilder:FormBuilder) { }
  contactForm : FormGroup;
  submitted = false;
  ngOnInit(): void {
    this.contactForm = this.formbuilder.group({
      email : ["",[Validators.required,Validators.email]],
      phone: ["", [Validators.required, Validators.minLength(10),Validators.pattern(/^-?(0|[1-9]\d*)?$/)]],
    })
  
  }

  validateContactDetails(){
    
    if(this.contactForm.valid )
    {   sessionStorage.setItem("phonenumber",this.contactForm.get("phone").value);
        sessionStorage.setItem("mailid",this.contactForm.get("email").value);
        this.router.navigate(["register","kycDetails"]);
     }
  }

  

  get f() { return this.contactForm.controls; }
 

}
