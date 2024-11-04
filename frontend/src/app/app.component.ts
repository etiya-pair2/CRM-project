import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeaderComponent } from './shared/components/header/header.component';


// SPA => Single Page Application
@Component({
  selector: 'app-root', 
  standalone: true, 
  imports: [RouterOutlet,HeaderComponent],
  templateUrl: './app.component.html', 
  styleUrls: ['./app.component.scss'], 
})
export class AppComponent {
  title = 'etiya9.angular';
}
