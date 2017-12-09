import {User} from './User';

export class Timetable {
  id: number;
  user: User;

  constructor(user?: User) {
    this.user = user;
  }
}
