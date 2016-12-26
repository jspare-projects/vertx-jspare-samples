package org.jspare.vertx.samples.route;

import org.jspare.vertx.web.annotation.handler.SockJsHandler;

import io.vertx.core.buffer.Buffer;
import io.vertx.ext.web.handler.sockjs.SockJSSocket;

public class SockJsRoute {

	@SockJsHandler("/socks/*")
	public void helloSocks(SockJSSocket event, Buffer buffer) {

		event.write(Buffer.buffer("Hello socks: " + buffer.toString()));
	}
}