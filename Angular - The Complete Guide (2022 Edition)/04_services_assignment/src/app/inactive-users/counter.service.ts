export class CounterService {

  activeToInactiveCounter = 0;
  inactiveToActiveCounter = 0;

  incrementActiveToInactive() {
    this.activeToInactiveCounter++;
    console.log('to Active: ' + this.activeToInactiveCounter);
  }

  incrementInactiveToActive() {
    this.inactiveToActiveCounter++;
    console.log('to Inactive: ' + this.inactiveToActiveCounter);
  }

}
