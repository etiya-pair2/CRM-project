import { Component } from '@angular/core';
import { NavbarComponent } from '../../../shared/components/navbar/navbar.component';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../../shared/services/customer.service';  
import { customerCreateAddRequest } from '../../../shared/models/customer/customerCreateAddRequest';
import { customerCreateAddResponse } from '../../../shared/models/customer/customerCreateAddResponse';

@Component({
  selector: 'app-address',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent, CommonModule, FormsModule, RouterModule],
  templateUrl: './address.component.html',
  styleUrl: './address.component.scss'
})
export class AddressComponent {
  addresses = [
    { city: 'New York', district: 'Manhattan', postalcode: '10001', description: '123 Main St' },
    { city: 'Los Angeles', district: 'Hollywood', postalcode: '90028', description: '456 Sunset Blvd' },
    { city: 'Brisbane', district: 'QLD', postalcode: '4000', description: '27 George St' }
  ]; // Kayıtlı adresler
  isPopupVisible = false; // Pop-up görünürlüğü
  newAddress = { city: '', district: '', postalcode: '', description: '' }; // Yeni adres bilgileri
  
  customerId?: string;
  district: string='';
  postalCode: string='';
  addressDescription:string='';

  constructor( private customerService: CustomerService, private router: Router, private route: ActivatedRoute) {};
    
  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.customerId = params['customerId'];
    });
  }
  showCreateAddressPopup() {
    this.isPopupVisible = true; // Pop-up'ı göster
  }

  closePopup() {
    this.isPopupVisible = false; // Pop-up'ı kapat
    this.newAddress = { city: '', district: '', postalcode: '', description: '' }; // Temizle
  }

  saveAddress() {
    // Yeni adresi mevcut adresler listesine ekle
    this.addresses.push({ ...this.newAddress });
    this.closePopup(); // Pop-up'ı kapat

    const createCustomerAddRequest: customerCreateAddRequest = { 
      customerId: this.customerId!, 
      district: this.district, 
      postalCode: this.postalCode, 
      description: this.addressDescription 
    };

    this.customerService.createCustomerAddress(createCustomerAddRequest).subscribe(
      (response: customerCreateAddResponse) => {
        console.log('Customer address created successfully:', response);
        //this.router.navigate(['/customer/contactMedium']); 
      },
      (error: any) => {
        console.error('Error occurred while creating customer address:', error);
      }
    );
  }
}
