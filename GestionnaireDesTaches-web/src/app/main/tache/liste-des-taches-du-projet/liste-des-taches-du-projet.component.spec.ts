import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDesTachesDuProjetComponent } from './liste-des-taches-du-projet.component';

describe('ListeDesTachesDuProjetComponent', () => {
  let component: ListeDesTachesDuProjetComponent;
  let fixture: ComponentFixture<ListeDesTachesDuProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeDesTachesDuProjetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeDesTachesDuProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
