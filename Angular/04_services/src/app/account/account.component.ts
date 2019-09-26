import { Component, EventEmitter, Input, Output } from '@angular/core';
import { LoggingService } from '../logging.service';
import { AccountsService } from '../accounts.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css'],
  providers: [/*LoggingService, AccountsService*/] // we receive instance of AccountsService from global (app.module.ts)
})
export class AccountComponent {
  @Input() account: { name: string, status: string };
  @Input() id: number;
  // @Output() statusChanged = new EventEmitter<{ id: number, newStatus: string }>(); //do not need anymore

  constructor(private loggingServices: LoggingService, private accountsService: AccountsService) { } // correct way

  onSetTo(status: string) {
    // this.statusChanged.emit({ id: this.id, newStatus: status });  //do not need anymore
    // this.accountsService.updateStatus(this.id, status);
    this.accountsService.updateStatus(this.id, status);

    // console.log('A server status changed, new status: ' + status);
    // this.loggingServices.logStatusChange(status); // commented to demonstrate service injection in service

    this.accountsService.statusUpdated.emit(status); // cross-component comunication, step#2

  }
}
