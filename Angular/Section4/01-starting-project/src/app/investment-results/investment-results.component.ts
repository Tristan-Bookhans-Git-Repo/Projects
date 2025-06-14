import { Component, Input } from '@angular/core';
import { CurrencyPipe } from '@angular/common';

import type { investmentInfo } from '../invest-info.model';

@Component({
  selector: 'app-investment-results',
  standalone: true,
  imports: [CurrencyPipe],
  templateUrl: './investment-results.component.html',
  styleUrl: './investment-results.component.css'
})
export class InvestmentResultsComponent {

  @Input({required : true}) investmentInfo! : investmentInfo;
  
  investmentData?: {
    year: number,
    interest: number,
    valueEndOfYear: number,
    annualInvestment: number,
    totalInterest: number,
    totalAmountInvested: number
  }[] = [];

  private calculateInvestmentResults() {
    const annualData = [];
    let investmentValue = +this.investmentInfo.initInvestment;
  
    for (let i = 0; i < +this.investmentInfo.duration; i++) {
      const year = i + 1;
      const interestEarnedInYear = investmentValue * (+this.investmentInfo.expectedReturn / 100);
      investmentValue += interestEarnedInYear + +this.investmentInfo.annualInvestent;
      const totalInterest =
        investmentValue - +this.investmentInfo.annualInvestent * year - +this.investmentInfo.initInvestment;
      annualData.push({
        year: year,
        interest: interestEarnedInYear,
        valueEndOfYear: investmentValue,
        annualInvestment: +this.investmentInfo.annualInvestent,
        totalInterest: totalInterest,
        totalAmountInvested: +this.investmentInfo.initInvestment + (+this.investmentInfo.annualInvestent * year),
      });
    }
  
    return annualData;
  }

  get investmentResults() {
    
    try {
      this.investmentData =  this.calculateInvestmentResults();
      console.log(this.investmentData);
      if (this.investmentData.length < 1){
        return 0;
      }
      return 1;
    }catch {
      return 0;
    }

  }
  

}
function sizeof(investmentData: { year: number; interest: number; valueEndOfYear: number; annualInvestment: number; totalInterest: number; totalAmountInvested: number; }[]) {
  throw new Error('Function not implemented.');
}

