import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
import { CreatecustomerComponent } from './customer-create/createcustomer/createcustomer.component';

@NgModule({
imports: [
    CommonModule,
    CustomerRoutingModule,
    ReactiveFormsModule,
    CreatecustomerComponent,
  ],
})
export class CustomerModule { }
