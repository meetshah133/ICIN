import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  view:boolean=true;
  constructor() { }

  ngOnInit(): void {
  
  }

  isView(){
    this.view=false;
  }

}
