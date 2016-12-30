/*
 *
 */
package org.jspare.vertx.samples.proxy;

import org.jspare.core.bootstrap.Application;
import org.jspare.vertx.bootstrap.ApplicationVerticle;
import org.jspare.vertx.builder.VertxBuilder;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

public class ProviderVerticle extends ApplicationVerticle {

	public static void main(String[] args) {

		Application.run(ProviderVerticle.class);
	}

	@Override
	public void start() throws Exception {
	}

	@Override
	protected Future<Vertx> vertx() {

		VertxOptions options = new VertxOptions();
		options.setClustered(true);
		options.setClusterManager(new HazelcastClusterManager());

		return VertxBuilder.create().options(options).deployVerticle(this).scanClasspath4proxyServices(true).build();
	}
}