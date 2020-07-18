package me.hyfe.simplespigot.annotations;

import java.lang.annotation.*;

@Retention(value= RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.PARAMETER})
public @interface ThreadSafe {

}