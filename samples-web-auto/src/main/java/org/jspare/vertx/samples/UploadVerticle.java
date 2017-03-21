/*
 *
 */
package org.jspare.vertx.samples;

import io.vertx.core.http.HttpServerOptions;
import io.vertx.ext.web.RoutingContext;
import org.jspare.vertx.experimental.AutoConfiguration;
import org.jspare.vertx.experimental.AutoConfigurationVerticle;
import org.jspare.vertx.experimental.Module;
import org.jspare.vertx.web.annotation.handler.Handler;
import org.jspare.vertx.web.annotation.method.Get;
import org.jspare.vertx.web.annotation.method.Post;
import org.jspare.vertx.web.experimental.HttpServerModule;

@AutoConfiguration(@Module(HttpServerModule.NAME))
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