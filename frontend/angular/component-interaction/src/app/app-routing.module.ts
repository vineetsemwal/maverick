import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ChildTwoComponent } from './child-two/child-two.component';
import { ChildThreeComponent } from './child-three/child-three.component';
import { ChildComponent } from './child/child.component';

const routes: Routes = [
  {
    path:"child",component:ChildComponent
  },
{
  path:"child-two", component:ChildTwoComponent
},
{
  path:"child-three", component:ChildThreeComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
