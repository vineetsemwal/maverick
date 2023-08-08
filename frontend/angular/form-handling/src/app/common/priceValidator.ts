import { AbstractControl, ValidationErrors, Validator, ValidatorFn } from "@angular/forms";

export function forbiddenPriceValidator(min: number, max: number):ValidatorFn {
  return (control: AbstractControl) => {
      console.log("inside forbiddenPriceValidator , min="+min+" "+max);
      const value = control.value;
      const forbidden = value < min || value > max;
      return forbidden ? { forbiddenPrice: { value: value + ` not between${min}  and ${max}` } } : null;
  }
}

/*
export class ForbiddenPriceValidatorDirective implements Validator{
  validate(control: AbstractControl): ValidationErrors | null {
      console.log("inside ForbiddenAgeValidatorDirective" );
      const value = control.value;
      const forbidden = value < 0 || value >1000;
      return forbidden ? { forbiddenPrice: { value: value + " not between 0 and 1000" } } : null;
  }


}*/
