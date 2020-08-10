import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-kyc-details',
  templateUrl: './kyc-details.component.html',
  styleUrls: ['./kyc-details.component.css']
})
export class KycDetailsComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }
  validateKyc(){
    this.router.navigate(["register","addressDetails"])
  }

}
