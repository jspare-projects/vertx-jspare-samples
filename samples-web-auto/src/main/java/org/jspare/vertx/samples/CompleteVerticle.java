/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.vertx.experimental.AutoConfigurationVerticle;
import org.jspare.vertx.experimental.AutoConfiguration;
import org.jspare.vertx.experimental.Module;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.experimental.HttpServerModule;

import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.RoutingContext;

@AutoConfiguration(@Module(HttpServerModule.NAME))
public class CompleteVerticle extends AutoConfigurationVerticle {

  @Get("/foo")
  @Handler
  public void helloApi(RoutingContext context){
    
    context.response().setStatusCode(200).end("hello world");
  }
  
  protected HttpServerOptions options() {
    return new HttpServerOptions().setPort(8000);
  }
}