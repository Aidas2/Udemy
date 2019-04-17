import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HEROES } from '../mock-heroes';
import { HeroService } from '../hero.service';

@Component({
  selector: 'app-heroes', // selects in app html <><>
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})

export class HeroesComponent implements OnInit {
  
  //passing to own html:
  // hero: Hero = {
  //   id: 1,
  //   name: 'Windstorm'
  // };

  //selectedHero: Hero;

  // heroes = HEROES;
  heroes: Hero[];


  //constructor() { }
  constructor(private heroService: HeroService){ }
  
  ngOnInit() {
    this.getHeroes();
  }

  // function to retrieve the heroes from the service:
  // getHeroes(): void {
  //   this.heroes = this.heroService.getHeroes();
  // }
  getHeroes(): void {
    this.heroService.getHeroes()
    .subscribe(heroes => this.heroes = heroes)
  }


  
  //method, which assigns the clicked hero from the template to the component's selectedHero
  // onSelect(hero: Hero): void {
  //   this.selectedHero = hero;
  // }
}
