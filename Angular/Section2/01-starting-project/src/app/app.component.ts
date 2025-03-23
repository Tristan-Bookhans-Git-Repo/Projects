import { Component } from '@angular/core';

import { HeaderComponent } from './header/header.component';
import { UserComponent } from "./user/user.component";
import { DUMMY_USERS } from './dummy-users';
import { TasksComponent } from './tasks/tasks.component';
import { NewTasksComponent } from "./tasks/new-tasks/new-tasks.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HeaderComponent, UserComponent, TasksComponent, NewTasksComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css',
})
export class AppComponent {

  users = DUMMY_USERS;
  selectedUserId? : string;
  isAddTask? : boolean;

  get selectedUser() {

    return this.users.find((user) => user.id === this.selectedUserId);

  }

  onSelectedUser(id : string) {

    this.selectedUserId = id;
    
  }

  onAddTask(taskAdded : boolean) {
    this.isAddTask = taskAdded;
  }
  
}
