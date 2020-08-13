import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.css']
})
export class PersonalDetailsComponent implements OnInit {

  constructor(private router : Router, ) { }
  firstName:string;
  lastName:string;
  invalidFirstName = false;
  invalidLasttName = false;


  ngOnInit(): void {
  }


  handlePersonalDetailsValidation(){
    if(this.firstName===undefined){
      this.invalidFirstName = true;
    }
    if(this.lastName===undefined){
      this.invalidLasttName = true;
    }
    else {
    sessionStorage.setItem("firstName",this.firstName);
    sessionStorage.setItem("lastName",this.lastName);
    this.router.navigate(["register","contactDetails"]);
    }
  }

}
