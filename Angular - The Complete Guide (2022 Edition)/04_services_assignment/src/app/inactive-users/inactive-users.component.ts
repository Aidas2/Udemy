import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { CounterService } from './counter.service';
import { UserService } from '../users.service';

@Component({
  selector: 'app-inactive-users',
  templateUrl: './inactive-users.component.html',
  styleUrls: ['./inactive-users.component.css']
})
export class InactiveUsersComponent implements OnInit {
  /*@Input()*/ users: string[];
  // @Output() userSetToActive = new EventEmitter<number>();

  constructor(private userService: UserService, public counterService: CounterService) {}

  ngOnInit() {
    this.users = this.userService.inactiveUsers;
  }


  onSetToActive(id: number) {
    // this.userSetToActive.emit(id);
    this.userService.setToActive(id);

  }
}
