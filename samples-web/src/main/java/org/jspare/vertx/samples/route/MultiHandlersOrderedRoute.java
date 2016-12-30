/*
 *
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;

import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.RoutingContext;

@SubRouter("/multiroutes/ordered")
public class MultiHandlersOrderedRoute {

	@Get
	@Handler(order = 1)
	public void route1(RoutingContext routingContext) {

		HttpServerResponse response = routingContext.response();
		// enable chunked responses because we will be adding data as
		// we execute over other handlers. This is only required once and
		// only if several handlers do output.
		response.setChunked(true);

		response.write("route1\n");

		// Call the next matching route after a 5 second delay
		routingContext.vertx().setTimer(5000, tid -> routingContext.next());
	}

	@Get
	@Handler(order = 3)
	public void route2(RoutingContext routingContext) {

		HttpServerResponse response = routingContext.response();
		response.write("route2\n");

		// Call the next matching route after a 5 second delay
		routingContext.vertx().setTimer(5000, tid -> routingContext.next());
	}

	@Get
	@Handler(order = 2)
	public void route3(RoutingContext routingContext) {

		HttpServerResponse response = routingContext.response();
		response.write("route3");

		// Now end the response
		routingContext.response().end();
	}
}