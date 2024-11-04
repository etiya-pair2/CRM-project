import { Routes } from '@angular/router';
import { authGuard } from './shared/guards/auth.guard';


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
    path: 'forgot-password', 
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
