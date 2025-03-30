import { Component, Output, EventEmitter } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { type newTask } from '../task/task.module';

@Component({
  selector: 'app-new-tasks',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './new-tasks.component.html',
  styleUrl: './new-tasks.component.css'
})
export class NewTasksComponent {

  @Output() cancelNewTask = new EventEmitter<void>();
  @Output() addNewTask = new EventEmitter<newTask>();
  enteredTitle = '';
  enteredSummary = '';
  enteredDueDate = '';

  onCancelNewTask() {
    this.cancelNewTask.emit();
  }

  onSubmit() {
    this.addNewTask.emit({
      title: this.enteredTitle,
      summary: this.enteredSummary,
      dueDate: this.enteredDueDate
    })
  }
}
