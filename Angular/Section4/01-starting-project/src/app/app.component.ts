import { Component } from '@angular/core';
import { HeaderComponent } from "./header/header.component";
import { UserInputComponent } from './user-input/user-input.component';
import { type investmentInfo } from './invest-info.model';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  imports: [HeaderComponent, UserInputComponent],
})
export class AppComponent {


  calcReturn(investmentInfo: investmentInfo) {
    console.log(JSON.stringify(investmentInfo));
  }

}
