import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddProductTemplatedrivenComponent } from './add-product-templatedriven/add-product-templatedriven.component';
import { AddProductCodeDrivenComponent } from './add-product-code-driven/add-product-code-driven.component';

@NgModule({
  declarations: [
    AppComponent,
    AddProductTemplatedrivenComponent,
    AddProductCodeDrivenComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
