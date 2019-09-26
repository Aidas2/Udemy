import { Component, EventEmitter, Output } from '@angular/core';
import { LoggingService } from '../logging.service';
import { AccountsService } from '../accounts.service';

@Component({
  selector: 'app-new-account',
  templateUrl: './new-account.component.html',
  styleUrls: ['./new-account.component.css'],
  providers: [/*LoggingService, AccountsService*/] // we receive instance of AccountsService from global (app.module.ts)
})
export class NewAccountComponent {
  // @Output() accountAdded = new EventEmitter<{ name: string, status: string }>(); // do not need anymore

  constructor(private loggingServices: LoggingService, private accountsService: AccountsService) {

    this.accountsService.statusUpdated.subscribe(        // cross-component comunication, step#3
      (status: string) => alert('New Status: ' + status)
    );
  }

  onCreateAccount(accountName: string, accountStatus: string) {

    // this.accountAdded.emit({    // do not need anymore
    //   name: accountName,
    //   status: accountStatus
    // });
    this.accountsService.addAccount(accountName, accountStatus);

    // console.log('A server status changed, new status: ' + accountStatus);
    // this.loggingServices.logStatusChange(accountStatus); // commented to demonstrate service injection in service


  }
}
