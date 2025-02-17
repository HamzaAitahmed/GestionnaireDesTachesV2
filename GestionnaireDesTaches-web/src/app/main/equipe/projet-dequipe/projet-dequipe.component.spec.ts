import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetDEquipeComponent } from './projet-dequipe.component';

describe('ProjetDEquipeComponent', () => {
  let component: ProjetDEquipeComponent;
  let fixture: ComponentFixture<ProjetDEquipeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProjetDEquipeComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjetDEquipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
