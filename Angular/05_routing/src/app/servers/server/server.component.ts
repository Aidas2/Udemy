import { Component, OnInit } from '@angular/core';

import { ServersService } from '../servers.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-server',
  templateUrl: './server.component.html',
  styleUrls: ['./server.component.css']
})
export class ServerComponent implements OnInit {
  server: { id: number, name: string, status: string };
  // paramsSubscription: Subscription;

  constructor(private serversService: ServersService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    const id = +this.route.snapshot.params['id'];      // plus parses string id to number id !!!
    this.server = this.serversService.getServer(id);
    this.route.params
      .subscribe(
        (params: Params) => {
          this.server = this.serversService.getServer(+params['id']);
        }
      );

    // doesn't works becouse thre is no name and status in url:
    // this.server = {
    //   id: this.route.snapshot.params['id'],            // retrieving parameters from url (attention: do not updates !)
    //   name: this.route.snapshot.params['name'],
    //   status: this.route.snapshot['status']
    // };
    // this.paramsSubscription = this.route.params        // observable !!! executs only if params in url changes (performs update !)
    //   .subscribe(
    //     (params: Params) => {
    //       this.server.id = params['id'];
    //       this.server.name = params['name'];
    //       this.server.status = params['status'];
    //     }
    //   );

  }

  onEdit() {
    // this.router.navigate(['/servers', this.server.id, 'edit']);  // absolute path
    // this.router.navigate(['edit'], { relativeTo: this.route });  // absolute path (appends 'edit' to currently loaded road)
    this.router.navigate(['edit'], { relativeTo: this.route, queryParamsHandling: 'preserve' });  // absolute path && preserving query params

  }
}
