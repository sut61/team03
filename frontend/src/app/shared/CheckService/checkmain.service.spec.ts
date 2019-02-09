import { TestBed, inject } from '@angular/core/testing';

import { CheckmainService } from './checkmain.service';

describe('CheckmainService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CheckmainService]
    });
  });

  it('should be created', inject([CheckmainService], (service: CheckmainService) => {
    expect(service).toBeTruthy();
  }));
});
