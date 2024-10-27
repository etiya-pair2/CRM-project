import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../../shared/models/customer/customerSearchRequest';
import { CustomerSearchResponse } from '../../../shared/models/customer/customerSearchResponse';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-customer-search',
  standalone: true,
  imports: [MainLayoutComponent, FormsModule, ReactiveFormsModule],
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.scss']
})
export class CustomerSearchComponent implements OnInit {
  searchForm: FormGroup;
  results: CustomerSearchResponse[] = [];
  isSearchEnabled = false;

  constructor(private fb: FormBuilder, private customerService: CustomerService) {
    this.searchForm = this.fb.group({
      natId: [''],
      customerId: [''],
      accNumber: [''],
      mobilePhone: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
    });

    this.searchForm.valueChanges.subscribe(() => {
      this.isSearchEnabled = this.searchForm.valid;
    });
  }

  ngOnInit(): void {}

  search(): void {
    if (this.searchForm.valid) {
      const searchRequest: CustomerSearchRequest = this.searchForm.value;
      this.customerService.searchCustomer(searchRequest).subscribe(
        (response) => {
          this.results = response;
        },
        (error) => {
          console.error('Search failed', error);
        }
      );
    }
  }

  clear(): void {
    this.searchForm.reset();
    this.results = [];
    this.isSearchEnabled = false;
  }
}
