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
  public last5Transactions: Array<Object>;
  private state: string = "closed";

  private dashboardData: DashboardData = new DashboardData();
  private location_dropdown: Array<string>;
  type_dropdown: Array<string> = ['one', 'two'];

  private quickAddTransaction: Transaction = new Transaction();
  
  
  
  // Quick Add form controls
  quickAddForm: FormGroup;
  locationCtrl: FormControl = new FormControl();
  typeCtrl: FormControl = new FormControl();
  descriptionCtrl: FormControl = new FormControl();
  costCtrl: FormControl = new FormControl();
  dateCtrl: FormControl = new FormControl();


  constructor(private apiClientService: ApiClientService, private fb: FormBuilder) {
    this.quickAddForm = this.fb.group({
      'type': new FormControl('', Validators.required),
      'location': new FormControl('', Validators.required),
      'description': new FormControl('', Validators.required),
      'cost': new FormControl('', Validators.required),
      'date': new FormControl('', Validators.required)
    });
  }

  ngOnInit() {
    this.refreshDashboard();
  }
  
  refreshDashboard(){    
    this.apiClientService.getDashboardData(1, 1).subscribe((data) => {
      this.dashboardData.fundsLeft = data["fundsLeft"];
      this.dashboardData.last5Transactions = data["lastTransactions_5"];
    });
  
    this.apiClientService.getTransactionTypes().subscribe((data) => {
      this.location_dropdown = data;
      console.log(this.location_dropdown);
      console.log(this.type_dropdown);
    });
  }

  toggle() {
    this.state = (this.state == "open") ? "closed" : "open";
  }

  submitForm() {
    console.log("Form Submitted!");
    console.log(this.quickAddForm);
    
  }

}