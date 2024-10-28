import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CustomerService } from '../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../../shared/models/customer/customerSearchRequest';
import { CustomerSearchResponse } from '../../../shared/models/customer/customerSearchResponse';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

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

  constructor(private fb: FormBuilder, private customerService: CustomerService ,private router: Router) {
    this.searchForm = this.fb.group({
      natId: [''],
      customerId: [''],
      accNumber: [''],
      mobilePhone: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
    },{ validators: this.nameValidator });

    this.searchForm.valueChanges.subscribe(() => {
      // En az bir alanın dolu olup olmadığını kontrol et
      this.isSearchEnabled = this.searchForm.valid || 
      Object.values(this.searchForm.controls).some(control => control.value);
    });
    
  }
  navigateToCreateCustomer() {
    this.router.navigate(['customer/create']);
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

  private nameValidator(form: FormGroup) {
    const firstName = form.get('firstName')?.value;
    const lastName = form.get('lastName')?.value;
  
    // Eğer her ikisi de boşsa geçerli
    if (!firstName && !lastName) {
      return null; // Geçerli
    }
  
    // Eğer biri doluysa diğeri de dolu olmalı
    if ((firstName && !lastName) || (!firstName && lastName)) {
      return { nameRequired: true }; // Geçersiz
    }
  
    return null; // Her ikisi de dolu ise geçerli
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
