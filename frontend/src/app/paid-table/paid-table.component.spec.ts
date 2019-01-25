import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaidTableComponent } from './paid-table.component';

describe('PaidTableComponent', () => {
  let component: PaidTableComponent;
  let fixture: ComponentFixture<PaidTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaidTableComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaidTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
