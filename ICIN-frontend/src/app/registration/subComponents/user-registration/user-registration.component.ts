import { Component, OnInit } from '@angular/core';
import {FormsModule,FormGroup,FormControl,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
  
})
export class UserRegistrationComponent implements OnInit {

  constructor(private route:Router,private formbuilder:FormBuilder) { }
  userName:String="";
  password:String="";
  confirmPassword:String="";
  invalidUserName = false;
  invalidPassword = false;
  invalidConfirmPassword  = false;
  checked:false;
  invalidTnc;

    
  ngOnInit(): void {
  }
  validateUserDetails(){

    if(this.userName.length===0){
      this.invalidUserName = true;
      return;
    }
    if(this.password.length<8){
      this.invalidPassword = true;
      return;
    }
    if(this.confirmPassword.length<8 ||this.confirmPassword!==this.password){
      this.invalidConfirmPassword = true;
      return;
    }
    if(!this.checked){
      this.invalidTnc = true;
      return;
    }
    else{
      console.log("Done");
      //Route to home page
    }
  }

}
