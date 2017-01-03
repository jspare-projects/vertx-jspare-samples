/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxRunner;
import org.jspare.vertx.samples.verticle.StartVerticle;
import org.jspare.vertx.utils.VerticleInitializer;

public class Bootstrap extends VertxRunner {

	public static void main(String[] args) {

		Runner.run(Bootstrap.class);
	}

	@Override
	public void start() {

		vertx.deployVerticle(VerticleInitializer.initialize(StartVerticle.class), ar -> {
			if(ar.succeeded()){
				
				vertx.eventBus().send("hello", "World!!");
			}
		});
	}
}