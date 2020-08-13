import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { isSyntheticPropertyOrListener } from '@angular/compiler/src/render3/util';
import { TitleCasePipe } from '@angular/common';

@Component({
  selector: 'app-address-details',
  templateUrl: './address-details.component.html',
  styleUrls: ['./address-details.component.css']
})
export class AddressDetailsComponent implements OnInit {

  constructor(private router:Router) { }
  invalidAddressLine1:boolean=false;
  invalidAddressLine2:boolean=false;
  invalidAddressLine3:boolean=false;
  invalidAddressLine4:boolean=false;
  invalidAddressLine5:boolean=false;

  addressLine1:string="";
  addressLine2:string="";
  addressLine3:string="";
  addressLine4:string="";
  addressLine5:string="";
  fullAddress:string;

  addressArray:String[]
  invalidAddressArray:boolean[]

  areAllFieldsValid = true;

  ngOnInit(): void {
  }

  validateAddress(){
    
    
     if(this.addressLine1.length===0){
       this.invalidAddressLine1 = true;
     } 
     if(this.addressLine2.length===0){
       this.invalidAddressLine2 = true;
     }
     if(this.addressLine3.length===0){
       this.invalidAddressLine3 = true;
     }
     if(this.addressLine4.length===0){
       this.invalidAddressLine4 = true;
     }
     if(this.addressLine5.length===0){
       this.invalidAddressLine5 = true;
     }
     else{
      this.fullAddress = this.addressLine1 + " " + this.addressLine2  + " " + this.addressLine3 + " " +this.addressLine4 + " " +this.addressLine5;
      sessionStorage.setItem("address",this.fullAddress);
      this.router.navigate(["register","userRegistration"])
     }
    }

}
