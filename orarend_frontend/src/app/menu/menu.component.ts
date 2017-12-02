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
  private common: MenuItem[] = [
    {link: '/login', title: 'Login'}
  ];

  private roleMenus = new Map<String, MenuItem[]>([
    // [Role.GUEST, [...this.common]],
    [Role.USER, [...this.common, {link: '/planner', title: 'Tervező'}]],
    [Role.ADMIN, [...this.common, {link: '/planner', title: 'Tervező'}]]
  ]);

  menus: MenuItem[];

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
    this.router.events.subscribe((event) => {
      if (event instanceof NavigationEnd) {
        this.setMenus();
      }
    });
  }

  setMenus() {
    if (this.authService.isLoggedIn) {
      this.menus = this.roleMenus.get(this.authService.user.role);
    } else {
      this.menus = this.roleMenus.get(Role.GUEST);
    }
  }
}
