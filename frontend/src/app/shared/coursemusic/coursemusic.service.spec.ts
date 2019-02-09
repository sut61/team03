import { TestBed } from '@angular/core/testing';

import { CoursemusicService } from './coursemusic.service';

describe('CoursemusicService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CoursemusicService = TestBed.get(CoursemusicService);
    expect(service).toBeTruthy();
  });
});
