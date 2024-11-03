import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../../../shared/components/navbar/navbar.component';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../../shared/services/customer.service';  
import { customerCreateAddRequest } from '../../../shared/models/customer/customerCreateAddRequest';
import { customerCreateAddResponse } from '../../../shared/models/customer/customerCreateAddResponse';
import { customerGetCityResponse } from '../../../shared/models/customer/customerGetCityResponse';
import { customerGetDisctrictsByCityIdResponse } from '../../../shared/models/customer/customerGetDisctrictsByCityIdResponse';
import { ToastrService } from 'ngx-toastr';
import { customerGetAddressByCustomerIdResponse } from '../../../shared/models/customer/customerGetAddressByCustomerIdResponse';

@Component({
  selector: 'app-address',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent, CommonModule, FormsModule, RouterModule],
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.scss']
})
export class AddressComponent implements OnInit {
  addresses: { city: string; district: string; postalcode: string; description: string; }[] = [];
  isPopupVisible = false;
  newAddress = { 
    city: null as customerGetCityResponse | null, 
    district: null as customerGetDisctrictsByCityIdResponse | null, 
    postalcode: '', 
    description: '' 
  };

  customerId?: string;
  cities: customerGetCityResponse[] = [];
  districts: customerGetDisctrictsByCityIdResponse[] = [];
  submitted = false;

  constructor(
    private customerService: CustomerService, 
    private router: Router, 
    private route: ActivatedRoute, 
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    // ActivatedRoute üzerinden customerId'yi al

    const customerId = this.customerService.getCustomerId();
      if (customerId) {
        this.getAddresses(customerId);
      }
  
    // Şehirleri yükle
    this.customerService.getCity().subscribe((response: customerGetCityResponse[]) => {
      this.cities = response;
    });
  }

  getAddresses(customerId: string) {
    this.customerService.getAddressByCustomerId(customerId).subscribe(
      (response: customerGetAddressByCustomerIdResponse[]) => {
        this.addresses = response.map(address => ({
          city: address.cityName || 'Unknown', // Şehir bilgisi
          district: address.districtName || 'Unknown', // İlçe bilgisi
          postalcode: address.postalCode,
          description: address.description
        }));
      },
      (error) => {
        console.error('Error fetching addresses:', error);
        this.toastr.error("Error fetching addresses.");
      }
    );
  }

  showCreateAddressPopup() {
    this.isPopupVisible = true;
  }

  closePopup() {
    this.isPopupVisible = false;
    this.newAddress = { city: null, district: null, postalcode: '', description: '' };
  }

  onCityChange(): void {
    const selectedCity = this.newAddress.city;
    if (selectedCity && selectedCity.id) {
      this.customerService.getDistrictsByCityId(selectedCity.id).subscribe((response: customerGetDisctrictsByCityIdResponse[]) => {
        this.districts = response;
      });
    } else {
      this.districts = [];
    }
  }

  saveAddress() {
    this.submitted = true;
    if (!this.newAddress.city || !this.newAddress.district || !this.newAddress.postalcode) {
      return; 
    }
  
    const districtId = this.newAddress.district ? this.newAddress.district.id : null;
    if (!districtId) {
      return; 
    }
  
    const createCustomerAddRequest: customerCreateAddRequest = {
      customerId: this.customerId!,
      districtId: districtId,
      postalCode: this.newAddress.postalcode,
      description: this.newAddress.description
    };
  
    this.customerService.createCustomerAddress(createCustomerAddRequest).subscribe(
      (response: customerCreateAddResponse) => {
        this.toastr.success("Customer address created successfully!");
        this.closePopup();
        this.getAddresses(this.customerId!); // Adresleri tekrar yükle
      },
      (error: any) => {
        console.error('Error occurred while creating customer address:', error);
      }
    );
  }
}
