import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Delivery3Component } from './delivery3.component';

describe('Delivery3Component', () => {
  let component: Delivery3Component;
  let fixture: ComponentFixture<Delivery3Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Delivery3Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Delivery3Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
