/*
 *
 */
package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.handling.Parameter;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.handler.APIHandler;

import io.vertx.core.eventbus.EventBus;

public class MessageEventBusRoute extends APIHandler {

	private EventBus eventBus;

	@Get("/eventbus/:name")
	@Handler
	public void hello(@Parameter("name") String name) {

		eventBus.send("messages.send", name, result -> {

			if (result.succeeded()) {

				success(result.result().body().toString());
			} else {

			}
		});
	}
}