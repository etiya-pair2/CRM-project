import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerSearchComponent } from './customer-search.component';

import { MainLayoutComponent } from '../../../shared/layouts/main-layout/main-layout.component';

describe('CustomerSearchComponent', () => {
  let component: CustomerSearchComponent;
  let fixture: ComponentFixture<CustomerSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerSearchComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
