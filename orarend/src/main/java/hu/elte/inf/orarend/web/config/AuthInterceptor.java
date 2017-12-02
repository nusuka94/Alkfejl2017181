package hu.elte.inf.orarend.web.config;

import hu.elte.inf.orarend.persistence.models.User;

import hu.elte.inf.orarend.web.services.UserService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean isAuthorizedEndpoint = isAuthorizedEndpoint((HandlerMethod) handler);
        //List<User.Role> routeRoles = getRoles((HandlerMethod) handler);
        User user = userService.getUser();

        if(!isAuthorizedEndpoint) {
            return true;
        }

        if(isAuthorizedEndpoint && userService.isLoggedIn()) {
            return true;
        }

        response.setStatus(401);
        response.sendRedirect("/login?unauthorized=true"); //ezt meg lehet változatatni, nem szükséges a get paraméter...
        return false;
    }

//    private List<User.Role> getRoles(HandlerMethod handler) {
//        Role role = handler.getMethodAnnotation(Role.class);
//        return role == null ? Collections.emptyList() : Arrays.asList(role.value());
//    }

    private boolean isAuthorizedEndpoint(HandlerMethod handler) {
        return handler.getMethodAnnotation(Authorized.class) != null || handler.getBeanType().getAnnotation(Authorized.class) != null;
    }
}
