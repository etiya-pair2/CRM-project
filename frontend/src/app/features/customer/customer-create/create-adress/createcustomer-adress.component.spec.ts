import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatecustomerAdressComponent } from './createcustomer-adress.component';

describe('CreatecustomerAdressComponent', () => {
  let component: CreatecustomerAdressComponent;
  let fixture: ComponentFixture<CreatecustomerAdressComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatecustomerAdressComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatecustomerAdressComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
