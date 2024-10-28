import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../../shared/models/customer/customerSearchRequest';
import { CustomerSearchResponse } from '../../../shared/models/customer/customerSearchResponse';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

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

  page: number = 1;
  pageSize: number = 10;
  totalResults: number = 0;

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
    if (this.isSearchEnabled) {
      const searchRequest: CustomerSearchRequest = this.searchForm.value;
      this.customerService.searchCustomer(searchRequest).subscribe(
        (response) => {
          this.results = response;
          this.totalResults = response.length;
          this.searched = true; // Arama yapıldı
          // Eğer sonuç yoksa, boş array döndüğünden emin olalım
          if (this.results.length === 0) {
            this.results = []; // Eğer sonuç boşsa yine de results dizisi sıfırlanmış olur
          }
        },
        (error) => {
          console.error('Search failed', error);
          this.results = [];
          this.searched = true; // Arama yapıldı olarak işaretle
        }
      );
    }
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

  nextPage() {
    if (this.page * this.pageSize < this.totalResults) {
      this.page++;
    }
  }

  previousPage() {
    if (this.page > 1) {
      this.page--;
    }
  }

  get totalPages() {
    return Math.ceil(this.totalResults / this.pageSize);
  }
}
