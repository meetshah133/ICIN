/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { ChequeBookRequestService } from './chequeBookRequest.service';

describe('Service: ChequeBookRequest', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ChequeBookRequestService]
    });
  });

  it('should ...', inject([ChequeBookRequestService], (service: ChequeBookRequestService) => {
    expect(service).toBeTruthy();
  }));
});
