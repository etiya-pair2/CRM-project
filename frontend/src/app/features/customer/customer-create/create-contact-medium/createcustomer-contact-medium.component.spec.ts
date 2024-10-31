import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatecustomerContactMediumComponent } from './createcustomer-contact-medium.component';

describe('CreatecustomerContactMediumComponent', () => {
  let component: CreatecustomerContactMediumComponent;
  let fixture: ComponentFixture<CreatecustomerContactMediumComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CreatecustomerContactMediumComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreatecustomerContactMediumComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
