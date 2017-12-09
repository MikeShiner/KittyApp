import { Component, OnInit } from '@angular/core';

import { ApiClientService } from '../services/apiclient.service';

@Component({
    selector: 'transactions-cmp',
    moduleId: module.id,
    templateUrl: 'transactions.component.html'
})

export class TransactionsComponent implements OnInit {
    private currentViewingDate: Date;

    constructor(private apiClientService: ApiClientService) {
        this.currentViewingDate = new Date();
    }

    ngOnInit() {
        this.refreshTransactionList(this.currentViewingDate);
    }


    refreshTransactionList(date: Date) {
        let month = this.currentViewingDate.getMonth() + 1;
        let year = this.currentViewingDate.getFullYear();
        console.log("Fetching transactions for date.. " + date);
    }

    monthViewChange(date: Date) {
        this.currentViewingDate = date;
        this.refreshTransactionList(date);
      }
}
