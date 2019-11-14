import { TestBed } from '@angular/core/testing';

import { HttpControlService } from './http-control.service';

describe('HttpControlService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HttpControlService = TestBed.get(HttpControlService);
    expect(service).toBeTruthy();
  });
});
