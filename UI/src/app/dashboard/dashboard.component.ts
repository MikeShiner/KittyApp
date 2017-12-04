import { Component, OnInit, EventEmitter } from '@angular/core';
// import * as Chartist from 'chartist';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { state, trigger, stagger, animate, style, group, query, transition, keyframes } from '@angular/animations';

import {FormControl} from '@angular/forms';

import { ApiClientService } from '../services/apiclient.service';
import { Observable } from 'rxjs/Observable';
import { DashboardData } from '../class/dashboard-data';
import { Transaction } from 'app/class/transaction';

declare var $: any;

@Component({
  selector: 'dashboard-cmp',
  moduleId: module.id,
  templateUrl: 'dashboard.component.html',
  animations: [
    trigger('toggle', [
      state('open', style({ height: '*' })),
      // asterisk calculates the size of the element
      state('closed', style({ height: '0px' })),
      transition('open <=> closed', animate('200ms ease-in-out'))
    ])
  ]
})

export class DashboardComponent implements OnInit {
  public last5Transactions: Array<Object>;
  private state: string = "closed";

  private dashboardData: DashboardData = new DashboardData();
  private location_dropdown: Array<string>;
  private type_dropdown: Array<string>;

  private quickAddTransaction: Transaction = new Transaction();
  
  
  testArray: Array<string> = ['one', 'two'];
  
  // Quick Add form controls
  locationCtrl: FormControl = new FormControl();
  typeCtrl: FormControl = new FormControl();
  descriptionCtrl: FormControl = new FormControl();
  costCtrl: FormControl = new FormControl();
  dateCtrl: FormControl = new FormControl();


  constructor(private apiClientService: ApiClientService) {
    
  }

  ngOnInit() {

    this.apiClientService.getDashboardData(1, 1).subscribe((data) => {
      this.dashboardData.fundsLeft = data["fundsLeft"];
      this.dashboardData.last5Transactions = data["lastTransactions_5"];
    });

    this.apiClientService.getTransactionTypes().subscribe((data) => {
      this.location_dropdown = data;
    });
  }

  toggle() {
    this.state = (this.state == "open") ? "closed" : "open";
  }
  onSubmit() {
    console.log("Form Submitted!");
    
    if(this.typeCtrl.value != null) {
      this.quickAddTransaction.type = this.typeCtrl.value;
    } 
    if(this.locationCtrl.value != null) {
      this.quickAddTransaction.location = this.locationCtrl.value;
    }
    if (this.descriptionCtrl.value != null) {
      this.quickAddTransaction.description = this.descriptionCtrl.value;
    }
    if(this.costCtrl.value != null && !isNaN(this.costCtrl.value)) {
      this.quickAddTransaction.cost = this.costCtrl.value;
    }
    if(this.dateCtrl.value != null) {
      this.quickAddTransaction.date = this.dateCtrl.value;
    }
    this.apiClientService.addTransaction(this.quickAddTransaction);
    console.log(this.quickAddTransaction);
  }

}