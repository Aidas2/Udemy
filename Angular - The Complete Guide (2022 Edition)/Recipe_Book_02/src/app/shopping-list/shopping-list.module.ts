import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { ShoppingListComponent } from './shopping-list.component';
import { ShoppingEditComponent } from './shopping-edit/shopping-edit.component';
import { FormsModule } from '@angular/forms';
import { SharedModule } from '../shared/shared.module';
import { LoggingService } from '../logging.service';

@NgModule({
  declarations: [
    ShoppingListComponent,
    ShoppingEditComponent
  ],
  imports: [
    FormsModule,
    // version_02 All code in this one common file (as shopping-list.routing.ts is very small)
    RouterModule.forChild([
      // { path: 'shopping-list', component: ShoppingListComponent } // removed for lazy loading
      { path: '', component: ShoppingListComponent }
    ]),
    SharedModule
  ],
  // providers: [LoggingService]  // service provided in lazy loaded module, better avoid
})
export class ShoppingListModule {

}
