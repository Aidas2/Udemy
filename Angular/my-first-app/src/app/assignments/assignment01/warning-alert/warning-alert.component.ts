import { Component } from '@angular/core';

@Component({
  selector: 'app-warning-alert',
  template: `
    <p>This is a warning, you are in danger! ATTENTION: this is a text from specific template (not from html)</p>
  `,
  styles: [
    `
      p {
        padding: 20px;
        background-color: mistyrose;
        border: 1px solid red;
      }
    `
  ]
})
export class WarningAlertComponent {

}
