import { TestBed, inject } from '@angular/core/testing';

import { CourseReserveService } from './course-reserve.service';

describe('CourseReserveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CourseReserveService]
    });
  });

  it('should be created', inject([CourseReserveService], (service: CourseReserveService) => {
    expect(service).toBeTruthy();
  }));
});
