import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserServicesService {

  constructor() { }

  addUSerToDb(){
    console.log("Calling backend end point");
  }

  authenticateUser(){
      console.log("Verifying user");
  }
}
