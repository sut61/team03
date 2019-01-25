import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { Delivery2Component } from './delivery2.component';

describe('Delivery2Component', () => {
  let component: Delivery2Component;
  let fixture: ComponentFixture<Delivery2Component>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ Delivery2Component ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(Delivery2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
