import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { UserServicesService } from './user-services.service';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService  implements CanActivate{

  constructor(private service:UserServicesService,
    private router:Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(this.service.isUserLogin()){
      return true;
    }
    else{
      this.router.navigate(["login"]);
    }
  }
}
