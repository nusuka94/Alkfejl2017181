import {Subject} from './Subject';
import {Room} from './Room';

export class Course {
  id: number;
  subject: Subject;
  room: Room;
  courseCode: number;
  instructor: string;
  day: string;
  startTime: string;
  endTime: string;
  subjectType: string;

}
