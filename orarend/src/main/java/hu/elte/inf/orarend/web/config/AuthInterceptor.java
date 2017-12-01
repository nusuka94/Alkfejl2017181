package hu.elte.inf.orarend.web.config;

import hu.elte.inf.orarend.persistence.models.Felhasznalo;

import hu.elte.inf.orarend.web.services.FelhasznaloService;
import hu.elte.inf.orarend.web.services.annotations.Authorized;
import hu.elte.inf.orarend.web.services.annotations.Role;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AuthInterceptor extends HandlerInterceptorAdapter{
    @Autowired
    private FelhasznaloService felhasznaloService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        boolean onlyAuthorized = OnlyAuthorized((HandlerMethod) handler);
        //List<Felhasznalo.Role> routeRoles = getRoles((HandlerMethod) handler);
        Felhasznalo felhasznalo = felhasznaloService.getFelhasznalo();

        if(!onlyAuthorized) {
            return true;
        }

        if(onlyAuthorized && felhasznaloService.isLoggedIn()) {
            return true;
        }

        response.setStatus(401);
        return false;
    }

    private List<Felhasznalo.Role> getRoles(HandlerMethod handler) {
        Role role = handler.getMethodAnnotation(Role.class);
        return role == null ? Collections.emptyList() : Arrays.asList(role.value());
    }

    private boolean OnlyAuthorized(HandlerMethod handler) {
        ArrayList<Annotation> annots = new ArrayList<Annotation>(Arrays.asList(handler.getBeanType().getAnnotations()));
        for(Annotation a : annots) {
            if(a.annotationType() == Authorized.class) return true;
        }
        return false;
    }
}
