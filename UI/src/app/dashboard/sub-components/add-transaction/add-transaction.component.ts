import { Component, OnInit } from '@angular/core';
import { Transaction } from '../../../classes/transaction';

@Component({
  selector: 'add-transaction-form',
  templateUrl: './add-transaction.component.html',
  styleUrls: ['./add-transaction.component.css']
})
export class AddTransactionComponent implements OnInit {

  private transaction: Transaction = new Transaction()

  private showTypeManual = false;
  private showLocationManual = false;

  constructor() { }

  ngOnInit() {
  }

  dropdownToggleCheck(selection, input) {
    console.log(selection, input);
    if (input == "location"){
      if (selection == "Other") {
        this.showLocationManual = true;
      } else {
        this.showLocationManual = false;
      }
    }
    console.log(this.showLocationManual);
  }

}
