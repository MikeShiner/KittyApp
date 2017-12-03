import { Component, OnInit, EventEmitter } from '@angular/core';
// import * as Chartist from 'chartist';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { state, trigger, stagger, animate, style, group, query, transition, keyframes } from '@angular/animations';

import {FormControl} from '@angular/forms';

import { ApiClientService } from '../services/apiclient.service';
import { Observable } from 'rxjs/Observable';
import { DashboardData } from '../class/dashboard-data';

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

  testArray: Array<string> = ['one', 'two'];

  // Quick Add form controls
  qaLocControl = false;
  qaTypeControl = false;

  constructor(private apiClientService: ApiClientService) {

  }

  ngOnInit() {

    this.apiClientService.getDashboardData(1, 1).subscribe((data) => {
      this.dashboardData.fundsLeft = data["fundsLeft"];
      this.dashboardData.last5Transactions = data["lastTransactions_5"];
    });

    this.apiClientService.getTransactionTypes().subscribe((data) => {
      this.location_dropdown = data;
      console.log(this.location_dropdown);
    });
  }

  toggle() {
    this.state = (this.state == "open") ? "closed" : "open";
  }

  toggleOtherInput(type, value) {
    console.log(this.qaLocControl);
    if (type == "location") {
      if (value == "Other") {
        this.qaLocControl = true;
      } else {
        this.qaLocControl = false;
      }
    }

    if (type == "type") {
      if (value == "Other") {
        this.qaTypeControl = true;
      } else {
        this.qaTypeControl = false;
      }
    }
  }
}