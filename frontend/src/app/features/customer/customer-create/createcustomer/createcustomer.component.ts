import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent as MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router,RouterModule } from '@angular/router'; // Router'ı içe aktar
import { searchNatIDRequest } from '../../../../shared/models/customer/searchNatIDRequest';
import { CustomerSearchResponse } from '../../../../shared/models/customer/customerSearchResponse';
import { CustomerService } from '../../../../shared/services/customer.service';
@Component({
  selector: 'app-createcustomer',
  standalone: true,
  imports: [MainLayoutComponent,CommonModule,FormsModule,RouterModule],
  templateUrl: './createcustomer.component.html',
  styleUrl: './createcustomer.component.scss'
})
export class CreatecustomerComponent implements OnInit {
  natId: string = ''; // Input değeri
  isNextEnabled: boolean = false; // Butonun aktifliği
  showPopup: boolean = false; // Popup görünürlüğü
  isSearchEnabled: boolean = true;
  errorMessage:string= '';
 
  constructor( private customerService: CustomerService, private router: Router) {};
  

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  onInputChange() {
    this.isNextEnabled = this.natId.trim().length > 0; // Boş değilse aktif et
  }
  search(): void {
    console.log('isSearchEnabled:', this.isSearchEnabled);
    if (this.isSearchEnabled) {
      //console.log('Searching for natId:', this.natId);
      const natId = this.natId;
  
      const searchNatIdRequest: searchNatIDRequest = { natId };
  
      this.customerService.searchCustomerNatId(searchNatIdRequest).subscribe(
        (response: CustomerSearchResponse[]) => {
          console.log('Response:', response);
          if (response && response.length > 0) {
            this.showPopup = true;
            this.router.navigate(['/customer/search'], { queryParams: { natId } });
          } else {
            // Hata durumu
            this.showPopup = true;
            this.errorMessage = 'No customer found with the given Nationality ID!';
            this.router.navigate(['/customer/info'], { queryParams: { natId } });
          }
        },
        (error: any) => {
          console.error('Search failed', error);
          this.showPopup  = true;
          this.errorMessage = 'An error occurred while searching for the customer.';
        }
      );
    } else {
      console.log('Search is not enabled');
    }
  }
  
  closePopup() {
    this.showPopup = false; // Popup'ı kapat
    this.natId = ''; // Input alanını temizle
    this.isNextEnabled = false; // Butonu devre dışı bırak

  }

}
