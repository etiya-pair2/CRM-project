import { Component } from '@angular/core';
import { NavbarComponent } from '../../../shared/components/navbar/navbar.component';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';

@Component({
  selector: 'app-customer-account',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent],
  templateUrl: './customer-account.component.html',
  styleUrl: './customer-account.component.scss'
})
export class CustomerAccountComponent {

}
