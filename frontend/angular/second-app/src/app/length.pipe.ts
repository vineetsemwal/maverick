import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'length'
})
export class LengthPipe implements PipeTransform {

  transform(arg:any): number {
    let str=""+arg;
    return str.length;
  }

}
