import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactDetailsComponent } from './registration/subComponents/contact-details/contact-details.component';
import { LoginComponent } from './login/login.component';
import { PersonalDetailsComponent } from './registration/subComponents/personal-details/personal-details.component';
import { KycDetailsComponent } from './registration/subComponents/kyc-details/kyc-details.component';
import { AddressDetailsComponent } from './registration/subComponents/address-details/address-details.component';
import { UserRegistrationComponent } from './registration/subComponents/user-registration/user-registration.component';
import {RegistrationComponent} from './registration/registration.component';
import {UserHomeComponent} from "./user-home/user-home.component"
import { ChequebookRequestComponent } from './chequebook-request/chequebook-request.component';
import { TransferFundsComponent } from './transfer-funds/transfer-funds.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { DepositFundsComponent } from './deposit-funds/deposit-funds.component';
import { WithdrawFundComponent } from './withdraw-fund/withdraw-fund.component';

const routes: Routes = [
  {path:"register/contactDetails",component:ContactDetailsComponent},
  {path:"register/personalDetails",component:PersonalDetailsComponent},
  {path:"register/kycDetails",component:KycDetailsComponent},
  {path:"register/addressDetails",component:AddressDetailsComponent},
  {path:"register/userRegistration",component:UserRegistrationComponent},
  {path:"login",component:LoginComponent},
  {path:"register",component:RegistrationComponent },
  {path:"user/home",component:UserHomeComponent},
  {path:"user/chequeBookRequest",component:ChequebookRequestComponent},
  {path:"user/transferFundRequest",component:TransferFundsComponent},
  {path:"user/profile",component:UserProfileComponent},
  {path:"user/deposit",component:DepositFundsComponent},
  {path:"user/withdraw",component:WithdrawFundComponent},
  {path:"",component:LoginComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
