import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent as MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, RouterModule } from '@angular/router'; // Router'ı içe aktar
import { searchNatIDRequest } from '../../../../shared/models/customer/searchNatIDRequest';
import { CustomerSearchResponse } from '../../../../shared/models/customer/customerSearchResponse';
import { CustomerService } from '../../../../shared/services/customer.service';
declare var bootstrap: any;
@Component({
  selector: 'app-createcustomer',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule, RouterModule],
  templateUrl: './createcustomer.component.html',
  styleUrl: './createcustomer.component.scss'
})
export class CreatecustomerComponent {
  natId: string = ''; // Input değeri
  isNextEnabled: boolean = false; // Butonun aktifliği
  showPopup: boolean = false; // Popup görünürlüğü
  isSearchEnabled: boolean = true;
  errorMessage: string = '';

  constructor(private customerService: CustomerService, private router: Router) { };

  onInputChange() {
    this.isNextEnabled = this.natId.trim().length == 11; // Boş değilse aktif et
  }


  search(): void {
    const natId = this.natId;
    const searchNatIdRequest: searchNatIDRequest = { natId };

    this.customerService.searchCustomerNatId(searchNatIdRequest).subscribe(
      (response: CustomerSearchResponse[]) => {
        if (response && response.length > 0) {
          this.errorMessage = 'This Customer Already Exists!';
          this.openModal();
        } else {
          // Hata durumu
          this.errorMessage = 'No customer found with the given Nationality ID!';
          this.router.navigate(['/customer/info'], { queryParams: { natId } });
        }
      },
      (error: any) => {
        console.error('Search failed', error);
        this.showPopup = true;
        this.errorMessage = 'An error occurred while searching for the customer.';
      }
    );
  }

  openModal() {
    const modalElement = document.querySelector('.modal'); // Modal elementini seç
    if (modalElement) {
      const modal = new bootstrap.Modal(modalElement); // Bootstrap modal nesnesini oluştur
      modal.show(); // Modal'ı göster
    }
  }

  closePopup() {
    this.showPopup = false; // Popup'ı kapat
    this.natId = ''; // Input alanını temizle
    this.isNextEnabled = false; // Butonu devre dışı bırak

  }

}
