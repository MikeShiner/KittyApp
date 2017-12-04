import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Transaction } from '../class/transaction';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiClientService {

  private END_POINT: String = environment.microserverApiUrl;

  constructor(private http: HttpClient) {

  }


  public getDashboardData(month: number, year: number): Observable<object> {
    // const params = new HttpParams().set('page', '1');
    return this.http.get(this.END_POINT + "/dashboard");
  }

  public getTransactionTypes(): Observable<any> {
    return this.http.get(this.END_POINT + "/details/location");
  }

  public addTransaction(newTransaction: Transaction) {
    console.log(JSON.stringify(newTransaction));
    this.http.post(this.END_POINT + '/transactions', JSON.stringify(newTransaction)).subscribe((res) => {
      console.log(res);
    });
  }
}
