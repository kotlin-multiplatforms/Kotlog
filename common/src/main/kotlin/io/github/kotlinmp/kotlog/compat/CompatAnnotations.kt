package io.github.kotlinmp.kotlog.compat

/**
 * This annotation is for platform compatible name.
 *
 * @property name The platform compatible name
 */
@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
expect annotation class Name(val name: String)

/**
 * This annotation is for platform compatible static things.
 */
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
expect annotation class Static()

/**
 * This annotation is for platform compatible field.
 */
@Target(AnnotationTarget.FIELD)
expect annotation class Field()

/**
 * This annotation is for platform compatible overloaded function or constructor.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.CONSTRUCTOR)
expect annotation class Overloads()
