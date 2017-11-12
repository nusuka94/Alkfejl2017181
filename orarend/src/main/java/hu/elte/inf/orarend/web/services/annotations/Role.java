package hu.elte.inf.orarend.web.services.annotations;

import hu.elte.inf.orarend.persistence.models.Felhasznalo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //futásidőben reflectiönnel is elérhetőnek szeretnénk definiálni
@Target(ElementType.METHOD) //metódusra fogjuk rátenni
public @interface Role {
    Felhasznalo.Role[] value() default {Felhasznalo.Role.GUEST};
}
