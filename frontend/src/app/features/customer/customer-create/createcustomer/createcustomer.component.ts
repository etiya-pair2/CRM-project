import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent as MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; // Router'ı içe aktar
@Component({
  selector: 'app-createcustomer',
  standalone: true,
  imports: [MainLayoutComponent,CommonModule,FormsModule],
  templateUrl: './createcustomer.component.html',
  styleUrl: './createcustomer.component.scss'
})
export class CreatecustomerComponent implements OnInit {
  natId: string = ''; // Input değeri
  isNextEnabled: boolean = false; // Butonun aktifliği
  showPopup: boolean = false; // Popup görünürlüğü
 
  constructor(private router: Router) {};
  
  clear() {
     throw new Error('Method not implemented.');
  }
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  onInputChange() {
    this.isNextEnabled = this.natId.trim().length > 0; // Boş değilse aktif et
  }
  checkCustomerExists() {
    // Dummy data for demo purposes
    const existingCustomers = ['123', '456']; // Örnek müşteri ID'leri
    if (existingCustomers.includes(this.natId)) {
      this.showPopup = true; // Popup'ı göster
    }
    else{
      this.router.navigate(['/customerinfo']); // Müşteri yoksa customerinfo sayfasına yönlendir
    }
  }

  closePopup() {
    this.showPopup = false; // Popup'ı kapat
    this.router.navigate(['/customer-create']); // Yönlendirme
    this.natId = ''; // Input alanını temizle
    this.isNextEnabled = false; // Butonu devre dışı bırak
  }

}
