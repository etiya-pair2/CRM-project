import { Component, OnInit } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layouts/main-layout/main-layout.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../../../shared/services/customer.service';
import { customerCreateInfoResponse } from '../../../../shared/models/customer/customerCreateInfoResponse';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-customerinfo',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule, RouterModule],
  templateUrl: './customer-info.component.html',
  styleUrl: './customer-info.component.scss'
})
export class CustomerInfoComponent implements OnInit {
  constructor(
    private router: Router,
    private customerService: CustomerService,
    private route: ActivatedRoute,
    private toastr: ToastrService
  ) { }
  isSaveEnabled: boolean = true;
  customerId: string | null = null;

  customer = {
    firstName: '',
    middleName: '',
    lastName: '',
    birthday: '',
    gender: '',
    fatherName: '',
    motherName: '',
    nationalityId: ''
  };

  ngOnInit(): void {
    // URL'den customerId'yi al

    this.route.queryParams.subscribe(params => {
      this.customer.nationalityId = params['natId']; // queryParams'tan alın

    });
  }

  onPrevious() {
    console.log("Previous button clicked");
  }

  save(): void {
    const createInfoRequest = {
      firstName: this.customer.firstName,
      middleName: this.customer.middleName,
      lastName: this.customer.lastName,
      birthday: this.customer.birthday,
      gender: this.customer.gender,
      fatherName: this.customer.fatherName,
      motherName: this.customer.motherName,
      nationalityId: this.customer.nationalityId
    };

    this.customerService.createCustomerInfo(createInfoRequest).subscribe(
      (response) => {
        this.toastr.success("Müşteri Başarlı Bir Şekilde Oluşturuldu!")
        this.router.navigate(['/customer/address'], { queryParams: { customerId: response.customerId } });
        this.customerService.setCustomerId(response.customerId);
      },
      (error) => {
        const errorMessages = error.error?.message || "Bir Hata Oluştu";
        this.toastr.warning(errorMessages)
      }
    );
  }
}
