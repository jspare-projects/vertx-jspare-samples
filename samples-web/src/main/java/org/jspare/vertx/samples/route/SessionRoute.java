/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 * 
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.method.Post;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handling.Handling;

import io.vertx.ext.web.Session;

@SubRouter("/session")
public class SessionRoute extends Handling {

	@Get
	@Post
	@Handler
	public void hitcount() {

		Session session = ctx.session();
				
		Integer cnt = session.get("hitcount");
		cnt = (cnt == null ? 0 : cnt) + 1;

		session.put("hitcount", cnt);

		ctx.response().putHeader("content-type", "text/html")
		.end("<html><body><h1>Hitcount: " + cnt + "</h1></body></html>");
	}
}