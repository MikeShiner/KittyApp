import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { DashboardComponent } from './dashboard/dashboard.component';

import { ApiClientService } from './api-client.service';
import { NavigationComponent } from './navigation/navigation.component';
import { AddTransactionComponent } from './dashboard/sub-components/add-transaction/add-transaction.component';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    NavigationComponent,
    AddTransactionComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [ApiClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
