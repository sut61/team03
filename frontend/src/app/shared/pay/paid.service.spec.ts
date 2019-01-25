import { TestBed, inject } from '@angular/core/testing';

import { PaidService } from './paid.service';

describe('PaidService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PaidService]
    });
  });

  it('should be created', inject([PaidService], (service: PaidService) => {
    expect(service).toBeTruthy();
  }));
});
