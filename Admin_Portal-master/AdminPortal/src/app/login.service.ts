import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable}     from 'rxjs/Observable';
import { Admin } from './admin';
//import { Admin } from './admin.model';

@Injectable()
export class LoginService {

  constructor (private http: HttpClient) {}

  sendCredential(username: string, password: string) {
    
    var admin = new Admin();
    admin.emailid=username;
    admin.password=password;
    
    //let url = "http://localhost:8080/index";
    //let params = 'username='+username+'&password='+password;
    //let headers = new HttpHeaders(
    //{
     // 'Content-Type': 'application/x-www-form-urlencoded'
      // 'Access-Control-Allow-Credentials' : true
    //});
    //return this.http.post(url, params, {headers: headers, withCredentials : true, responseType: 'text'});
    return this.http.post("http://localhost:8090/admin",admin);





  }

  logout() {
     let url = "http://localhost:8080/logout";
     return this.http.get(url, { withCredentials: true });
   }

}
