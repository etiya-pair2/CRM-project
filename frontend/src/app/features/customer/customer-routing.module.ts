import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerSearchComponent } from './customer-search/customer-search.component';
 
const routes: Routes = [{ path: 'search', component: CustomerSearchComponent }];
 
@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CustomerRoutingModule {}