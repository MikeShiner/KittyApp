import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-month-view-control',
  templateUrl: './month-view-control.component.html',
  styleUrls: ['./month-view-control.component.css']
})
export class MonthViewControlComponent implements OnInit {

  @Output() onViewChange = new EventEmitter<Date>();
  private currentViewingDate = new Date();

  private currentViewingDateString: string;
  private getMonthText: Array<string> = ['Jan', 'Feb', 'March', 'April', 'May', 'June', 'July', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec'];

  constructor() { }

  ngOnInit() {
    this.updateDateString();
  }

  private moveMonth(direction: string): void {
    if (direction == "next") {
      this.currentViewingDate.setMonth(this.currentViewingDate.getMonth() + 1);
    } else {
      this.currentViewingDate.setMonth(this.currentViewingDate.getMonth() - 1);
    }
    this.onViewChange.emit(this.currentViewingDate);
    this.updateDateString();
  }

  private updateDateString() {
    this.currentViewingDateString = this.getMonthText[this.currentViewingDate.getMonth()] + "   '" 
    + this.currentViewingDate.getFullYear().toString().substring(2,4);
  }

}
