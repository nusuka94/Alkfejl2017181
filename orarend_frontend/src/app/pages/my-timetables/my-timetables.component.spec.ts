import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyTimetablesComponent } from './my-timetables.component';

describe('MyTimetablesComponent', () => {
  let component: MyTimetablesComponent;
  let fixture: ComponentFixture<MyTimetablesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyTimetablesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyTimetablesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
