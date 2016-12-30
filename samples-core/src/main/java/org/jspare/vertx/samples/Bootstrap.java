/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxRunner;

public class Bootstrap extends VertxRunner {

	public static void main(String[] args) {

		Runner.run(Bootstrap.class);
	}

	@Override
	public void start() {

		vertx.eventBus().send("hello", "World!!");
	}
}