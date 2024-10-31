import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [],
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
