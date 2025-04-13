import { Component, Input, Output, EventEmitter } from '@angular/core';
import { TaskComponent } from './task/task.component';
import { NewTasksComponent } from "./new-tasks/new-tasks.component";
import { type newTask } from './task/task.module';

import { TasksService } from './tasks.service';

@Component({
  selector: 'app-tasks',
  standalone: true,
  imports: [TaskComponent, NewTasksComponent],
  templateUrl: './tasks.component.html',
  styleUrl: './tasks.component.css'
})
export class TasksComponent {

  @Input({required : true}) name!: string;
  @Input({required : true}) userId!: string;
  // @Output() addNewTask = new EventEmitter();
  isAddingTask = false;

  constructor(private tasksService: TasksService) {}

  get selectedUserTasks() {
    return this.tasksService.getUserTasks(this.userId);
  }

  onCompleteTask(id: string) {
    
  }

  onStartAddTask() {
    // this.addNewTask.emit(true);
    this.isAddingTask = true;
  }

  onCloseNewTask() {
    this.isAddingTask = false;
  }

}
