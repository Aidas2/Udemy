import { Directive, HostListener, HostBinding, ElementRef } from '@angular/core';

@Directive({
  selector: '[appDropdown]'
})
export class DropdownDirective {
  @HostBinding('class.open') isOpen = false;    // binding css class

  @HostListener('click') toggleOpenLocally() {        // listening to event and doing
    this.isOpen = !this.isOpen;    // toggling !!! :)
  }

  // @HostListener('document:click', ['$event']) toggleOpenGlobally(event: Event) {
  //   this.isOpen = this.elRef.nativeElement.contains(event.target) ? !this.isOpen : false;
  // }

  constructor(private elRef: ElementRef) { }

}
