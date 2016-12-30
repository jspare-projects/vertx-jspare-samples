/*
 *
 */
package org.jspare.vertx.samples.proxy;

import org.jspare.core.annotation.Component;
import org.jspare.vertx.annotation.ProxyHandler;

import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;

/**
 * Created by paulo.ferreira on 30/12/2016.
 */
@ProxyGen
@VertxGen
@ProxyHandler(ProductService.ADDRESS)
@Component
public interface ProductService {

	String ADDRESS = "service.product";

	void findProductById(int id, Handler<AsyncResult<JsonObject>> resultHandler);

}
