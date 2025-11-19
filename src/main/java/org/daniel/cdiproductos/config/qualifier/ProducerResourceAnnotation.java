package org.daniel.cdiproductos.config.qualifier;

import jakarta.enterprise.inject.Stereotype;
import jakarta.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({FIELD, METHOD, PARAMETER, TYPE, CONSTRUCTOR})
public @interface ProducerResourceAnnotation { }
