import { PipeTransform, Pipe } from '@angular/core';

@Pipe({
  name: 'shortennnnnn'
})

export class ShortenPipe implements PipeTransform {
  transform(value: any, limit: number) {
    if (value.length > 10) {
      return value.substr(0, limit) + '...';
    } else {
      return value;
    }
  }
}
