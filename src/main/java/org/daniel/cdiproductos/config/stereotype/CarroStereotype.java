package org.daniel.cdiproductos.config.stereotype;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import jakarta.enterprise.inject.Stereotype;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;

@Named
@SessionScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target(TYPE)
public @interface CarroStereotype { }


    /*Qué es @Stereotype
    Una anotación personalizada para agrupar varias anotaciones relacionadas con la configuración de beans CDI.

    Permite definir una sola anotación "meta" que incluye otras, simplificando y estandarizando la declaración de beans en tu aplicación.

    -- Usos principales
    Reducir duplicidad: Si tienes muchos beans que comparten las mismas anotaciones (scope, @Named, @Alternative, etc.), puedes crear un stereotype y aplicar solo esa anotación.

    Centralizar cambios: Si el scope o la configuración cambia, modificas el stereotype y todos los beans que lo usan se actualizan automáticamente.

    Dar significado de negocio: Por ejemplo, @Service, @Repository, @Model, mejorando legibilidad.

    -- Particularidades
    Se crea con @Stereotype, se combina con otras anotaciones como @Named, scope (@RequestScoped, @SessionScoped), @Transactional, @Alternative, etc.

    Solo se puede aplicar sobre tipos (clases), no sobre campos ni métodos.

    Se heredan todas las anotaciones incluidas en el stereotype.

    Se pueden tener varios stereotypes en una clase (aunque no suele ser necesario).

    -- Restricciones
    No puede incluir @Qualifier. Los qualifiers son para seleccionar implementaciones, no para agrupar configuración.

    No incluye campos ni métodos, sólo clases.

    No puede ser usado para definir qué bean se inyecta si existe ambigüedad, para eso se usa @Qualifier.

    Todas las anotaciones agrupadas solo se aplican donde se use el stereotype.

    La serialización, si usas un scope pasivante, sigue siendo tu responsabilidad.

    -- ERRORES
    "Managed bean declaring a passivating scope must be java.io.Serializable"

    1. Bean implementa Serializable pero alguno de sus atributos NO
    2. Atributos transitorios o no serializables (que no necesitas serializar)
    3. Errores de compilación, duplicidad de clases, o rutas incorrectas
    4. Clase interna no estática en el modelo
    5. Depuración adicional
    -->>todos los atributos y clases anidadas también deben ser serializables.

    */