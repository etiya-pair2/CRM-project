import { Component } from '@angular/core';
import { NavbarComponent } from '../../../shared/components/navbar/navbar.component';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';

@Component({
  selector: 'app-contact-medium',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent],
  templateUrl: './contact-medium.component.html',
  styleUrl: './contact-medium.component.scss'
})
export class ContactMediumComponent {

}
