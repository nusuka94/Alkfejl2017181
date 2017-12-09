import { Injectable } from '@angular/core';
import {User} from '../models/User';
import {Http, Response} from '@angular/http';
import {Routes, Server} from '../utils/ServerRoutes';
import 'rxjs/add/operator/map';
import {Observable} from 'rxjs/Observable';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {tap} from 'rxjs/operators';

@Injectable()
export class AuthService {
  _user: User;
  isLoggedIn = false;
  redirectUrl: string;

  public loggedIn$ = new BehaviorSubject<boolean>(this.isLoggedIn);

  constructor(private http: Http) {

  }

  public login(user: User): Observable<User> {
    return this.http.post('api/account/login', user)
      .map((response: Response) => response.json() as User || null)
      .pipe(
        tap((userx: User) => this.setLoggedIn(userx))
      );

  }

  public logout(): Observable<any> {
    return this.http.post('api/account/logout', {})
      .map((response: Response) => this.setLoggedIn(null));
  }

  public register(user: User) {
    return this.http.post('api/account/register', user).map((response: Response) => response.json());

  }

  public setLoggedIn(user?: User) {
    this._user = user;
    this.isLoggedIn = !!user;
    this.loggedIn$.next(this.isLoggedIn);
  }

  get currentUser(): User {
    return this._user;
  }

  get currentUserId(): number {
    return this.currentUser.id;
  }

  get isAuthenticated(): boolean {
    return !!this.currentUser;
  }

}
