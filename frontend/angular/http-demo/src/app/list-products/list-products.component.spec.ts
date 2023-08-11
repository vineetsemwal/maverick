import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListProductsComponent } from './list-products.component';
import { Observable, of } from 'rxjs';
import { Product } from '../product';
import { ProductService } from '../product.service';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

describe('ListProductsComponent', () => {
  let component: ListProductsComponent;
  let fixture: ComponentFixture<ListProductsComponent>;
  let debugElement:DebugElement;
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports:[],
      providers:[
        {provide:ProductService, useClass:MockProductService}
      ],
        declarations: [ ListProductsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ListProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    debugElement=fixture.debugElement;

  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('successful render',()=>{
    expect(debugElement.query(By.css("#id-1")).nativeElement.textContent.trim())
    .toBe("1");
    expect(debugElement.query(By.css("#name-1")).nativeElement.textContent.trim())
    .toBe("samsung");
    const priceContent1=debugElement.query(By.css("#price-1")).nativeElement.textContent;
    console.log("price content1",priceContent1);
    expect(priceContent1.trim()).toBe("20000");

    expect(debugElement.query(By.css("#id-2")).nativeElement.textContent.trim()).toBe("2");
    expect(debugElement.query(By.css("#name-2")).nativeElement.textContent.trim()).toBe("moto");
    const priceContent2=debugElement.query(By.css("#price-2")).nativeElement.textContent;
    console.log("price content2",priceContent2);
    expect(priceContent2.trim()).toBe("30000");


  });
});
const products:Product[]=[
  new Product(1,"samsung",20000),
  new Product(2,"moto",30000)

]
class MockProductService{
getProducts():Observable<Product[]>{
const observable:Observable<Product[]> =of(products);
return observable;
}
}
