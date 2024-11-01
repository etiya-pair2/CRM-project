
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Standalone component'ı doğrudan yükleyin
const routes: Routes = [
  {
    path: '',
    redirectTo: 'search', // Ana rotayı doğrudan login sayfasına yönlendiriyoruz
    pathMatch: 'full',
  },
  {
    path: 'search',
    loadComponent: () => import('./customer-search/customer-search.component').then(c => c.CustomerSearchComponent)
  },
  {
    path: 'info',
    loadComponent: () => import('./customer-create/customer-info/customer-info.component').then(c => c.CustomerInfoComponent)
  },
  {
    path: 'create',
    loadComponent: () => import('./customer-create/createcustomer/createcustomer.component').
      then(c => c.CreatecustomerComponent)
  },
  {
    path: 'generalInfo',
    loadComponent: () => import('./general-info/general-info.component').
      then(c => c.GeneralInfoComponent)
  },
  {
    path: 'contactMedium', 
    loadComponent: () => import('./customer-create/create-contact-medium/createcustomer-contact-medium.component').
      then(c => c.CreatecustomerContactMediumComponent)
  },
  {
    path: 'address',
    loadComponent: () => import('./customer-create/create-address/create-address.component').then(c=>c.CreateAddressComponent)
    
  },
  {
    path: 'customerAccount',
    loadComponent: () => import('./customer-account/customer-account.component').
    then(c=>c.CustomerAccountComponent)
    
  },
  {
    path: 'contactMediumInfo',
    loadComponent: () => import('./contact-medium/contact-medium.component').
    then(c=>c.ContactMediumComponent)
    
  },
  {
    path: 'addressInfo',
    loadComponent: () => import('./address/address.component').then(c=>c.AddressComponent)
    
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule { }

