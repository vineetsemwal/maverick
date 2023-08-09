import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from "@angular/router";
import { IFormHolder } from "./formHolder";

@Injectable({
    providedIn:"root"
})
export class FormGuard implements CanDeactivate<IFormHolder>{

    canDeactivate(component: IFormHolder, currentRoute: ActivatedRouteSnapshot, currentState: RouterStateSnapshot, nextState?: RouterStateSnapshot): boolean  {
      console.log("inside formguard, component",component);

      const formGroup=component.getFormGroup();
        const isDirty:boolean=formGroup.dirty;
        console.log("is form dirty",isDirty);
        if(!isDirty){
           return true;
       }

       return confirm("Do you want to leave?");
    }

}
