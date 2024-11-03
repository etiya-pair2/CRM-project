import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../../../shared/components/navbar/navbar.component";
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { customerDetailsResponse } from '../../../shared/models/customer/customerDetailsResponse';
import { CustomerService } from '../../../shared/services/customer.service';


@Component({
  selector: 'app-general-info',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent, CommonModule ],
  templateUrl: './general-info.component.html',
  styleUrl: './general-info.component.scss'
})

export class GeneralInfoComponent implements OnInit {
  customer: customerDetailsResponse | null = null;

  constructor(
    private route: ActivatedRoute,
    private http: HttpClient,
    private customerService: CustomerService
  ) {}

  ngOnInit() {
    const customerId = this.customerService.getCustomerId();
    if (customerId) {
      this.fetchCustomerDetails(customerId);
    }
    
  }

  fetchCustomerDetails(customerId: string) {
    this.customerService.getCustomerDetails(customerId).subscribe(
      (data: customerDetailsResponse) => {
        this.customer = data;
        console.log(data);
      },
      (error) => {
        console.error('Error fetching customer details:', error);
      }
    );
  }    
}
