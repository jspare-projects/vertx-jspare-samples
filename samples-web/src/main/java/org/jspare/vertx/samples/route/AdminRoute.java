/*
 *
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.auth.Auth;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handler.APIHandler;

@Auth
@SubRouter("/api")
public class AdminRoute extends APIHandler {

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