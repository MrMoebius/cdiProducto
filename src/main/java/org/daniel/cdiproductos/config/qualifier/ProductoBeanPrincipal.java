package org.daniel.cdiproductos.config.qualifier;

import jakarta.enterprise.inject.spi.Bean;
import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
// Import estatico para acceder a los elementos sin referenciar elemento del Target

@Qualifier
@Retention(RetentionPolicy.RUNTIME)         //Oblifatoria para notaciones
@Target({FIELD, METHOD, PARAMETER, TYPE})   //Oblifatoria para notaciones

// @interface --> Dice que esto es una anotacion.
public @interface ProductoBeanPrincipal {

}
