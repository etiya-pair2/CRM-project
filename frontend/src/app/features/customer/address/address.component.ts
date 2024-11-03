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
  newAddress = { city: null as customerGetCityResponse | null, district: null as customerGetDisctrictsByCityIdResponse | null, postalcode: '', description: '' };
  
  customerId?: string;
  cities: customerGetCityResponse[] = [];
  districts: customerGetDisctrictsByCityIdResponse[] = [];
  submitted = false;

  constructor(private customerService: CustomerService, private router: Router, private route: ActivatedRoute, 
              private toastr: ToastrService) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.customerId = params['customerId'];
    });

    // Şehirleri yükle
    this.customerService.getCity().subscribe((response: customerGetCityResponse[]) => {
      this.cities = response;
    });
  }

  showCreateAddressPopup() {
    this.isPopupVisible = true;
  }

  closePopup() {
    this.isPopupVisible = false;
    this.newAddress = { city: null, district: null, postalcode: '', description: '' }; // Temizle
  }

  onCityChange(): void {
    const selectedCity = this.newAddress.city; // Seçilen şehir nesnesini al
    // İlçeleri yükle
    if (selectedCity && selectedCity.id) {
      const cityId = selectedCity.id;
      this.customerService.getDistrictsByCityId(cityId).subscribe((response: customerGetDisctrictsByCityIdResponse[]) => {
        this.districts = response; // API'den gelen ilçeleri al
      });
    } else {
      this.districts = [];
    }
  }

  saveAddress() {
    this.submitted = true; // Form gönderildi olarak işaretle
    if (!this.newAddress.city || !this.newAddress.district || !this.newAddress.postalcode) {
      //console.error('Form is invalid', this.newAddress);
      return; // Form geçersizse gönderimi engelle
    }
  
    //console.log('Submitting Address:', this.newAddress); // Burada newAddress'ı kontrol edin
  
    const districtId = this.newAddress.district ? this.newAddress.district.id : null;
  
    if (!districtId) {
      //console.error('District ID is null');
      return; // Eğer districtId null ise, fonksiyondan çık
    }
  
    const createCustomerAddRequest: customerCreateAddRequest = {
      customerId: this.customerId!,
      districtId: districtId,
      postalCode: this.newAddress.postalcode, // Burada kontrol edin
      description: this.newAddress.description // Burada kontrol edin
    };
  
    this.customerService.createCustomerAddress(createCustomerAddRequest).subscribe(
      (response: customerCreateAddResponse) => {
        this.toastr.success("Customer address created successfully!");
      },
      (error: any) => {
        console.error('Error occurred while creating customer address:', error);
      }
    );
  }
  
  

}


