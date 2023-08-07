import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddProductTemplatedrivenComponent } from './add-product-templatedriven.component';

describe('AddProductTemplatedrivenComponent', () => {
  let component: AddProductTemplatedrivenComponent;
  let fixture: ComponentFixture<AddProductTemplatedrivenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddProductTemplatedrivenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddProductTemplatedrivenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
