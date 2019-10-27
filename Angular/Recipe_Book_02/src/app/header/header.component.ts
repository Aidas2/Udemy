import { Component, EventEmitter, Output } from '@angular/core';
import { DataStorageService } from '../shared/data-storage.service';

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

  constructor(private dataStorageService: DataStorageService) {}

  onSaveData() {
    this.dataStorageService.storeRecipes();
  }

  onFetchData() {
    this.dataStorageService.fetchRecipes().subscribe();
  }
}
