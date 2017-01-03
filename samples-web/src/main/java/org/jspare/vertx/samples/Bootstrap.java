/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxRunner;
import org.jspare.vertx.builder.EventBusBuilder;
import org.jspare.vertx.builder.VertxBuilder;
import org.jspare.vertx.samples.verticle.StartVerticle;
import org.jspare.vertx.utils.VerticleInitializer;

import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class Bootstrap extends VertxRunner {

	public static void main(String[] args) {

		Runner.run(Bootstrap.class);
	}

	@Override
	protected Future<Vertx> vertx() {

		return VertxBuilder.create().build().compose(vertx -> {

			EventBusBuilder.create(vertx).scanClasspath(true).build();

			vertx.deployVerticle(this);
			vertx.deployVerticle(VerticleInitializer.initialize(StartVerticle.class));
			
		}, Future.succeededFuture());
	}
}