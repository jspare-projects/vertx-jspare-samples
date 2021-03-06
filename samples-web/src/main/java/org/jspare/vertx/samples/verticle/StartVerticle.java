/*
 *
 */
package org.jspare.vertx.samples.verticle;

import org.jspare.vertx.web.builder.HttpServerBuilder;
import org.jspare.vertx.web.builder.RouterBuilder;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CookieHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StartVerticle extends AbstractVerticle {

	@Override
	public void start() throws Exception {

		Router router = RouterBuilder.create(vertx)
				.scanClasspath(true)
				.addHandler(CookieHandler.create())
				.addHandler(SessionHandler.create(LocalSessionStore.create(vertx)))
				.route(r -> r.path("/webapp/*").handler(StaticHandler.create("webapp"))).build();

		HttpServer httpServer = HttpServerBuilder.create(vertx).router(router).build();
		httpServer.listen(8000, result -> {

			log.debug("HttpServer listening at port {}", result.result().actualPort());
		});
	}
}