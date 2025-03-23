import { Component, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-new-tasks',
  standalone: true,
  imports: [],
  templateUrl: './new-tasks.component.html',
  styleUrl: './new-tasks.component.css'
})
export class NewTasksComponent {

  @Output() cancelNewTask = new EventEmitter<void>();

  onCancelNewTask() {
    this.cancelNewTask.emit();
  }

}
