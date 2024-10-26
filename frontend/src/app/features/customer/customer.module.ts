
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
 
import { CustomerRoutingModule } from './customer-routing.module';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
 
 
@NgModule({
  declarations: [
    CustomerSearchComponent
],
  imports: [
    CommonModule,
    CustomerRoutingModule
  ]
})
export class CustomerModule { }