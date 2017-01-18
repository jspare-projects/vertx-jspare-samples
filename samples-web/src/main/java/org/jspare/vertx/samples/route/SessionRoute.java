/*
 *
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.method.Post;
import org.jspare.vertx.web.annotation.subrouter.SubRouter;
import org.jspare.vertx.web.handler.APIHandler;

import io.vertx.ext.web.Session;

@SubRouter("/session")
public class SessionRoute extends APIHandler {

	@Get
	@Post
	@Handler
	public void hitcount() {

		Session session = context.session();

		Integer cnt = session.get("hitcount");
		cnt = (cnt == null ? 0 : cnt) + 1;

		session.put("hitcount", cnt);

		context.response().putHeader("content-type", "text/html").end("<html><body><h1>Hitcount: " + cnt + "</h1></body></html>");
	}
}