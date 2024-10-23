import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MainLayoutsComponent } from './main-layouts.component';

describe('MainLayoutsComponent', () => {
  let component: MainLayoutsComponent;
  let fixture: ComponentFixture<MainLayoutsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [MainLayoutsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MainLayoutsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
