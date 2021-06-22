import { Component, OnInit } from '@angular/core';

import { Workflow } from 'src/app/models/workflow.model';
import { WorkflowService } from 'src/app/services/workflow.service';

@Component({
  selector: 'app-add-workflow',
  templateUrl: './add-workflow.component.html',
  styleUrls: ['./add-workflow.component.css']
})
export class AddWorkflowComponent implements OnInit {

  workflow: Workflow = {
    name: '',
    description: '',
    completed: false
  };
  submitted = false;

  constructor(private workflowService: WorkflowService) { }

  ngOnInit(): void {
  }

  saveWorkflow(): void {
    const data = {
      name: this.workflow.name,
      description: this.workflow.description
    };

    this.workflowService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newWorkflow(): void {
    this.submitted = false;
    this.workflow = {
      name: '',
      description: '',
      completed: false
    };
  }
}

