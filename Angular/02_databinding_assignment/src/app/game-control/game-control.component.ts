import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {

  initialNumber = 0;
  @Output() intervalLauchEvent = new EventEmitter<number>();
  interval;

  constructor() { }

  ngOnInit() {
  }

  onGameStart() {
    this.interval = setInterval(() => {
      this.intervalLauchEvent.emit(this.initialNumber++);
      // console.log(this.initialNumber);
    }, 1000);

  }

  onGamePause() {
    clearInterval(this.interval);
  }

}
