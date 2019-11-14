import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PushesPageComponent } from './pushes-page.component';

describe('PushesPageComponent', () => {
  let component: PushesPageComponent;
  let fixture: ComponentFixture<PushesPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PushesPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PushesPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
