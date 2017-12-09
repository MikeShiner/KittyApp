import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MonthViewControlComponent } from './month-view-control.component';

describe('MonthViewControlComponent', () => {
  let component: MonthViewControlComponent;
  let fixture: ComponentFixture<MonthViewControlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MonthViewControlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MonthViewControlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
