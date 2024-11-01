import { CreatecustomerContactMediumComponent } from './../../features/customer/customer-create/create-contact-medium/createcustomer-contact-medium.component';
import { CustomerSearchRequest } from '../../shared/models/customer/customerSearchRequest';
import { Observable } from 'rxjs';
import { CustomerSearchResponse } from '../../shared/models/customer/customerSearchResponse';
import { customerCreateInfoResponse } from '../../shared/models/customer/customerCreateInfoResponse';
import { customerCreateInfoRequest } from '../../shared/models/customer/customerCreateInfoRequest';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';
import { Injectable } from '@angular/core';
import { searchNatIDRequest } from '../models/customer/searchNatIDRequest';
import{customerCreateContactMedRequest} from '../../shared/models/customer/customerCreateContactMedRequest';
import{customerCreateContactMedResponse} from '../models/customer/customerCreateContactMedResponse';
import { customerCreateAddRequest } from '../models/customer/customerCreateAddRequest';
import { customerCreateAddResponse } from '../models/customer/customerCreateAddResponse';


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
    createCustomerInfo(createInfoRequest: customerCreateInfoRequest): Observable<customerCreateInfoResponse> {
      return this.httpClient.post<customerCreateInfoResponse>(
        `${this.controllerUrl}/create`,
        createInfoRequest
      );
    }
    controllerUrl2: string = `${environment.MS_V1_API_URL}/customer/contactMediums`;
    createCustomerContactMedium(cerateCustContactMedRequest: customerCreateContactMedRequest):Observable<customerCreateContactMedResponse[]> {
      return this.httpClient.post<customerCreateContactMedResponse[]>(
        `${this.controllerUrl2}/create`,
        cerateCustContactMedRequest
      );
    }

    controllerUrl3: string = `${environment.MS_V1_API_URL}/customer/addresses`;

    createCustomerAddress(createCustomerAddRequest: customerCreateAddRequest): Observable<customerCreateAddResponse> {
        return this.httpClient.post<customerCreateAddResponse>(
            this.controllerUrl3,
            createCustomerAddRequest
        );
    }


   }