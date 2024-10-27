import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './shared/components/header/header.component';


// SPA => Single Page Application
@Component({
  selector: 'app-root', // Componentlar diğer comp. içerisinde kullanılabilir, bu alan nasıl çağıralacağını belirler.
  standalone: true, // Angular 18 öncesi componentlar bir modüle bağlı olmak zorunda idi, artık bağımsız component..
  imports: [RouterOutlet,HeaderComponent], // bu component angularda diğer özelliklerin hangilerini import ediyor?
  templateUrl: './app.component.html', // hangi HTML ile çalışacak?
  styleUrls: ['./app.component.scss'], // Hangi stil(ler) ile çalışacak?
})
export class AppComponent {
  title = 'etiya9.angular';
}
