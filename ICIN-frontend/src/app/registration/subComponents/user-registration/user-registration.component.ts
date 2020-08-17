import { Component, OnInit } from '@angular/core';
import {FormsModule,FormGroup,FormControl,FormBuilder} from '@angular/forms';
import { Router } from '@angular/router';
import { UserServicesService } from 'src/app/service/user-services.service';
import { Md5 } from 'ts-md5';

export class User {
  constructor( private fullname:String,
    private  surname:String,
    private  mailid:String,
    private  phonenumber:number,
    private  address:String,
    private  password:String,
    private PrimaryAccount:any,
    private SavingAccount:any){

    }
 
}


@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
  
})
export class UserRegistrationComponent implements OnInit {

  constructor(private router:Router,private formbuilder:FormBuilder,private service:UserServicesService) { }
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
    if(!this.checkPassword(this.password)){
      this.invalidPassword = true;
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

      sessionStorage.setItem("password",String(Md5.hashStr(this.password)));
      console.log("Done");
      this.service.addUSerToDb().subscribe( 
        response => {
          if(response){
            sessionStorage.removeItem("firstName");
            sessionStorage.removeItem("lastName");
            sessionStorage.removeItem("address");
            sessionStorage.removeItem("mailid");
            sessionStorage.removeItem("phonenumber");
            this.router.navigate(["login"]);
          }
        },
        error => {
          console.log(error);
          alert("Registration Failed");
        }

      );

    }
  }
  
  checkPassword(password){
    let letter = /[a-zA-Z]/; 
    let number = /[0-9]/;
    let symbol = /[,_#@]*$/
    let valid = number.test(password) && letter.test(password); //match a letter _and_ a number
    return valid;
  }

  

}
