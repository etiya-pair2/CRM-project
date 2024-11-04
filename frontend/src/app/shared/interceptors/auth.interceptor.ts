import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { catchError, finalize, tap } from 'rxjs';
import { StorageService } from '../services/storage.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  
  const storageService = inject(StorageService);

  req = req.clone({
    setHeaders: {
      Authorization: `Bearer ${storageService.get('token')}`,
      'Accept-Language': `en`,
    },
  });
  return next(req).pipe(
    finalize(() => {
      console.log('Interceptor isteğin bitttiğini yakaldı..');
    }),
    catchError((err) => {
      
      console.log('interceptor hata yakaladı:', err);
      throw err;
    })
  );
};
