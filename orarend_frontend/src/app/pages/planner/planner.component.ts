import { Component, OnInit } from '@angular/core';
import {TimetableService} from '../../services/timetable.service';
import {Observable} from 'rxjs/Observable';
import {Timetable} from '../../models/Timetable';

@Component({
  selector: 'app-planner',
  templateUrl: './planner.component.html',
  styleUrls: ['./planner.component.css']
})
export class PlannerComponent implements OnInit {

  constructor(private timetableService: TimetableService) { }

  ngOnInit() {
    this.list();
  }


  list(): Observable<Timetable[]> {
    return this.timetableService.getTimetables();
  }
}
