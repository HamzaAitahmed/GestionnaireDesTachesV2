import { TestBed } from '@angular/core/testing';

import { ProjetGplService } from './projet-gpl.service';

describe('ProjetGplService', () => {
  let service: ProjetGplService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProjetGplService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
