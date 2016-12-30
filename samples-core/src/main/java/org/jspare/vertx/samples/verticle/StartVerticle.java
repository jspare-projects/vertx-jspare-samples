/*
 *
 */
package org.jspare.vertx.samples.verticle;

import org.jspare.vertx.annotation.DeploymentOptionsBuilder;
import org.jspare.vertx.annotation.Verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Verticle
public class StartVerticle extends AbstractVerticle {

	@DeploymentOptionsBuilder
	public DeploymentOptions getDeploymentOptions() {

		log.debug("deploymentOptions called with success");

		return new DeploymentOptions();
	}

	@Override
	public void start() throws Exception {

		log.debug("StartVerticle called with success");

	}
}
