import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChequebookRequestComponent } from './chequebook-request.component';

describe('ChequebookRequestComponent', () => {
  let component: ChequebookRequestComponent;
  let fixture: ComponentFixture<ChequebookRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChequebookRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChequebookRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
