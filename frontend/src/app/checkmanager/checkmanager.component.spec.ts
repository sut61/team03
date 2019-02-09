import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckmanagerComponent } from './checkmanager.component';

describe('CheckmanagerComponent', () => {
  let component: CheckmanagerComponent;
  let fixture: ComponentFixture<CheckmanagerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CheckmanagerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CheckmanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
