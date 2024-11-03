import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from '../../../shared/components/navbar/navbar.component';
import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';
import { CustomerService } from '../../../shared/services/customer.service';
import { contactMediumInfoResponse } from '../../../../app/shared/models/customer/contactMediumInfoResponse';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-contact-medium',
  standalone: true,
  imports: [NavbarComponent, MainLayoutComponent],
  templateUrl: './contact-medium.component.html',
  styleUrl: './contact-medium.component.scss'
})
export class ContactMediumComponent implements OnInit {
  contact: contactMediumInfoResponse | null = null;

  constructor(
    private route: ActivatedRoute,
    private customerService: CustomerService) {}

  ngOnInit() {
    const contactMediumId = this.customerService.getContactMediumId(); // Statik olarak ayarlanan id'yi alıyoruz
    if (contactMediumId) {
      this.fetchContactDetails(contactMediumId);
    }
  }

  fetchContactDetails(contactMediumId: string) {
    this.customerService.getContactDetails(contactMediumId).subscribe(
      (response: contactMediumInfoResponse) => {
        this.contact = response;
        console.log(response);
      },
      (error) => {
        console.error('Error fetching contact medium details:', error);
      }
    );
  }

  onEdit(): void {
    // Handle edit logic here
  }
}
