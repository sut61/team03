import { TestBed, inject } from '@angular/core/testing';

import { RoomReserveService } from './room-reserve.service';

describe('RoomReserveService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RoomReserveService]
    });
  });

  it('should be created', inject([RoomReserveService], (service: RoomReserveService) => {
    expect(service).toBeTruthy();
  }));
});
