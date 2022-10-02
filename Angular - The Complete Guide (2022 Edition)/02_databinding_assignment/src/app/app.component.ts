import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BindIt';

  launchedNumber;
  evenNumberArray: number[] = [];
  oddNumberArray: number[] = [];

  onEventLaunching(launchedNumber: number) {
    console.log(launchedNumber);
    this.launchedNumber = launchedNumber;
    if (launchedNumber % 2 === 0) {
      this.evenNumberArray.push(launchedNumber);
    } else {
      this.oddNumberArray.push(launchedNumber);
    }
  }


}
