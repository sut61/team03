import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Delivery1Component } from './delivery1.component';

describe('Delivery1Component', () => {
  let component: Delivery1Component;
  let fixture: ComponentFixture<Delivery1Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Delivery1Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Delivery1Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
