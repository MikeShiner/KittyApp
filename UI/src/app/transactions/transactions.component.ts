import { Component, OnInit } from '@angular/core';

import { ApiClientService } from '../services/apiclient.service';
import { Transaction } from 'app/class/transaction';

@Component({
    selector: 'transactions-cmp',
    moduleId: module.id,
    templateUrl: 'transactions.component.html'
})

export class TransactionsComponent implements OnInit {
    private currentViewingDate: Date;
    private transactionList: Array<object> = [];

    constructor(private apiClientService: ApiClientService) {
        this.currentViewingDate = new Date();
    }

    ngOnInit() {
        this.refreshTransactionList(this.currentViewingDate);
    }


    refreshTransactionList(date: Date) {
        let month = this.currentViewingDate.getMonth() + 1;
        let year = this.currentViewingDate.getFullYear();

        this.apiClientService.getTransactions(month, year).subscribe((data) => {
            this.transactionList = data;
        });
    }

    monthViewChange(date: Date) {
        this.currentViewingDate = date;
        this.refreshTransactionList(date);
    }

    deleteTransaction(id: string) {
        this.apiClientService.deleteTransaction(id).subscribe(
            (data) => {
                this.refreshTransactionList(this.currentViewingDate);
            }, 
            (error) => {
                this.refreshTransactionList(this.currentViewingDate);
            console.log("Unable to delete transaction", error.error.message);
        });
    }
}
