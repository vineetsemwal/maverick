import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";
import { supportedProducts } from "./supportedProducts";

@Injectable({providedIn:"root"})
export class UrlGuard implements CanActivate{

    constructor(private router:Router){

    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
      const productName:any= route.paramMap.get("productName");
      console.log("inside urlguard canactivate id",productName);

     const foundProducts:string[]= supportedProducts.filter(
      product=>product==productName);
     if(foundProducts.length>0){
      return true;
     }
     //navigate user to not found component if product name is not present
       this.router.navigate(["/not-found"]);
       return false;

    }

}
