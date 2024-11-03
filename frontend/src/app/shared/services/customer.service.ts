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
import { customerDetailsResponse } from '../models/customer/customerDetailsResponse';
import { contactMediumInfoResponse } from '../models/customer/contactMediumInfoResponse';
import {customerGetCityResponse} from '../models/customer/customerGetCityResponse';
import { customerGetDisctrictsByCityIdResponse } from '../models/customer/customerGetDisctrictsByCityIdResponse';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  private readonly controllerUrl = `${environment.MS_V1_API_URL}/customer/individualCustomers`;
  private readonly controllerUrl2 = `${environment.MS_V1_API_URL}/customer/contactMediums`;
  private readonly controllerUrl3 = `${environment.MS_V1_API_URL}/customer/addresses`;
  private readonly controllerUrl4=`${environment.MS_V1_API_URL}/customer/cities`;
  private readonly controllerUrl5=`${environment.MS_V1_API_URL}/customer/districts`;
  private customerId: string | null = null;
  private contactMediumId:string | null = null;


  constructor(private httpClient: HttpClient) {}
  setCustomerId(id: string): void {
    this.customerId = id;
  }

  // Müşteri ID'sini almak için getter
  getCustomerId(): string | null {
    return this.customerId;
  }

  setContactMediumId(id: string): void {
    this.contactMediumId = id;
  }

  getContactMediumId(): string | null {
    return this.contactMediumId;
  }

  searchCustomer(searchRequest: CustomerSearchRequest): Observable<CustomerSearchResponse[]> {
    return this.httpClient.post<CustomerSearchResponse[]>(
      `${this.controllerUrl}/search`,
      searchRequest
    );
  }

  searchCustomerNatId(searchNatIdRequest: searchNatIDRequest): Observable<CustomerSearchResponse[]> {
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

  createCustomerContactMedium(createCustContactMedRequest: customerCreateContactMedRequest): Observable<customerCreateContactMedResponse> {
    return this.httpClient.post<customerCreateContactMedResponse>(
      `${this.controllerUrl2}/create`,
      createCustContactMedRequest
    );
  }
  

  createCustomerAddress(createCustomerAddRequest: customerCreateAddRequest): Observable<customerCreateAddResponse> {
    return this.httpClient.post<customerCreateAddResponse>(
      `${this.controllerUrl3}/create`,
      createCustomerAddRequest
    );
  }

  getCustomerDetails(customerId: string): Observable<customerDetailsResponse> {
    return this.httpClient.get<customerDetailsResponse>(
      `${this.controllerUrl}/${customerId}`
    );
  }

  getContactDetails(contactMediumId: string): Observable<contactMediumInfoResponse> {
    return this.httpClient.get<contactMediumInfoResponse>(
      `${this.controllerUrl2}/${contactMediumId}`);
  }

  getCity(): Observable<customerGetCityResponse[]> {
    return this.httpClient.get<customerGetCityResponse[]>(`${this.controllerUrl4}/getAll`);
}

  getDistrictsByCityId(id: string): Observable<customerGetDisctrictsByCityIdResponse[]> {
    return this.httpClient.get<customerGetDisctrictsByCityIdResponse[]>(`${this.controllerUrl5}/getCityId/${id}`);
}


}