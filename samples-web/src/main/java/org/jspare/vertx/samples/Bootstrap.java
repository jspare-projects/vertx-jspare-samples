/*
 *
 */
package org.jspare.vertx.samples;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import org.jspare.core.Application;
import org.jspare.vertx.bootstrap.VerticleInitializer;
import org.jspare.vertx.bootstrap.VertxRunner;
import org.jspare.vertx.builder.EventBusBuilder;
import org.jspare.vertx.builder.VertxBuilder;
import org.jspare.vertx.samples.verticle.StartVerticle;

public class Bootstrap extends VertxRunner {

	public static void main(String[] args) {
		Application.run(Bootstrap.class);
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