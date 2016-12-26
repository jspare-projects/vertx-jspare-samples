package vertx;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.CorsHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;

public class SockJsTest {

	public static void main(String[] args) {

		Vertx vertx = Vertx.vertx();

		Router router = Router.router(vertx);
		
		SockJSHandler sockJsHandler = SockJSHandler.create(vertx);
		sockJsHandler.socketHandler(sockJsSocker -> {
			
			sockJsSocker.handler(sockJsSocker::write);
		});
		
		router.route().handler(CorsHandler.create("*").allowCredentials(false));
		router.route("/socks/*").handler(sockJsHandler);
		router.route("/webapp/*").handler(StaticHandler.create("webapp"));

		vertx.createHttpServer().requestHandler(router::accept).listen(9080);
	}
}
