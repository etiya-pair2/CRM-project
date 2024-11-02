import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../../shared/models/customer/customerSearchRequest';
import { CustomerSearchResponse } from '../../../shared/models/customer/customerSearchResponse';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-customer-search',
  standalone: true,
  imports: [MainLayoutComponent, FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './customer-search.component.html',
  styleUrls: ['./customer-search.component.scss']
})
export class CustomerSearchComponent implements OnInit {
  searchForm: FormGroup;
  results: CustomerSearchResponse[] = [];
  isSearchEnabled = false;
  searched = false;
  page = 1;
  pageSize = 10;
  totalResults = 0;

  constructor(
    private fb: FormBuilder,
    private customerService: CustomerService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    this.searchForm = this.fb.group({
      natId: [''],
      customerId: [''],
      accNumber: [''],
      mobilePhone: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
    }, { validators: this.nameValidator });

    this.searchForm.valueChanges.subscribe(() => {
      this.isSearchEnabled = this.searchForm.valid || 
        Object.values(this.searchForm.controls).some(control => control.value);
    });
  }

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      const natIdFromParams = params['natId'];
      if (natIdFromParams) {
        this.searchForm.patchValue({ natId: natIdFromParams });
        this.isSearchEnabled = true;
        this.search();
      }
    });
  }

  search(): void {
    if (!this.isSearchEnabled) return;

    const searchRequest: CustomerSearchRequest = Object.fromEntries(
      Object.entries(this.searchForm.value).filter(([, value]) => value)
    );

    console.log('Search Request:', searchRequest);

    this.customerService.searchCustomer(searchRequest).subscribe(
      (response) => {
        this.results = response.map(customer => ({
          customerId: customer.customerId,
          firstName: customer.firstName,
          lastName: customer.lastName,
          nationalityId: customer.nationalityId,
          mobilePhone: customer.contactMediumList[0]?.mobilePhone || '',
          accNumber: customer.billingAccountList[0]?.accountNumber || '',
          contactMediumList: customer.contactMediumList,
          billingAccountList: customer.billingAccountList
        }));

        this.totalResults = this.results.length;
        this.searched = true;
      },
      (error) => {
        console.error('Search failed', error);
        this.results = [];
        this.searched = true; 
      }
    );
  }

  clear(): void {
    this.searchForm.reset();
    this.results = [];
    this.isSearchEnabled = false;
    this.page = 1;
    this.searched = false;
  }

  get paginatedResults() {
    const start = (this.page - 1) * this.pageSize;
    return this.results.slice(start, start + this.pageSize);
  }

  nextPage(): void {
    if (this.page * this.pageSize < this.totalResults) {
      this.page++;
    }
  }

  previousPage(): void {
    if (this.page > 1) {
      this.page--;
    }
  }

  get totalPages() {
    return Math.ceil(this.totalResults / this.pageSize);
  }

  private nameValidator(form: FormGroup) {
    const { firstName, lastName } = form.controls;
    if (!firstName.value && !lastName.value) return null;
    return (firstName.value && !lastName.value) || (!firstName.value && lastName.value) ? { nameRequired: true } : null;
  }

  navigateToCreateCustomer() {
    this.router.navigate(['customer/create']);
  }
}
