import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  serverElements = [{ type: 'server', name: 'Testserver', content: 'Just a test!' }];

  // For asignment ===============================================================================================
  oddNumberArray: number[] = [];
  evenNumberArray: number[] = [];
  // For asignment ===============================================================================================

  // binding event from child component to parent, step#2 !!!
  onServerAdded(serverData: { serverName: string, serverContent: string }) {
    this.serverElements.push({
      type: 'server',
      name: serverData.serverName,
      content: serverData.serverContent
    });
  }

  // binding event from child component to parent, step#2 !!!
  onBlueprintAdded(blueprintData: { serverName: string, serverContent: string }) {
    this.serverElements.push({
      type: 'blueprint',
      name: blueprintData.serverName,
      content: blueprintData.serverContent
    });
  }

  onChangeFirst() {
    this.serverElements[0].name = 'Changed !';
  }

  onDestroyFirst() {
    this.serverElements.splice(0, 1);
  }

  // For asignment ===============================================================================================
  // its is possible to pass property 'number' as an argument, because of outputing through @Output() and listening through ($event)
  onIntervalFiredFromChild(firedNumberFromChild: number) {
    console.log(firedNumberFromChild);
    if (firedNumberFromChild % 2 === 0) {
      this.evenNumberArray.push(firedNumberFromChild);
    } else {
      this.oddNumberArray.push(firedNumberFromChild);
    }

  }



}


