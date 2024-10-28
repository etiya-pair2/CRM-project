import { Component } from '@angular/core';
import { MainLayoutComponent } from '../../../../shared/layouts/main-layout/main-layout.component';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; 

@Component({
  selector: 'app-customerinfo',
  standalone: true,
  imports: [MainLayoutComponent, CommonModule, FormsModule],
  templateUrl: './customer-info.component.html',
  styleUrl: './customer-info.component.scss'
})
export class CustomerInfoComponent {
  constructor( private router : Router) {};

  customer = {
    firstName: '',
    middleName: '',
    lastName: '',
    birthDate: '',
    gender: '',
    fatherName: '',
    motherName: '',
    nationalityId: ''
  };

  onPrevious() {
    // Önceki sayfaya gitme işlemi burada yapılacak
    console.log("Previous button clicked");
  }

  onNext() {
    // Sonraki sayfaya gitme işlemi burada yapılacak
    console.log("Next button clicked");
  }
}
