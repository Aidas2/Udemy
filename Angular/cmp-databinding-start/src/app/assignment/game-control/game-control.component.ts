import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-game-control',
  templateUrl: './game-control.component.html',
  styleUrls: ['./game-control.component.css']
})
export class GameControlComponent implements OnInit {

  @Output() intervalFiredFromChildOutput = new EventEmitter<number>();
  interval;
  lastNumber = 0;

  constructor() { }

  ngOnInit() {
  }

  onStartGame() {
    this.interval = setInterval(() => {
      this.intervalFiredFromChildOutput.emit(this.lastNumber++);
      // console.log(this.lastNumber);
    }, 2000);
  }

  onPauseGame() {
    clearInterval(this.interval);

  }

}
