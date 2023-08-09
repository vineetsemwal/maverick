import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListProductsComponent } from './list-products/list-products.component';
import { AddProductCodeDrivenComponent } from './add-product-code-driven/add-product-code-driven.component';
import { ProductDetailsComponent } from './product-details/product-details.component';

const routes: Routes = [
{
  path:"list-products", component:ListProductsComponent
},
{
  path:"add-product", component:AddProductCodeDrivenComponent
},
{
  path:"product/:id", component:ProductDetailsComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
