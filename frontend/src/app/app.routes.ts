import { Routes } from '@angular/router';
import { TodoListComponent } from './shared/components/todo-list/todo-list.component';

//Lazy Loading
//yani şuu sayfayı, ilgili sayfam yüklendikten sonra yükle diyoruz
//loadComponent()
//bu sayede LazyLoading ile büyük ölçekli uygulamalarda performans artırıyoruz.
export const routes: Routes = [
  { path: 'homepage', redirectTo: '' },
  {
    loadComponent: () => import('../app/shared/pages/homepage/homepage.component').then(
      (c) => c.HomepageComponent
    ),
  },
  {
    path: 'todolist', loadComponent: () => import('../app/shared/components/todo-list/todo-list.component').then(
      (c) => c.TodoListComponent
    )
  },
  {
    path: 'login', loadComponent: () => import('../app/shared/pages/login/login.component').then(
      (c) => c.LoginComponent
    )
  },
  //{path:'/login',component:LoginComponent}
];
