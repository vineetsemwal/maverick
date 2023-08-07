import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PropertyBindingComponent } from './property-binding/property-binding.component';
import { EventBindingComponent } from './event-binding/event-binding.component';
import { TwowayBindingComponent } from './twoway-binding/twoway-binding.component';
import { FormsModule } from '@angular/forms';
import { TemplateVariablesComponent } from './template-variables/template-variables.component';
import { StructuralDirectiveComponent } from './structural-directive/structural-directive.component';
import { AttributeDirectiveComponent } from './attribute-directive/attribute-directive.component';
import { PipesDemoComponent } from './pipes-demo/pipes-demo.component';
import { LengthPipe } from './length.pipe';
import { ProductDetailsComponent } from './product-details/product-details.component';
import { BigProductDetailsComponent } from './big-product-details/big-product-details.component';
import { ProductService } from './product.service';

@NgModule({
  declarations: [
    AppComponent,
    PropertyBindingComponent,
    EventBindingComponent,
    TwowayBindingComponent,
    TemplateVariablesComponent,
    StructuralDirectiveComponent,
    AttributeDirectiveComponent,
    PipesDemoComponent,
    LengthPipe,
    ProductDetailsComponent,
    BigProductDetailsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
