/*
 *
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.handler.APIHandler;

public class HelloRoute extends APIHandler {

	@Handler
	@Get("/hello")
	public void hello() {

		success("Hello World");
	}
}