import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseReserveComponent } from './course-reserve.component';

describe('CourseReserveComponent', () => {
  let component: CourseReserveComponent;
  let fixture: ComponentFixture<CourseReserveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseReserveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseReserveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
