import { Component } from '@angular/core';
declare var xepOnline: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  userName = 'Aidas';
  public downloadPDF() {
    return xepOnline.Formatter.Format('content', {render: 'download'});
  }
}
