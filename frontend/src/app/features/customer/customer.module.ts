import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CustomerInfoComponent } from './customer-create/customer-info/customer-info.component';
import { CreatecustomerComponent } from './customer-create/createcustomer/createcustomer.component';

@NgModule({
imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    CreatecustomerComponent,
    CustomerInfoComponent
  ],
})
export class CustomerModule { }
