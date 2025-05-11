import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { UserComponent } from './user/user.component';
import { TasksComponent } from './tasks/tasks.component';
import { BrowserModule } from '@angular/platform-browser';

@NgModule({
    declarations: [AppComponent], // For non-standalone components
    bootstrap: [AppComponent],
    imports: [BrowserModule, HeaderComponent, UserComponent, TasksComponent] // For standalone components
})
export class AppModule {}