import { TestBed, inject } from '@angular/core/testing';

import { Shared\roomSelectService } from './shared\room-select.service';

describe('Shared\roomSelectService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [Shared\roomSelectService]
    });
  });

  it('should be created', inject([Shared\roomSelectService], (service: Shared\roomSelectService) => {
    expect(service).toBeTruthy();
  }));
});
