import { MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../../../shared/services/customer.service';
import { customerCreateAddRequest } from '../../../../shared/models/customer/customerCreateAddRequest';
import { customerCreateAddResponse } from '../../../../shared/models/customer/customerCreateAddResponse';
import { Component } from "@angular/core";

@Component({
  selector: 'app-create-address',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule, RouterModule],
  templateUrl: './create-address.component.html',
  styleUrls: ['./create-address.component.scss']
})
export class CreateAddressComponent {
  city: string = '';
  district: string = '';
  postalCode: string = '';
  addressDescription: string = '';
  cityErrorMessage: string = '';
  districtErrorMessage: string = '';
  postalCodeErrorMessage: string = '';
  descriptionErrorMessage: string = '';
  customerId?: string;

  constructor(private customerService: CustomerService, private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.customerId = params['customerId'];
    });
  }

  onInputChange(): void {
    this.cityErrorMessage = '';
    this.districtErrorMessage = '';
    this.postalCodeErrorMessage = '';
    this.descriptionErrorMessage = '';
  }

  next(event: Event): void {
    event.preventDefault();

    let hasError = false;

    if (!this.city) {
      this.cityErrorMessage = 'Şehir boş olamaz.';
      hasError = true;
    }
    
    if (!this.district) {
      this.districtErrorMessage = 'İlçe boş olamaz.';
      hasError = true;
    }
    
    if (!this.postalCode) {
      this.postalCodeErrorMessage = 'Posta Kodu boş olamaz.';
      hasError = true;
    }
    
    if (!this.addressDescription) {
      this.descriptionErrorMessage = 'Adres Tanımı boş olamaz.';
      hasError = true;
    }

    if (hasError) {
      return; 
    }

    const createCustomerAddRequest: customerCreateAddRequest = { 
      customerId: this.customerId!, 
      district: this.district, 
      postalCode: this.postalCode, 
      description: this.addressDescription 
    };
        
    this.customerService.createCustomerAddress(createCustomerAddRequest).subscribe(
      (response: customerCreateAddResponse) => {
        console.log('Customer address created successfully:', response);
        this.router.navigate(['/customer/contactMedium']); 
      },
      (error: any) => {
        console.error('Error occurred while creating customer address:', error);
      }
    );
  }
}
