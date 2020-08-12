import { Component, OnInit } from '@angular/core';
import {FormsModule,FormGroup,FormBuilder,FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import {UserServicesService} from '../service/user-services.service'

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
      username: ["",Validators.required],
      password: ["",Validators.required],
    })
  }

  validateLogin(){
    this.submitted = true;
   //  console.log(this.loginForm.get("username").value);
    if(!this.loginForm.invalid){
      if(this.service.authenticateUser()){
        sessionStorage.setItem("isAuthenticatedUser",this.loginForm.get("username").value);
      }
      this.router.navigate(["user","home"]);
    }

  }
  get f() { return this.loginForm.controls; }
}
