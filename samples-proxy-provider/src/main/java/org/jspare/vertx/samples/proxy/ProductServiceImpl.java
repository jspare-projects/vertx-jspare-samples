/*
 *
 */
package org.jspare.vertx.samples.proxy;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

/**
 * Created by paulo.ferreira on 30/12/2016.
 */
public class ProductServiceImpl implements ProductService {

	@Override
	public void findProductById(int id, Handler<AsyncResult<JsonObject>> resultHandler) {

		Product product = new Product();
		product.setName("Coca");

		resultHandler.handle(Future.succeededFuture(product.toJson()));
	}
}
