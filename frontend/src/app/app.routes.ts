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
    path: 'homepage',
    loadComponent: () =>
      import('../app/shared/pages/homepage/homepage.component').then(
        (c) => c.HomepageComponent
      ),
    canActivate: [authGuard], // Giriş yapmamışsa yönlendirilir
  },
  {
    path: 'customer/search',
    component: CustomerSearchComponent,
  },
  {
    path: 'customer/create',
    component: CreatecustomerComponent,
  }
  
];
