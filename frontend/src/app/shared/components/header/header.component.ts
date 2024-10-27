import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  title: string = 'header';
  @Input() firstName: string = 'First Name';
  @Input() lastName: string = 'Last Name';
}
