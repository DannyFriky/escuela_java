import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HeroRestComponent } from './hero-rest.component';

describe('HeroRestComponent', () => {
  let component: HeroRestComponent;
  let fixture: ComponentFixture<HeroRestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HeroRestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HeroRestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
