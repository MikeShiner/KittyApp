import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../../environments/environment';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class ApiClientService {

  private END_POINT: String = environment.microserverApiUrl;

  constructor(private http: HttpClient) {

   }


  public getDashboardData(month: number, year: number): Observable<object> {
    // const params = new HttpParams().set('page', '1');
    return this.http.get(environment.microserverApiUrl + "/dashboard");
  }

  public getTransactionTypes(): Observable<any> {
    return this.http.get(environment.microserverApiUrl + "/details/location");
  }

}
