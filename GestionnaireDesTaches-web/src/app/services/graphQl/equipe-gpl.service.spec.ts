import { TestBed } from '@angular/core/testing';

import { EquipeGplService } from './equipe-gpl.service';

describe('EquipeGplService', () => {
  let service: EquipeGplService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EquipeGplService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
