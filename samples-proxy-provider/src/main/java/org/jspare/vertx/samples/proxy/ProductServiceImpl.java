/*
 *
 */
package org.jspare.vertx.samples.proxy;

import java.time.ZonedDateTime;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;

/**
 * Created by paulo.ferreira on 30/12/2016.
 */
public class ProductServiceImpl implements ProductService {

	@Override
	public ProductService findProductById(int id, Handler<AsyncResult<Product>> resultHandler) {

		Product product = new Product();
		product.setName("Coca");
		product.setCreation(ZonedDateTime.now());

		resultHandler.handle(Future.succeededFuture(product));
		return this;
	}
}
