import {
  Component,
  OnInit,
  Input,
  ViewEncapsulation,
  OnChanges,
  SimpleChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked,
  OnDestroy,
  ViewChild,
  ElementRef,
  ContentChild
} from '@angular/core';

@Component({
  selector: 'app-server-element',
  templateUrl: './server-element.component.html',
  styleUrls: ['./server-element.component.css'],
  encapsulation: ViewEncapsulation.Emulated            // not overwriting (default behavior)
  // encapsulation: ViewEncapsulation.None            // overwriting (aplies global css, not only css of this component)
})
export class ServerElementComponent implements OnInit,
  OnChanges,
  DoCheck,
  AfterContentInit,
  AfterContentChecked,
  AfterViewInit,
  AfterViewChecked,
  OnDestroy {

  // custom propery binding !!! alias !!! (binding property from child component to parent)
  @Input('srvElementFromChild') element: { type: string, name: string, content: string };
  @Input() nameFromChild: string; // for demonstration of ngOnChanges

  @ViewChild('referenceHeading', { static: true }) header: ElementRef; // If you DON'T use the selected element in ngOnInit, set static: false instead.
  @ContentChild('referenceContentParagraph', { static: true }) paragraph: ElementRef;

  constructor() {
    // console.log('constuctor called!');
  }

  ngOnChanges(changes: SimpleChanges) {
    // console.log('ngOnChanges called!');
    // console.log(changes);
  }

  ngOnInit() {
    // console.log('ngOnInit called!');
    // console.log('Text Content:' + this.header.nativeElement.textContent);
    // console.log('Text Content of paragraph:' + this.paragraph.nativeElement.textContent);
  }

  ngDoCheck() {
    // console.log('ngDoCheck called!');
  }

  ngAfterContentInit() {
    // console.log('ngAfterContentInit called (only once)!');
    // console.log('Text Content of paragraph:' + this.paragraph.nativeElement.textContent);
  }

  ngAfterContentChecked(): void {
    // console.log('ngAfterContentChecked called!');
  }

  ngAfterViewInit() {
    // console.log('ngAfterViewInit called!');
    // console.log('Text Content:' + this.header.nativeElement.textContent);
  }

  ngAfterViewChecked(): void {
    // console.log('ngAfterViewChecked called!');
  }

  ngOnDestroy() {
    // console.log('ngOnDestroy called!');
  }

}
