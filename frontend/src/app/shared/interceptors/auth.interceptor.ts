import { HttpInterceptorFn } from '@angular/common/http';
import { catchError, finalize } from 'rxjs';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  // req => request(giden istek)
  // next => isteği devam ettirecek fonksiyon

  //req read only olduğu için bir clonunu oluşturuyoruz
  req = req.clone({
    setHeaders: {
      Authorization: `Bearear Token`,
      'Accept-Language': 'en'
    }
  })

  //Observable oluştuğunda istek atıyoruz ve cevap dönerken isteğin olduğu
  //yere cevap dönüyor. bu cevap dönerken işlemin bitiş noktasına
  //ulaşmadan herhangi bir noktasına pipe atıyoruz
  //finalize, isteğin bittiği yerde işlem yapar
  //rxJs dökümanına bak tüm pipe fonksiyonları ve hataları için
  return next(req).pipe(
    finalize(() => {
      console.log('istek başarıyla bitti');
    }),
    catchError((err) => {
      //global bir hata yönetimi yapabiliriz.
      console.log('interceptor hata yakaladı', err);
      throw err;

    })
  )
};
