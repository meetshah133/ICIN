import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css']
})
export class AddressDetailsComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  validateAddress(){
    this.router.navigate(["register","userRegistration"])
  }

}
