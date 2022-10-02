import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppComponent } from './app.component';
import { AuthInterceptorService } from './auth-interceptor.service';
import { LoggingIntereptorService } from './logging-interceptor.service';

@NgModule({
  declarations: [AppComponent],
  imports: [BrowserModule, FormsModule, HttpClientModule],
  providers: [                                    // order of interceptors matters !!!
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptorService,
      multi: true
    },
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LoggingIntereptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
