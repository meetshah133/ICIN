import { Component, OnInit } from '@angular/core';
import {ChequeBookRequestService} from '../chequeBookRequest.service';


@Component({
  selector: 'app-chequeBookRequest',
  templateUrl: './chequeBookRequest.component.html',
  styleUrls: ['./chequeBookRequest.component.css']
})
export class ChequeBookRequestComponent implements OnInit {

  chequeBookRequestList: Object[];

	constructor(private chequeBookRequestService: ChequeBookRequestService) {
		this.getChequeBookRequestList();
	}

	getChequeBookRequestList() {
		this.chequeBookRequestService.getChequeBookRequestList().subscribe(
			res => {
        		this.chequeBookRequestList = JSON.parse(JSON.stringify(res));
      		},
      		error => console.log(error)
		)
	}	

	confirmChequeBookRequest(id: number) {
  		this.chequeBookRequestService.confirmChequeBookRequest(id).subscribe();
  		location.reload();
  	}

ngOnInit() {}
}
