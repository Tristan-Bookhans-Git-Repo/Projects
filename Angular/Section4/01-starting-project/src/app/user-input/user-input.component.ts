import { Component, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { type investmentInfo } from '../invest-info.model';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-user-input',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './user-input.component.html',
  styleUrl: './user-input.component.css'
})
export class UserInputComponent {

  @Output() investInfo = new EventEmitter<investmentInfo>();

  initInvestment = 0;
  annInvestment = 0;
  expReturn = 0;
  duration = 0;

  onSubmit(){
    const investInfo: investmentInfo = {
      initInvestment: this.initInvestment,
      annualInvestent: this.annInvestment,
      expectedReturn: this.expReturn,
      duration: this.duration
    };
    this.investInfo.emit(investInfo);

  }

}
