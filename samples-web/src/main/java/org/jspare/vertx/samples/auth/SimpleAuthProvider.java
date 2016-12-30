/*
 *
 */
package org.jspare.vertx.samples.auth;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.AuthProvider;
import io.vertx.ext.auth.User;

public class SimpleAuthProvider implements AuthProvider {

	public static SimpleAuthProvider create() {

		return new SimpleAuthProvider();
	}

	private SimpleAuthProvider() {
	}

	@Override
	public void authenticate(JsonObject authInfo, Handler<AsyncResult<User>> resultHandler) {

		resultHandler.handle(Future.succeededFuture(new AuthUser()));
	}
}