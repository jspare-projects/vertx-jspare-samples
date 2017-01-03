/*
 *
 */
package org.jspare.vertx.samples.proxy;

import org.jspare.core.bootstrap.Runner;
import org.jspare.vertx.bootstrap.VertxClusteredRunner;
import org.jspare.vertx.builder.ProxyServiceBuilder;

import io.vertx.core.spi.cluster.ClusterManager;
import io.vertx.spi.cluster.hazelcast.HazelcastClusterManager;

public class ProviderVerticleRunner extends VertxClusteredRunner{

	public static void main(String[] args) {

		Runner.run(ProviderVerticleRunner.class);
	}

	@Override
	public void start() throws Exception {
		
		ProxyServiceBuilder.create(vertx).scanClasspath(true).build();
	}

	@Override
	protected ClusterManager clusterManager() {
		
		return new HazelcastClusterManager();
	}
}