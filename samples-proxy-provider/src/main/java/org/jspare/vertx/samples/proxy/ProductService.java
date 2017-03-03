/*
 *
 */
package org.jspare.vertx.samples.proxy;

import org.jspare.core.annotation.Component;
import org.jspare.vertx.annotation.RegisterProxyService;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;

/**
 * Created by paulo.ferreira on 30/12/2016.
 */
@ProxyGen
@VertxGen
@RegisterProxyService(ProductService.ADDRESS)
@Component
public interface ProductService {

	String ADDRESS = "service.product";

	@Fluent
	ProductService findProductById(int id, Handler<AsyncResult<Product>> resultHandler);
}