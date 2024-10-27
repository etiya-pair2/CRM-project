import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

// Standalone component'ı doğrudan yükleyin
const routes: Routes = [
  {
    path: 'search',
    loadComponent: () => import('./customer-search/customer-search.component').then(c => c.CustomerSearchComponent)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule {}