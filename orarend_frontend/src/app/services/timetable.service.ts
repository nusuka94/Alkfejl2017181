import { Injectable } from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {Timetable} from '../models/Timetable';

@Injectable()
export class TimetableService {
  constructor(private http: Http) {}

  public getTimetables(): Observable<Timetable[]> {
    return this.http.get('api/home/timetables')
      .map(this.data);
  }

  data(response: Response): Timetable[] {
    return response.json() as Timetable[] || [];
  }
}
