import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
}
)
export class HeaderComponent {

  // @Output() featureSelected = new EventEmitter<string>(); // imitating routers

  // onSelect(feature: string) {    // imitating routers
  //   this.featureSelected.emit(feature);
  // }
}
