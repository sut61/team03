import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckcustomerComponent } from './checkcustomer.component';

describe('CheckcustomerComponent', () => {
  let component: CheckcustomerComponent;
  let fixture: ComponentFixture<CheckcustomerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckcustomerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckcustomerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
