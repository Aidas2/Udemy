import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { UserService } from '../users.service';
import { CounterService } from '../inactive-users/counter.service';

@Component({
  selector: 'app-active-users',
  templateUrl: './active-users.component.html',
  styleUrls: ['./active-users.component.css']
})
export class ActiveUsersComponent implements OnInit{

  /*@Input()*/ users: string[];
  // @Output() userSetToInactive = new EventEmitter<number>();
  constructor(private userService: UserService, public counterService: CounterService) {}
  ngOnInit() {
  this.users = this.userService.activeUsers;
}


  onSetToInactive(id: number) {
    // this.userSetToInactive.emit(id);
    this.userService.setToInactive(id);
  }
}
