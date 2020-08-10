import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactDetailsComponent } from './registration/subComponents/contact-details/contact-details.component';
import { LoginComponent } from './login/login.component';
import { PersonalDetailsComponent } from './registration/subComponents/personal-details/personal-details.component';
import { KycDetailsComponent } from './registration/subComponents/kyc-details/kyc-details.component';
import { AddressDetailsComponent } from './registration/subComponents/address-details/address-details.component';
import { UserRegistrationComponent } from './registration/subComponents/user-registration/user-registration.component';

const routes: Routes = [
  {path:"register/contactDetails",component:ContactDetailsComponent},
  {path:"register/personalDetails",component:PersonalDetailsComponent},
  {path:"register/kycDetails",component:KycDetailsComponent},
  {path:"register/addressDetails",component:AddressDetailsComponent},
  {path:"register/userRegistration",component:UserRegistrationComponent},
  {path:"login",component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
