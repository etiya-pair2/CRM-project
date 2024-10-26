import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder, FormsModule } from '@angular/forms';
import { CustomerService } from '../../../shared/services/customer.service';
import { CustomerSearchRequest } from '../../../shared/models/customer/customerSearchRequest';
//import { CustomerCreateRequest } from '../../models/customerCreateRequest';
//import { CustomerCreateResponse } from '../../models/customerCreateResponse';

@Component({
  selector: 'app-customer-search',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './customer-search.component.html',
  styleUrl: './customer-search.component.scss'
})
export class CustomerSearchComponent {

}
