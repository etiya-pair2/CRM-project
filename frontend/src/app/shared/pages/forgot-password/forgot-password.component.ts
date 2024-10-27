import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms'; 
import { RouterModule } from '@angular/router';// Ensure Router is imported if you're using it // Adjust the import path as necessary

@Component({
  selector: 'app-forgot-password',
  standalone: true,
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss'],
  imports: [ReactiveFormsModule,RouterModule],// Fixed typo from styleUrl to styleUrls
})
export class ForgotPasswordComponent {
  form!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
  ) {}

  ngOnInit(): void {
    this.buildForm();
  }

  private buildForm() {
    this.form = this.formBuilder.group({
      username: new FormControl('', [Validators.required]), // Changed 'email' to 'username'
    });
  }

  hasError(controlName: string) {
    return (
      !this.form.get(controlName)?.valid && this.form.get(controlName)?.touched
    );
  }
  get isFormValid() {
    return this.form.valid;
  }
  submitForm(): void {
    if (this.isFormValid) {
      // Handle form submission
      console.log('Form submitted:', this.form.value);
      // Implement your form submission logic here
    }
  }
}
