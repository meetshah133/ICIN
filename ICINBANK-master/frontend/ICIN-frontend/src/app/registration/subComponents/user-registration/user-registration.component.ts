import { Component, OnInit } from '@angular/core';
import {FormsModule,FormGroup,FormControl,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from 'src/app/service/user-services.service';

export class User {
  constructor( private fullname:String,
    private  surname:String,
    private  mailid:String,
    private  phonenumber:number,
    private  address:String,
    private  password:String){

    }
 
}


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
  
})
export class UserRegistrationComponent implements OnInit {

  constructor(private route:Router,private formbuilder:FormBuilder,private service:UserServicesService) { }
  userName:string="";
  password:string="";
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
      sessionStorage.setItem("password",this.password);
      console.log("Done");
      this.service.addUSerToDb().subscribe( 
        response => {
          if(response){
            sessionStorage.removeItem("firstName");
            sessionStorage.removeItem("lastName");
            sessionStorage.removeItem("address");
            sessionStorage.removeItem("mailid");
            sessionStorage.removeItem("phonenumber");
          }
        },
        error => {
          console.log(error);
        }

      );

    }
  }

}
