import { Component } from '@angular/core';
import { BoardComponent } from './board/board.component';
import { StylingComponent } from './styling/styling.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [BoardComponent, StylingComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'ous-opoly';
}
