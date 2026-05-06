import { TestBed } from '@angular/core/testing';

import { TacheGplService } from './tache-gpl.service';

describe('TacheGplService', () => {
  let service: TacheGplService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TacheGplService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
