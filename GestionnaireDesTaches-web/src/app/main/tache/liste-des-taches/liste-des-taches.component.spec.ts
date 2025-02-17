import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListeDesTachesComponent } from './liste-des-taches.component';

describe('ListeDesTachesComponent', () => {
  let component: ListeDesTachesComponent;
  let fixture: ComponentFixture<ListeDesTachesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ListeDesTachesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListeDesTachesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
