import { CustomerSearchRequest } from '../../shared/models/customer/customerSearchRequest';
import { Observable } from 'rxjs';
import { CustomerSearchResponse } from '../../shared/models/customer/customerSearchResponse';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
//import { CustomerCreateRequest } from '../../features/customer/models/customerCreateRequest';
//import { CustomerCreateResponse } from '../../features/customer/models/customerCreateResponse';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
    controllerUrl: string = `${environment.MS_V1_API_URL}/individualcustomers`;
    constructor(private httpClient: HttpClient) {}
    searchCustomer(searchRequest: CustomerSearchRequest): Observable<CustomerSearchResponse[]> {
        return this.httpClient.post<CustomerSearchResponse[]>(
          `${this.controllerUrl}/search`,
          searchRequest
        );
      }
      //createCustomer(createRequest: CustomerCreateRequest):Observable<CustomerCreateResponse>{
       // return this.httpClient.post<CustomerCreateResponse>(
        //  `${this.controllerUrl}`,
        //  createRequest
       // )
      //}
   // 
   }