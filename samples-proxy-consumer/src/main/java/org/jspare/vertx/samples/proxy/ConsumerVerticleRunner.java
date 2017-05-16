/*
 *
 */
package org.jspare.vertx.samples.proxy;

import org.jspare.core.bootstrap.Runner;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.serviceproxy.ProxyHelper;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConsumerVerticleRunner extends VertxClusteredRunner {

	public static void main(String[] args) {

		Runner.run(ConsumerVerticleRunner.class);
	}

	@Override
	public void start() throws Exception {

		ProxyHelper.createProxy(ProductService.class, vertx, ProductService.ADDRESS).findProductById(1, res -> {

			log.debug(res.result().toString());
		});

	}

	@Override
	protected ClusterManager clusterManager() {
		
		return new HazelcastClusterManager();
	}
}