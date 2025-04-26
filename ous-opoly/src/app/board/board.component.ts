import { Component, inject } from '@angular/core';
import { BoardService } from './board.service';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [],
  templateUrl: './board.component.html',
  styleUrl: '../styling/styling.component.css'
})
export class BoardComponent {

  private boardService = inject(BoardService);
  tiles = this.boardService.tiles;

}
