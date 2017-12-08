import { Component, OnInit } from '@angular/core';

import { ApiClientService } from '../services/apiclient.service';

@Component({
    selector: 'transactions-cmp',
    moduleId: module.id,
    templateUrl: 'transactions.component.html'
})

export class TransactionsComponent implements OnInit {
    private currentViewingDate: Date;
    private currentViewingDateString: string;
    private getMonthText: Array<string> = ['Jan', 'Feb', 'March', 'April', 'May', 'June', 'July', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec'];

    constructor(private apiClientService: ApiClientService) {
        this.currentViewingDate = new Date();
        this.updateDateString();
    }

    ngOnInit() {

    }

    private moveMonth(direction: string): void {
        if (direction == "next") {
            this.currentViewingDate.setMonth(this.currentViewingDate.getMonth() + 1);
        } else {
            this.currentViewingDate.setMonth(this.currentViewingDate.getMonth() - 1);
        }
        this.refreshTransactionList();
    }

    refreshTransactionList() {
        this.updateDateString();
        let month = this.currentViewingDate.getMonth() + 1;
        let year = this.currentViewingDate.getFullYear();
    }

    private updateDateString() {
        this.currentViewingDateString = this.getMonthText[this.currentViewingDate.getMonth()] + "   '" 
        + this.currentViewingDate.getFullYear().toString().substring(2,4);
      }
}
