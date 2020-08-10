import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-contact-details',
  templateUrl: './contact-details.component.html',
  styleUrls: ['./contact-details.component.css']
})
export class ContactDetailsComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  validateContactDetails(){
    this.router.navigate(["register","kycDetails"]);
  }

}
