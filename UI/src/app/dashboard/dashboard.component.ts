import { Component, OnInit, EventEmitter } from '@angular/core';
// import * as Chartist from 'chartist';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { state, trigger, stagger, animate, style, group, query, transition, keyframes } from '@angular/animations';

import { FormControl, FormBuilder, FormGroup, Validators } from '@angular/forms';

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
  private state: string = "closed";
  private currentViewingDate = new Date();


  private dashboardData: DashboardData = new DashboardData();
  private location_dropdown: Array<string>;
  private types_dropdown: Array<string>;

  // Quick Add form controls
  private quickAddTransaction: Transaction = new Transaction();
  private quickAddForm: FormGroup;
  private formErrors: Array<String>;

  constructor(private apiClientService: ApiClientService, private fb: FormBuilder) {

    this.quickAddForm = this.fb.group({
      'type': new FormControl('', Validators.required),
      'location': new FormControl('', Validators.required),
      'description': new FormControl('', Validators.required),
      'cost': new FormControl('', Validators.compose([Validators.required, Validators.pattern(/\d+\.?\d*/)])),
      'date': new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.refreshDashboard(this.currentViewingDate);
  }

  refreshDashboard(date: Date) {
    let month = this.currentViewingDate.getMonth() + 1;
    let year = this.currentViewingDate.getFullYear();

    this.apiClientService.getDashboardData(month, year).subscribe((data) => {
      this.dashboardData.fundsLeft = data["fundsLeft"];
      this.dashboardData.last5Transactions = data["lastTransactions_5"];
    });

    this.apiClientService.getTransactionLocations().subscribe((data) => {
      this.location_dropdown = data;
    });
    this.apiClientService.getTransactionTypes().subscribe((data) => {
      this.types_dropdown = data;
    });
  }

  toggle() {
    this.state = (this.state == "open") ? "closed" : "open";
  }

  monthViewChange(date: Date) {
    this.currentViewingDate = date;
    this.refreshDashboard(date);
  }

  submitForm() {
    if (this.quickAddForm.status == "INVALID") {
      console.error("Form is invalid!");
    } else {
      let inputdate = this.quickAddForm.controls["date"].value;

      let stringDate = inputdate.getFullYear() + "-" + (inputdate.getMonth() + 1) +
        "-" + inputdate.getDate();
      this.quickAddTransaction.date = stringDate;

      this.quickAddTransaction.type = this.quickAddForm.controls["type"].value;
      this.quickAddTransaction.location = this.quickAddForm.controls["location"].value;
      this.quickAddTransaction.description = this.quickAddForm.controls["description"].value;
      this.quickAddTransaction.cost = parseInt(this.quickAddForm.controls["cost"].value);

      this.apiClientService.addTransaction(this.quickAddTransaction).subscribe((data) => {
        this.refreshDashboard(this.currentViewingDate);
        this.quickAddForm.reset();
      });
    }
  }
}