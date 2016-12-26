/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 * 
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.auth.Auth;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handling.Handling;

@Auth
@SubRouter("/api")
public class AdminRoute extends Handling {

	@Auth("deny")
	@Get("/deny")
	@Handler
	public void deny() {

		success(ctx.user().principal().toString());
	}

	@Get("/user")
	@Handler
	public void user() {

		success(ctx.user().principal().toString());
	}
}