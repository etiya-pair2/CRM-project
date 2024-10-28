import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms'; 
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-forgot-password',
  standalone: true,
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss'],
  imports: [ReactiveFormsModule, RouterModule, CommonModule],
})
export class ForgotPasswordComponent {
  form!: FormGroup;
  submitted = false; // Butona tıklama durumu için bayrak

  constructor(private formBuilder: FormBuilder, private router: Router) {}

  ngOnInit(): void {
    this.buildForm();
  }
  private buildForm() {
    this.form = this.formBuilder.group({
      username: new FormControl('', [
        Validators.required,
        Validators.email // E-posta formatı kontrolü
      ]),
    });
  }
  hasError(controlName: string) {
    return !this.form.get(controlName)?.valid && this.form.get(controlName)?.touched;
  }

  get isFormValid() {
    return this.form.valid;
  }

  submitForm(): void {
    if (this.isFormValid) {
      this.submitted = true; // Form geçerli ise butona tıklama durumunu ayarla
      console.log('Form submitted:', this.form.value);
    }
  }
}
