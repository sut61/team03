import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CoursemusicComponent } from './coursemusic.component';

describe('CoursemusicComponent', () => {
  let component: CoursemusicComponent;
  let fixture: ComponentFixture<CoursemusicComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CoursemusicComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CoursemusicComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
