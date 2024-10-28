import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerinfoComponent } from './customerinfo.component';

describe('CustomerinfoComponent', () => {
  let component: CustomerinfoComponent;
  let fixture: ComponentFixture<CustomerinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CustomerinfoComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
