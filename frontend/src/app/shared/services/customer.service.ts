import { CustomerSearchRequest } from '../../shared/models/customer/customerSearchRequest';
import { Observable } from 'rxjs';
import { CustomerSearchResponse } from '../../shared/models/customer/customerSearchResponse';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { searchNatIDRequest } from '../models/customer/searchNatIDRequest';


@Injectable({
  providedIn: 'root'
})
export class CustomerService {
    controllerUrl: string = `${environment.MS_V1_API_URL}/customer/individualCustomers`;
    constructor(private httpClient: HttpClient) {}
    searchCustomer(searchRequest: CustomerSearchRequest): Observable<CustomerSearchResponse[]> {
        return this.httpClient.post<CustomerSearchResponse[]>(
          `${this.controllerUrl}/search`,
          searchRequest
        );
      }
      searchCustomerNatId(searchNatIdRequest: searchNatIDRequest):Observable<CustomerSearchResponse[]>{
        return this.httpClient.post<CustomerSearchResponse[]>(
          `${this.controllerUrl}/search`,
          searchNatIdRequest
        );
      }
   
   }