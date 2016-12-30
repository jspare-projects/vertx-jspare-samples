/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxRunner;
import org.jspare.vertx.builder.VertxBuilder;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class Bootstrap extends VertxRunner {

	public static void main(String[] args) {

		Runner.run(Bootstrap.class);
	}

	@Override
	protected Future<Vertx> vertx() {

		return VertxBuilder.create().scanClasspath4verticles(true).scanClasspath4eventbus(true).deployVerticle(this).build();
	}
}