import { TestBed } from '@angular/core/testing';

import { HeroRestService } from './hero-rest.service';

describe('HeroRestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HeroRestService = TestBed.get(HeroRestService);
    expect(service).toBeTruthy();
  });
});
