import { Component, Input } from '@angular/core';
import { Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-header',
  standalone: true,
  templateUrl: './header.component.html',
  imports: [RouterModule],
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent {
  title: string = 'header';
  @Input() firstName: string = 'First Name';
  @Input() lastName: string = 'Last Name';

  constructor
    (
      private router: Router
    ) { }

}
