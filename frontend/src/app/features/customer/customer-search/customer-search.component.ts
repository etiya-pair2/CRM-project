import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CustomerService } from '../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../../shared/models/customer/customerSearchRequest';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';


@Component({
  selector: 'app-customer-search',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule,MainLayoutComponent],
  templateUrl: './customer-search.component.html',
  styleUrl: './customer-search.component.scss'
})
export class CustomerSearchComponent implements OnInit {
  form!: FormGroup;

  constructor(private formBuilder: FormBuilder, private customerService: CustomerService) {}

  ngOnInit(): void {
    this.buildForm();
  }

  buildForm() {
    this.form = this.formBuilder.group({
      customerName: new FormControl('', Validators.required),
      customerEmail: new FormControl('', [Validators.required, Validators.email]),
    });
  }

  submitForm() {
    this.form.markAllAsTouched();
    if (!this.form.valid) {
      return;
    }
    const searchRequest: CustomerSearchRequest = this.form.value;
    this.customerService.searchCustomer(searchRequest).subscribe({
      next: (response) => {
        console.log('Arama başarılı:', response);
      },
    });
  }

  hasError(controlName: string) {
    return !this.form.get(controlName)?.valid && this.form.get(controlName)?.touched;
  }

  get isFormValid() {
    return this.form.valid;
  }
}