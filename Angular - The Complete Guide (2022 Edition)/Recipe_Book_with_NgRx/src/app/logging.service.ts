import { Injectable } from '@angular/core';

// @Injectable({providedIn: 'root'}) // commented for demonstrating purposes only
export class LoggingService {
  lastLog: string;

  printLog(message: string) {
    console.log(message);
    console.log(this.lastLog);
    this.lastLog = message;
  }
}
