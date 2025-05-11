import { NgModule } from "@angular/core";
import { CardComponent } from "./card/card.component";

@NgModule({
    declarations: [CardComponent],
    exports: [CardComponent], // Exporting the CardComponent so it can be used in other modules
})
export class SharedModule {}