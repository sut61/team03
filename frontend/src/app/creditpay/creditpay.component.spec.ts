import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CreditpayComponent } from './creditpay.component';

describe('CreditpayComponent', () => {
  let component: CreditpayComponent;
  let fixture: ComponentFixture<CreditpayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreditpayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreditpayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
