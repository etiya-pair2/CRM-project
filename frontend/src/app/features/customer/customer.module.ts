
import { CreatecustomerContactMediumComponent } from './customer-create/create-contact-medium/createcustomer-contact-medium.component';
import { Component, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CustomerInfoComponent } from './customer-create/customer-info/customer-info.component';
import { CreatecustomerComponent } from './customer-create/createcustomer/createcustomer.component';
import { CreateAddressComponent } from './customer-create/create-address/create-address.component';
import { CustomerAccountComponent } from './customer-account/customer-account.component';
import { ContactMediumComponent } from './contact-medium/contact-medium.component';
import { AddressComponent } from './address/address.component';



@NgModule({
imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    CreatecustomerComponent,
    CustomerInfoComponent,
    CreatecustomerContactMediumComponent,
    CustomerSearchComponent,
    CustomerSearchComponent,
    CreateAddressComponent,
    CustomerAccountComponent,
    ContactMediumComponent,
    AddressComponent

  ],
})
export class CustomerModule { }
