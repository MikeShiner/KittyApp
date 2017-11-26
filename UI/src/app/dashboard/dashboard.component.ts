import { Component, OnInit } from '@angular/core';
import { ApiClientService } from '../api-client.service';
import { Transaction } from '../classes/transaction';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  private currentMonthShow: string;
  private fundsLeftRep: string = "";
  private last5Transactions: Array<Transaction> = [];

  private monthNames: Array<string> = ["January", "February", "March", "April", "May", "June",
    "July", "August", "September", "October", "November", "December"];

  constructor(private apiClientService: ApiClientService) {
    let currentDate: Date = new Date();
    let month: number = currentDate.getMonth();
    let year: number = currentDate.getFullYear();
    this.currentMonthShow = this.monthNames[month] + " " + year.toString().replace("20", "'");
    this.getDashboardData(month, year);

  }

  private getDashboardData(month: number, year: number) {
    console.log("Getting Dashboard stuff");
    this.apiClientService.getDashboardData(month, year)
      .subscribe(data => {
        // Funds Remaining        
        this.fundsLeftRep = parseFloat(data["fundsLeft"]).toFixed(2);
        // Last 5 Transactions
        for (let transaction of data["lastTransactions_5"]) {
          let newTransaction = new Transaction();
          newTransaction.description = transaction["description"],
          newTransaction.location = transaction["location"],
          newTransaction.type = transaction["type"],
          newTransaction.cost = transaction["cost"],
          newTransaction.timestamp = new Date(transaction["timestamp"]);

          this.last5Transactions.push(newTransaction);
        }
      });
  }

  ngOnInit() {
  }

}
