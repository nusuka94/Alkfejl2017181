import { Component, OnInit } from '@angular/core';
import {TimetableService} from "../../services/timetable.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-timetable',
  templateUrl: './new-timetable.component.html',
  styleUrls: ['./new-timetable.component.css']
})
export class NewTimetableComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
