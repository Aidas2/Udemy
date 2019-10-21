import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'sorttttt',
  pure: false
})
export class SortPipe implements PipeTransform {

  transform(value: any, propName: string): any {
    return value.sort((a, b) => {      // this is comparator ?!
      if (a[propName] > b[propName]) {
          return 1;
      } else {
        return -1;
      }
    });
  }

}
