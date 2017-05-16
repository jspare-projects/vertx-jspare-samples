/*
 *
 */
package org.jspare.vertx.samples;

import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.RoutingContext;
import org.jspare.vertx.autoconfiguration.AutoConfiguration;
import org.jspare.vertx.autoconfiguration.AutoConfigurationVerticle;
import org.jspare.vertx.autoconfiguration.Resource;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Post;
import org.jspare.vertx.web.module.HttpServerModule;

@AutoConfiguration(@Resource(HttpServerModule.class))
public class UploadVerticle extends AutoConfigurationVerticle {

  @Post("/upload")
  @Handler
  public void helloApi(RoutingContext context){

    StringBuilder names = new StringBuilder();
    context.fileUploads().forEach(fu -> {

      names.append(fu.fileName()).append("\n");
    });
    context.response().setStatusCode(200).end(names.toString());
  }
  
  protected HttpServerOptions options() {
    return new HttpServerOptions().setPort(8000);
  }
}