/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Application;
import org.jspare.vertx.bootstrap.ApplicationVerticle;

public class Bootstrap extends ApplicationVerticle {

	public static void main(String[] args) {

		Application.run(Bootstrap.class);
	}

	@Override
	public void start() {

		vertx.eventBus().send("hello", "World!!");
	}
}