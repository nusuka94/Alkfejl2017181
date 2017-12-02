export class Routes {
  static LOGIN: String = 'login';
  static REGISTER: String = 'register';
  static PLANNER: String = 'planner';
}

export class Server {
  private static address: String = 'localhost';
  private static port: String = '4200';
  // private static prefix: String = 'api';

  static routeTo(route: String) {
    // return `http://${Server.address}:${Server.port}/${Server.prefix}/${route}`
    return `http://${Server.address}:${Server.port}/${route}`;
  }
}
