import { Component, Input } from '@angular/core';
import { NavbarComponent } from "../../../shared/components/navbar/navbar.component";
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';

interface CustomerField {
  label: string;
  value: string | null;
}

@Component({
  selector: 'app-general-info',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent],
  templateUrl: './general-info.component.html',
  styleUrl: './general-info.component.scss'
})

export class GeneralInfoComponent {
  @Input() customer: any = {}; // Data received from the backend
}
