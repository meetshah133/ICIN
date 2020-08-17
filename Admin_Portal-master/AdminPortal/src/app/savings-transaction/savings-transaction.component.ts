import { Component, OnInit } from '@angular/core';
import {UserService} from '../user.service';
import { ActivatedRoute, Params } from '@angular/router';


@Component({
  selector: 'app-savings-transaction',
  templateUrl: './savings-transaction.component.html',
  styleUrls: ['./savings-transaction.component.css']
})
export class SavingsTransactionComponent implements OnInit {

  userAcc:string;
	savingsTransactionList: Object[];

	constructor(private route: ActivatedRoute, private userService: UserService) {
		this.route.params.forEach((params: Params) => {
     		this.userAcc = params['userAcc'];
		});

		this.getSavingsTransactionList();
	}

	getSavingsTransactionList() {
		this.userService.getSavingsTransactionList(this.userAcc).subscribe(
			res => {
				console.log(JSON.parse(JSON.stringify(res))._body);
        		this.savingsTransactionList = JSON.parse(JSON.stringify(res));
      		},
      		error => console.log(error)
		)
	}

	ngOnInit() {}
}
