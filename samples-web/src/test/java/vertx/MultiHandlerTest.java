package vertx;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class MultiHandlerTest {

	public static void main(String[] args) {

		Vertx vertx = Vertx.vertx();

		Router router = Router.router(vertx);

		router.route("/some/path/").handler(routingContext -> {

			HttpServerResponse response = routingContext.response();
			// enable chunked responses because we will be adding data as
			// we execute over other handlers. This is only required once and
			// only if several handlers do output.
			response.setChunked(true);

			response.write("route1\n");

			// Call the next matching route after a 5 second delay
			routingContext.vertx().setTimer(5000, tid -> routingContext.next());
		});

		router.route("/some/path/").handler(routingContext -> {

			HttpServerResponse response = routingContext.response();
			response.write("route2\n");

			// Call the next matching route after a 5 second delay
			routingContext.vertx().setTimer(5000, tid -> routingContext.next());
		});

		router.route("/some/path/").handler(routingContext -> {

			HttpServerResponse response = routingContext.response();
			response.write("route3");

			// Now end the response
			routingContext.response().end();
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(9080);
	}

}
