import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BigProductDetailsComponent } from './big-product-details.component';

describe('BigProductDetailsComponent', () => {
  let component: BigProductDetailsComponent;
  let fixture: ComponentFixture<BigProductDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BigProductDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BigProductDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
