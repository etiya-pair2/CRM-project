import { Component } from '@angular/core';
import { NavbarComponent } from '../../../shared/components/navbar/navbar.component';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';

@Component({
  selector: 'app-address',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent],
  templateUrl: './address.component.html',
  styleUrl: './address.component.scss'
})
export class AddressComponent {

}
