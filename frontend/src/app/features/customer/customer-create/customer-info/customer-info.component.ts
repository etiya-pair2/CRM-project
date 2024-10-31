import { Component } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layouts/main-layout/main-layout.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router,RouterModule } from '@angular/router'; 
import { CustomerService } from '../../../../shared/services/customer.service';
import { customerCreateInfoResponse } from '../../../../shared/models/customer/customerCreateInfoResponse';

@Component({
  selector: 'app-customerinfo',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule,RouterModule],
  templateUrl: './customer-info.component.html',
  styleUrl: './customer-info.component.scss'
})
export class CustomerInfoComponent {
  constructor(private router: Router, private customerService: CustomerService) {}
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

  onPrevious() {
    console.log("Previous button clicked");
  }

  save() : void {
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
        
        this.customerId = response.customerId;
       
        console.log('Customer information saved successfully', response);
        
        // Optionally navigate to another route or display a success message
        this.router.navigate(['/customer/contactMedium'],{ queryParams: { customerId: this.customerId } });
        console.log('2',this.customerId); // Adjust the route as needed
      },
      (error) => {
        console.error('Error saving customer information', error);
        // Optionally display an error message to the user
      }
    );
  }
}
