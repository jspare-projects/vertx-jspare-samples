/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 * 
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.handling.Handling;

public class HelloRoute extends Handling {

	@Handler
	@Get("/hello")
	public void hello() {

		success("Hello World");
	}
}