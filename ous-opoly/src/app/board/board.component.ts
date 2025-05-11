import { Component, inject } from '@angular/core';
import { BoardService } from './board.service';
import { DetailPopupComponent } from './detail-popup/detail-popup.component';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [DetailPopupComponent],
  templateUrl: './board.component.html',
  styleUrl: '../styling/styling.component.css'
})
export class BoardComponent {

  ispropSelected = false;
  selectedTileID = 0;

  private boardService = inject(BoardService);
  tiles = this.boardService.tiles;
  currency = this.boardService.currAbrev;

  onTileClick(tileID : number) {
    console.log(tileID);
    this.ispropSelected = true;
    this.selectedTileID = tileID;
  }

}
