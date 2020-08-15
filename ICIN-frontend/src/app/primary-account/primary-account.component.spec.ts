import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimaryAccountComponent } from './primary-account.component';

describe('PrimaryAccountComponent', () => {
  let component: PrimaryAccountComponent;
  let fixture: ComponentFixture<PrimaryAccountComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PrimaryAccountComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PrimaryAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
