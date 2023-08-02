import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TwowayBindingComponent } from './twoway-binding.component';

describe('TwowayBindingComponent', () => {
  let component: TwowayBindingComponent;
  let fixture: ComponentFixture<TwowayBindingComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TwowayBindingComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TwowayBindingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
