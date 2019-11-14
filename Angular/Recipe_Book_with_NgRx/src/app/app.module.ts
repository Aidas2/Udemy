import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { StoreModule } from '@ngrx/store';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { AppRoutingModule } from './app.routing.module';
import { SharedModule } from './shared/shared.module';
import { CoreModule } from './core.module';
import { shoppingListReducer } from './shopping-list/store/shopping-list.reducer';

@NgModule({
  declarations: [    // declarations must be declared only ONCE (doubled declarations not allowed)
    AppComponent,
    HeaderComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,         // imported from separate/custom app.routing.module.ts
    StoreModule.forRoot({shoppingList: shoppingListReducer}),
    // RecipesModule,            // imported from separate/custom recipes.module.ts  // removed after implementing lazy loading
    // ShoppingListModule,      // imported from separate/custom shoping-list.module.ts  // removed after implementing lazy loading
    // AuthModule,              // imported from separate/custom auth.module.ts          // removed after implementing lazy loading
    SharedModule,            // imported from separate/custom shared.module.ts
    CoreModule              // imported from separate/custom core.module.ts
  ],
  providers: [
    // LoggingService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
