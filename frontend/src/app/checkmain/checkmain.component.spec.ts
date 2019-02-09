import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckmainComponent } from './checkmain.component';

describe('CheckmainComponent', () => {
  let component: CheckmainComponent;
  let fixture: ComponentFixture<CheckmainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckmainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckmainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
