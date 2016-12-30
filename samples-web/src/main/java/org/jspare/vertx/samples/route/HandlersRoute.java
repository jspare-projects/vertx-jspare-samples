/*
 *
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.BlockingHandler;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handler.APIHandler;

import io.vertx.ext.web.RoutingContext;

@SubRouter("/handlers")
public class HandlersRoute extends APIHandler {

	@Get("/blocking")
	@BlockingHandler
	public void BlockingHandler(RoutingContext routingContext) {

		// Do something that might take some time synchronously
		// service.doSomethingThatBlocks();

		// Now call the next handler
		routingContext.next();
	}

	@Get("/handler")
	@Handler
	public void handler() {

		success("Handler");
	}
}