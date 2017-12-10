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
      .map((response: Response) => response.json());
  }

  public newTimetable(timetable: Timetable): Observable<Timetable> {
    return this.http.post('/api/home/newtimetable', timetable)
      .map((response: Response) => response.json());
  }

  public getUserTimetables(id: number): Observable<Timetable[]> {
    return this.http.get('api/home/usertimetables?id=' + id)
      .map((response: Response) => response.json());
  }

  public deleteTimetable(id: number) {
    return this.http.delete('/api/home/timetables/' + id);
  }

  public read(id: number): Observable<Timetable> {
    return this.http.get('/api/home/timetables/' + id)
      .map((response: Response) => response.json());
  }

  public addCourse(tid: number, cid: number) {
    return this.http.post('/api/home/timetables/' + tid, cid)
      .map((response: Response) => response.json());
  }

  // public addCourse(timetableId: number, courseId: number) {
  //
  // }
}
