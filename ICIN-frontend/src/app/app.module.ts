import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { PersonalDetailsComponent } from './registration/subComponents/personal-details/personal-details.component';
import { ContactDetailsComponent } from './registration/subComponents/contact-details/contact-details.component';
import { KycDetailsComponent } from './registration/subComponents/kyc-details/kyc-details.component';
import { AddressDetailsComponent } from './registration/subComponents/address-details/address-details.component';
import { UserRegistrationComponent } from './registration/subComponents/user-registration/user-registration.component';
import { HomepageComponent } from './homepage/homepage.component';
import { NavbarComponent } from './navbar/navbar.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    PersonalDetailsComponent,
    ContactDetailsComponent,
    KycDetailsComponent,
    AddressDetailsComponent,
    UserRegistrationComponent,
    HomepageComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
