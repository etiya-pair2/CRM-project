import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Standalone component'ı doğrudan yükleyin
const routes: Routes = [
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
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule {}

