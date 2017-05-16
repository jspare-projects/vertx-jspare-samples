/*
 *
 */
package org.jspare.vertx.samples;

import org.jspare.vertx.autoconfiguration.AutoConfiguration;
import org.jspare.vertx.autoconfiguration.AutoConfigurationVerticle;
import org.jspare.vertx.autoconfiguration.Resource;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.module.HttpServerModule;

import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.RoutingContext;

@AutoConfiguration(@Resource(HttpServerModule.class))
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