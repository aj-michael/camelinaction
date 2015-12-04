package camelinaction;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class WebsiteCopier {

  public static void main(String[] args) throws Exception {
    CamelContext context = new DefaultCamelContext();

    context.addRoutes(new RouteBuilder() {
      public void configure() {
        // Polls https://google.com and writes to file:data/outbox ever 1 second
        from("timer:justatimer?period=1000").to("https://google.com").to("file:data/outbox");
      }
    });

    context.start();
    Thread.sleep(10000);
    context.stop();
  }

}
