import { Component, Output, EventEmitter } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {
  activeTab: string = 'generalInfo';

  @Output() tabChanged = new EventEmitter<string>();

  setActiveTab(tab: string) {
    this.activeTab = tab;
    this.tabChanged.emit(tab);
  }
}
