import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MiControlComponent } from './mi-control.component';

describe('MiControlComponent', () => {
  let component: MiControlComponent;
  let fixture: ComponentFixture<MiControlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MiControlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MiControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
