import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CashpayComponent } from './cashpay.component';

describe('CashpayComponent', () => {
  let component: CashpayComponent;
  let fixture: ComponentFixture<CashpayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CashpayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CashpayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
