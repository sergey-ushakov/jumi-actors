// Copyright © 2011, Esko Luontola <www.orfjackal.net>
// This software is released under the Apache License 2.0.
// The license text is at http://www.apache.org/licenses/LICENSE-2.0

package fi.jumi.codegenerator;

import org.apache.maven.plugin.*;

/**
 * Says "Hi" to the user.
 *
 * @goal sayhi
 */
public class GreetingMojo extends AbstractMojo {

    public void execute() throws MojoExecutionException {
        getLog().info("Hello, world.");
    }
}
