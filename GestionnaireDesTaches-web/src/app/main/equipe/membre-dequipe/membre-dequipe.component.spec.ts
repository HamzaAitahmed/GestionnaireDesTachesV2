import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MembreDEquipeComponent } from './membre-dequipe.component';

describe('MembreDEquipeComponent', () => {
  let component: MembreDEquipeComponent;
  let fixture: ComponentFixture<MembreDEquipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [MembreDEquipeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(MembreDEquipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
