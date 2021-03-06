// Copyright © 2011-2015, Esko Luontola <www.orfjackal.net>
// This software is released under the Apache License 2.0.
// The license text is at http://www.apache.org/licenses/LICENSE-2.0

package fi.jumi.actors.generator;

import java.lang.annotation.*;

/**
 * Causes the compiler to generate {@link fi.jumi.actors.eventizers.Eventizer eventizer} classes for the interface which
 * is annotated with this annotation.
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface GenerateEventizer {

    /**
     * Behave as if this annotation was on the parent interface instead of this interface. Used for generating
     * eventizers for interfaces which are not under your control (i.e. part of the JDK or a 3rd party library).
     */
    boolean useParentInterface() default false;

    /**
     * Write eventizer classes to another package instead of the current package.
     */
    String targetPackage() default "";
}
