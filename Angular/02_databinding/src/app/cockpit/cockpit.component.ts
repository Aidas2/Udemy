import { Component, OnInit, EventEmitter, Output, ViewChild, ElementRef } from '@angular/core';

@Component({
  selector: 'app-cockpit',
  templateUrl: './cockpit.component.html',
  styleUrls: ['./cockpit.component.css']
})
export class CockpitComponent implements OnInit {

  // binding event from child component to parent, step#3 !!!
  @Output('srvCreatedFromChild') serverCreated = new EventEmitter<{ serverName: string, serverContent: string }>();
  @Output('bpCreatedFromChild') blueprintCreated = new EventEmitter<{ serverName: string, serverContent: string }>();

  // newServerName = '';    // don't need anymore, because of using local reference
  // newServerContent = ''; // don't need anymore, because of using local reference and @ViewCild()
  @ViewChild('referenceServerContentInput', { static: true }) referenceServerContentInput: ElementRef;

  constructor() { }

  ngOnInit() {
  }

  onAddServer(referenceNameInput: HTMLInputElement) {
    // console.log(referenceNameInput.value);
    // console.log(this.referenceServerContentInput);

    // binding event from child component to parent, step#4 (emit) !!!
    this.serverCreated.emit({
      // serverName: this.newServerName,
      // serverContent: this.newServerContent,
      serverName: referenceNameInput.value,                                  // using local reference
      serverContent: this.referenceServerContentInput.nativeElement.value    // using local reference and @ViewCild()
    });
  }

  onAddBlueprint(referenceNameInput: HTMLInputElement) {
    // binding event from child component to parent, step#4 (emit) !!!
    this.blueprintCreated.emit({
      // serverName: this.newServerName,
      // serverContent: this.newServerContent
      serverName: referenceNameInput.value,                                  // using local reference
      serverContent: this.referenceServerContentInput.nativeElement.value    // using local reference and @ViewCild()
    });
  }

}

// @ViewChild('serverContentInput') serverContentInput: ElementRef;                      // Angular 7
// @ViewChild('serverContentInput', { static: true }) serverContentInput: ElementRef;    // Angular 8
