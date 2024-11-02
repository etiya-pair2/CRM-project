import { MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../../../shared/services/customer.service';
import { customerCreateAddRequest } from '../../../../shared/models/customer/customerCreateAddRequest';
import { customerCreateAddResponse } from '../../../../shared/models/customer/customerCreateAddResponse';
import { Component, OnInit } from "@angular/core";
import { customerGetCityResponse } from '../../../../shared/models/customer/customerGetCityResponse';
import { customerGetDisctrictsByCityIdResponse } from '../../../../shared/models/customer/customerGetDisctrictsByCityIdResponse';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-create-address',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './create-address.component.html',
  styleUrls: ['./create-address.component.scss']
})
export class CreateAddressComponent implements OnInit {
  addressForm: FormGroup;
  customerId?: string;
  cities: customerGetCityResponse[] = []; // Dinamik şehir listesi
  districts: customerGetDisctrictsByCityIdResponse[] = []; // Dinamik ilçe listesi
  
  

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) {
    this.addressForm = this.fb.group({
      city: ['', Validators.required],
      district: [{ value: '', disabled: true }, Validators.required],
      postalCode: ['', Validators.required],
      addressDescription: ['', Validators.required],
      flatNumber: ['']
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.customerId = params['customerId'];
    });

    // Şehirleri yükle
    this.customerService.getCity().subscribe((response: customerGetCityResponse[]) => {
      this.cities = response; // API'den gelen şehirleri al
    });
  }

  onCityChange(): void {
    const selectedCity = this.addressForm.get('city')?.value; // Seçilen şehir nesnesini al
    this.addressForm.get('district')?.enable(); // İlçeyi etkinleştir
    this.addressForm.get('district')?.setValue(''); // İlçeyi sıfırla

    // İlçeleri yükle
    if (selectedCity && selectedCity.id) {
      const cityId = selectedCity.id; // Seçilen şehrin ID'sini al
      this.customerService.getDistrictsByCityId(cityId).subscribe((response: customerGetDisctrictsByCityIdResponse[]) => {
        this.districts = response; // API'den gelen ilçeleri al
      });
    } else {
      this.districts = []; // Eğer şehir yoksa ilçeleri temizle
    }
  }

  next(): void {
    if (this.addressForm.invalid) {
      return; // Form geçersizse gönderimi engelle
    }
  
    const createCustomerAddRequest: customerCreateAddRequest = { 
      customerId: this.customerId!, 
      districtId: this.addressForm.value.district.id, 
      postalCode: this.addressForm.value.postalCode, 
      description: this.addressForm.value.addressDescription,
      flatNumber: this.addressForm.value.flatNumber !== undefined ? this.addressForm.value.flatNumber : "" // Flat number boşsa boş string gönder
    };
  
    this.customerService.createCustomerAddress(createCustomerAddRequest).subscribe(
      (response: customerCreateAddResponse) => {
        this.toastr.success("Müşteri adresi başarıyla oluşturuldu!");
        this.router.navigate(['/customer/contactMedium'], { queryParams: { customerId: response.customerId } });
      },
      (error: any) => {
        console.error('Müşteri adresi oluşturulurken bir hata oluştu:', error);
      }
    );
  }
  
  
}
