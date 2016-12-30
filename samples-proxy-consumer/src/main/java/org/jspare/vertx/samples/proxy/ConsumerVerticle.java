/*
 *
 */
package org.jspare.vertx.samples.proxy;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxRunner;
import org.jspare.vertx.builder.VertxBuilder;

import io.vertx.core.Future;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.serviceproxy.ProxyHelper;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerVerticle extends VertxRunner {

	public static void main(String[] args) {

		Runner.run(ConsumerVerticle.class);
	}

	@Override
	public void start() throws Exception {

		ProxyHelper.createProxy(ProductService.class, vertx, ProductService.ADDRESS).findProductById(1, res -> {

			log.debug(res.result().encode());
		});

	}

	@Override
	protected Future<Vertx> vertx() {

		VertxOptions options = new VertxOptions();
		options.setClustered(true);
		options.setClusterManager(new HazelcastClusterManager());

		return VertxBuilder.create().options(options).deployVerticle(this).build();
	}

}