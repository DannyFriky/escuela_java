import { TestBed } from '@angular/core/testing';

import { ClienterestService } from './clienterest.service';

describe('ClienterestService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ClienterestService = TestBed.get(ClienterestService);
    expect(service).toBeTruthy();
  });
});
