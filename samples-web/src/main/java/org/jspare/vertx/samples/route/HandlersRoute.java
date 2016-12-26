/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 * 
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.BlockingHandler;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handling.Handling;

import io.vertx.ext.web.RoutingContext;

@SubRouter("/handlers")
public class HandlersRoute extends Handling {

	@Get("/handler")
	@Handler
	public void handler() {

		success("Handler");
	}

	@Get("/blocking")
	@BlockingHandler
	public void BlockingHandler(RoutingContext routingContext) {

		// Do something that might take some time synchronously
		// service.doSomethingThatBlocks();

		// Now call the next handler
		routingContext.next();
	}
}