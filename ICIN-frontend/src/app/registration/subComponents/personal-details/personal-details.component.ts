import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-personal-details',
  templateUrl: './personal-details.component.html',
  styleUrls: ['./personal-details.component.css']
})
export class PersonalDetailsComponent implements OnInit {

  constructor(private router : Router) { }

  ngOnInit(): void {
  }

  handlePersonalDetailsValidation(){
    this.router.navigate(["register","contactDetails"]);
  }

}
