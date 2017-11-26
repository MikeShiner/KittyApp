import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { environment } from '../environments/environment';

@Injectable()
export class ApiClientService {

  public dashboardData: any;
  
  constructor(private http: HttpClient) { }  

  public getDashboardData(month: number, year: number) {
    // const params = new HttpParams().set('page', '1');
    return this.http.get(environment.microserverApiUrl + "/dashboard");
  }
}
