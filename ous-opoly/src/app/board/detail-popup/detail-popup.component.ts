import { Component, Input, inject, computed} from '@angular/core';
import { BoardService } from '../board.service';

@Component({
  selector: 'app-detail-popup',
  standalone: true,
  imports: [],
  templateUrl: './detail-popup.component.html',
  styleUrl: './detail-popup.component.css'
})
export class DetailPopupComponent {

  @Input({required : true}) tileID!: number;

  private boardService = inject(BoardService);

  // selectedTile = computed(() => {
  //   return this.boardService.tiles.find(tile => tile.id === this.tileID);
  // });

  get name() {
      let tile = this.boardService.tiles.find(tile => tile.id === this.tileID);
      return tile ? tile.name : '';
  }

  get price() {
    let tile = this.boardService.tiles.find(tile => tile.id === this.tileID);
    return tile ? tile.price : '';
}

}
