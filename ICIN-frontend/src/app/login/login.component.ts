import { Component, OnInit } from '@angular/core';
import {FormsModule,FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import {UserServicesService} from '../service/user-services.service'
import {User} from  '../registration/subComponents/user-registration/user-registration.component';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router:Router,private formbuilder:FormBuilder,private service:UserServicesService) { }
  submitted =false
  loginForm : FormGroup;
  ngOnInit(): void {
    this.loginForm = this.formbuilder.group({
      email : ["",[Validators.required,Validators.email]],
      password: ["",Validators.required],
    })
  }

  validateLogin(){
    this.submitted = true;
   //  console.log(this.loginForm.get("username").value);
   
    if(!this.loginForm.invalid){
      let newUser = new User("","",this.loginForm.get("email").value,null,"",this.loginForm.get("password").value);
      this.service.authenticateUser(newUser).subscribe(
        response => {
          console.log(response),
          sessionStorage.removeItem("password");
          sessionStorage.setItem("isAuthenticatedUser",response["fullname"]);
          sessionStorage.setItem("mailid",response["mailid"]);
          sessionStorage.setItem("phonenumber",response["phonenumber"]);
          sessionStorage.setItem("firstname",response["fullname"]);
          sessionStorage.setItem("lastname",response["surname"]);
          sessionStorage.setItem("address",response["address"]);

          this.router.navigate(["user","home"]);
        },
        error => {
         // alert("Invalid Credentials") 
        alert("Login failed!!")
      }
      )

    }

  }
  get f() { return this.loginForm.controls; }
}
