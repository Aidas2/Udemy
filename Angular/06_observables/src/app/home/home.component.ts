import { Component, OnInit, OnDestroy } from '@angular/core';

import { interval, Subscription, Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {

  private firstObsSubcription: Subscription;

  constructor() { }

  ngOnInit() {
    // this.firstObsSubcription = interval(1000).subscribe(count => {
    //   console.log(count);
    // });
    const customIntervalObservable = Observable.create(observer => {
      let count = 0;
      setInterval(() => {
        observer.next(count);

        if (count === 2) {      // completing
          observer.complete();
        }

        if (count > 3) {        // creating fake error
          observer.error(new Error('Count is greater then 3!'))
        }

        count++;
      }, 1000);
    });


    // customIntervalObservable.pipe(map((data: number) => {    //using operator
    //   return 'Round: ' + (data + 1);
    // }));


    this.firstObsSubcription = customIntervalObservable.pipe(filter(data => {
      return data > 0; // return true (and filters zero value)
    }),
      map((data: number) => {
        return 'Round: ' + (data + 1); // with filter() starts from 2, not from 1 as before
      }))
      .subscribe(data => {
        console.log(data);
      }, error => {        // subscribing/handle error
        console.log(error);
        alert(error);
      }, () => {            // subscribing/handle completing
        console.log('Completed!');
      });
  }

  ngOnDestroy() {
    this.firstObsSubcription.unsubscribe();
  }

}
