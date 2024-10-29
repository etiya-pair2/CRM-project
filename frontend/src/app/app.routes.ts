import { Routes } from '@angular/router';
import { MainLayoutComponent } from './shared/layouts/main-layout/main-layout.component';
import { authGuard } from './shared/guards/auth.guard';
import { CreatecustomerComponent } from './features/customer/customer-create/createcustomer/createcustomer.component';
import { CustomerSearchComponent } from './features/customer/customer-search/customer-search.component';

// Lazy Loading
export const routes: Routes = [
  {
    path: '',
    redirectTo: 'login', // Ana rotayı doğrudan login sayfasına yönlendiriyoruz
    pathMatch: 'full',
  },
  
  {
    path: 'login',
    loadComponent: () =>
      import('../app/shared/pages/login/login.component').then(
        (c) => c.LoginComponent
      ),
  },
  {
    path: 'forgot-password', // Forgot Password için route
    loadComponent: () =>
      import('../app/shared/pages/forgot-password/forgot-password.component').then(
        (c) => c.ForgotPasswordComponent
      ),
  },

  {
    path: '',
    canActivate: [authGuard],
    children: [
      {
        path: 'customer',
        loadChildren: () =>
          import('../app/features/customer/customer.module').then(
            (m) => m.CustomerModule
          ),
      },
    ],
  },

  
];
