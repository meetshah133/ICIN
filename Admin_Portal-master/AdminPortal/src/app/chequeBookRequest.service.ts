import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


@Injectable()
export class ChequeBookRequestService {

  constructor (private http:HttpClient){}

  getChequeBookRequestList() {
    let url = "http://localhost:8080/api/chequeBookRequest/all";
    return this.http.get(url, { withCredentials: true });
  }

  confirmChequeBookRequest(id: number) {
    let url = "http://localhost:8080/api/chequeBookRequest/"+id+"/confirm";
    return this.http.get(url, { withCredentials: true });
  }

}
