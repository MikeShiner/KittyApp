import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  public getTransactionLocations(): Observable<any> {
    return this.http.get(this.END_POINT + "/details/location");
  }

  public getTransactionTypes(): Observable<any> {
    return this.http.get(this.END_POINT + "/details/type");
  }

  public addTransaction(newTransaction: Transaction) {
    let headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');
    return this.http.post(this.END_POINT + '/transactions/add', JSON.stringify(newTransaction), {headers: headers});
  }
}
