import { TestBed } from '@angular/core/testing';

import { UtilisateurGplService } from './utilisateur-gpl.service';

describe('UtilisateurGplService', () => {
  let service: UtilisateurGplService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UtilisateurGplService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
