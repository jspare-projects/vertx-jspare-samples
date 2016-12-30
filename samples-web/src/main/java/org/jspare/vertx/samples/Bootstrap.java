/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Application;
import org.jspare.vertx.bootstrap.ApplicationVerticle;
import org.jspare.vertx.builder.VertxBuilder;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class Bootstrap extends ApplicationVerticle {

	public static void main(String[] args) {

		Application.run(Bootstrap.class);
	}

	@Override
	protected Future<Vertx> vertx() {

		return VertxBuilder.create().scanClasspath4verticles(true).scanClasspath4eventbus(true).deployVerticle(this).build();
	}
}