/**
 * Copyright 2016 Senior Sistemas.
 *
 * Software sob Medida
 *
 */
package org.jspare.vertx.samples.auth;

import java.util.Set;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.auth.AbstractUser;
import io.vertx.ext.auth.AuthProvider;
import lombok.Getter;

public class AuthUser extends AbstractUser {

	@Getter
	private AuthProvider authProvider;

	@Getter
	private Set<String> roles;

	@Override
	public JsonObject principal() {

		return new JsonObject().put("name", "Paulo Ferreira");
	}

	@Override
	public void setAuthProvider(AuthProvider authProvider) {

		this.authProvider = authProvider;
	}

	@Override
	protected void doIsPermitted(String authority, Handler<AsyncResult<Boolean>> handler) {

		handler.handle(Future.succeededFuture(!authority.equals("deny")));
	}
}
