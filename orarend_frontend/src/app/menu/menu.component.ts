import { Component, OnInit } from '@angular/core';
import {Role} from '../models/User';
import {AuthService} from '../services/auth.service';
import {NavigationEnd, Router} from '@angular/router';

interface MenuItem {
  link: String;
  title: String;
}

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {

  }

  logout() {
    this.authService.logout().subscribe(
      res => this.router.navigate(['/login']),
      err => err
    );
  }
}
