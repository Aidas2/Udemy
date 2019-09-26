import { Component, OnInit } from '@angular/core';
import { AccountsService } from './accounts.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [/*AccountsService*/] // we receive instance of AccountsService from global (app.module.ts)
})
export class AppComponent implements OnInit {

  accounts: { name: string, status: string }[] = [];

  constructor(private accountsService: AccountsService) { }

  ngOnInit() {
    this.accounts = this.accountsService.accounts;
  }
  // do not need anymore (moved/implemented in accounts.services.ts)
  // onAccountAdded(newAccount: { name: string, status: string }) {
  //   this.accounts.push(newAccount);
  // }

  // onStatusChanged(updateInfo: { id: number, newStatus: string }) {
  //   this.accounts[updateInfo.id].status = updateInfo.newStatus;
  // }
}
