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

  loginForm : FormGroup;
  ngOnInit(): void {
    this.loginForm = this.formbuilder.group({
      username: ["",Validators.required],
      password: ["",Validators.required],
    })
  }

  validateLogin(){
    if(!this.loginForm.invalid){
      this.service.authenticateUser();
    }

  }
  get f() { return this.loginForm.controls; }
}
