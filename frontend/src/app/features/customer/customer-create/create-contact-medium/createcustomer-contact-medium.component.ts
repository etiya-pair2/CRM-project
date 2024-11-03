import { MainLayoutComponent as MainLayoutComponent } from "../../../../shared/layouts/main-layout/main-layout.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router,RouterModule } from '@angular/router';
import { CustomerService } from '../../../../shared/services/customer.service';
import { customerCreateContactMedRequest } from '../../../../shared/models/customer/customerCreateContactMedRequest';
import { customerCreateContactMedResponse} from '../../../../shared/models/customer/customerCreateContactMedResponse';
import { Component } from "@angular/core";

@Component({
  selector: 'app-createcustomer-contact-medium',
  standalone: true,
  imports: [MainLayoutComponent,CommonModule,FormsModule,RouterModule],
  templateUrl: './createcustomer-contact-medium.component.html',
  styleUrl: './createcustomer-contact-medium.component.scss'
})

export class CreatecustomerContactMediumComponent {
  email:string= '';
  mobilePhone:string='';
  homePhone:string='';
  fax:string='';
  isNextEnabled: boolean = false; // Butonun aktifliği
  showError: boolean = false;
  mobilePhoneErrorMessage: string='';
  emailErrorMessage: string= '';
  customerId?: string ;
 
  constructor( private customerService: CustomerService, private router: Router, private route: ActivatedRoute) {};
 
  
  ngOnInit(): void {   
    this.route.queryParams.subscribe(params => {
      this.customerId = params['customerId']; 
    });
      }
  onInputChange() {
    this.isNextEnabled = this.email.trim().length > 0 && this.mobilePhone.trim().length > 0; // Boş değilse aktif et
  }

  
  next(): void {
    this.showError = false; 
  
    if (!this.email) {
      this.emailErrorMessage = 'E-mail cannot be empty.';
      this.showError = true;
    }
    
    if (!this.mobilePhone) {
      this.mobilePhoneErrorMessage = 'Mobile Phone cannot be empty.';
      this.showError = true;
    }
  
    if (this.showError) {
      return; 
    }
  
    const customerCreateContactMedRequest: customerCreateContactMedRequest = { 
      email: this.email, 
      mobilePhone: this.mobilePhone, 
      homePhone: this.homePhone, 
      fax: this.fax,
      customerId: this.customerId!
    }
  
    this.customerService.createCustomerContactMedium(customerCreateContactMedRequest).subscribe(
      (response: customerCreateContactMedResponse) => {
        console.log('Customer contact medium created successfully:', response);
        this.customerService.setContactMediumId(response.id);
        this.router.navigate(['/customer/generalInfo'], { queryParams: { customerId: this.customerId } });
      },
      (error: any) => {
        console.error('Error occurred while creating customer contact medium:', error);
      }
    );
  }
  
  
  
  

}
