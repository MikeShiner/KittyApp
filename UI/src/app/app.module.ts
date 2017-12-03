import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AppRoutes } from './app.routing';
import { SidebarModule } from './sidebar/sidebar.module';
import { FooterModule } from './shared/footer/footer.module';
import { NavbarModule} from './shared/navbar/navbar.module';

import { DashboardComponent }   from './dashboard/dashboard.component';
import { TransactionsComponent }   from './transactions/transactions.component';
import { ApiClientService } from './services/apiclient.service';

@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    TransactionsComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    RouterModule.forRoot(AppRoutes),
    SidebarModule,
    NavbarModule,
    FooterModule],
  providers: [ApiClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
