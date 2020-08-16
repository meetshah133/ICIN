import { TestBed } from '@angular/core/testing';

import { BankserviceService } from './bankservice.service';

describe('BankserviceService', () => {
  let service: BankserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BankserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
