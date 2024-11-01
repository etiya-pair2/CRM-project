import { MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CustomerService } from '../../../../shared/services/customer.service';
import { customerCreateAddRequest } from '../../../../shared/models/customer/customerCreateAddRequest';
import { customerCreateAddResponse } from '../../../../shared/models/customer/customerCreateAddResponse';
import { Component } from "@angular/core";

@Component({
  selector: 'app-create-address',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, ReactiveFormsModule, RouterModule],
  templateUrl: './create-address.component.html',
  styleUrls: ['./create-address.component.scss']
})
export class CreateAddressComponent {
  addressForm: FormGroup;
  customerId?: string;

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.addressForm = this.fb.group({
      city: ['', Validators.required],
      district: ['', Validators.required],
      postalCode: ['', Validators.required],
      addressDescription: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.customerId = params['customerId'];
    });
  }

  next(): void {
    if (this.addressForm.invalid) {
      return; // Prevent submission if form is invalid
    }

    const createCustomerAddRequest: customerCreateAddRequest = { 
      customerId: this.customerId!, 
      district: this.addressForm.value.district, 
      postalCode: this.addressForm.value.postalCode, 
      description: this.addressForm.value.addressDescription 
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
