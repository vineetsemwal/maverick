import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ContactusComponent } from './contactus/contactus.component';
import { AboutComponent } from './about/about.component';
import { ListProductsComponent } from './list-products/list-products.component';
import { ProductDetailsComponent } from './product-details/product-details.component';

const routes: Routes = [
  {path:"",redirectTo:"home",pathMatch:"full"}
  ,
{
  path:"home",component:HomeComponent
},
{
  path:"contact",component:ContactusComponent
},
{
path:"about", component:AboutComponent
},
{
  path:"list-products", component:ListProductsComponent
},

{
  path:"product/:productName", component:ProductDetailsComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
