import { Component } from '@angular/core';

import { HeaderComponent } from './header/header.component';
import { UserComponent } from "./user/user.component";
import { DUMMY_USERS } from './dummy-users';
import { TasksComponent } from './tasks/tasks.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HeaderComponent, UserComponent, TasksComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {

  users = DUMMY_USERS;
  selectedUser = this.users[0];

  onSelectedUser(id : string) {
    console.log('User selected with id: ' + id);
    this.selectedUser = DUMMY_USERS.find(user => user.id === id)!;
  }
  
}
