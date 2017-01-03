/*
 *
 */
package org.jspare.vertx.samples.verticle;

import io.vertx.core.AbstractVerticle;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartVerticle extends AbstractVerticle {

	@Override
	public void start() throws Exception {

		log.debug("StartVerticle called with success");

	}
}
