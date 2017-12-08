import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Transaction } from '../class/transaction';
import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiClientService {

  private END_POINT: String = environment.microserverApiUrl;

  constructor(private http: HttpClient) {

  }


  public getDashboardData(month: number, year: number): Observable<object> {
    const params = new HttpParams().set('month', month.toString())
                                   .set('year', year.toString())
                                   .set('q', this.cacheString());
    return this.http.get(this.END_POINT + "/dashboard", { params: params });
  }

  public getTransactionLocations(): Observable<any> {
    const params = new HttpParams().set('q', this.cacheString());

    return this.http.get(this.END_POINT + "/details/location", { params: params });
  }

  public getTransactionTypes(): Observable<any> {
    const params = new HttpParams().set('q', this.cacheString());
    return this.http.get(this.END_POINT + "/details/type", { params: params });
  }

  public addTransaction(newTransaction: Transaction) {
    const params = new HttpParams().set('q', this.cacheString());
    const headers = new HttpHeaders().set('Content-Type', 'application/json; charset=utf-8');

    return this.http.post(this.END_POINT + '/transactions/add', JSON.stringify(newTransaction), {headers: headers, params: params});
  }

  private cacheString(): string {
    return new Date().getTime().toString();
  }
}
