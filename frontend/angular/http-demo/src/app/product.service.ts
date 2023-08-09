import { Injectable } from '@angular/core';
import { Product } from './product';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  readonly baseUrl="http://localhost:3000";

  constructor(private http:HttpClient){}

  getProducts():Observable<Product[]>{
    const url=this.baseUrl+"/products";
    const observable:Observable<Product[]>=this.http.get<Product[]>(url);
    return observable;
  }

  addProduct(requestData:any):Observable<Product>{
    const url=this.baseUrl+"/products";
    const observable:Observable<Product>=this.http.post<Product>(url, requestData);
    return observable;
  }

}
