#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.stater.inner.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class}, scanBasePackages = {
    "${package}"})
public class InnerWebApp {

  public static void main(String[] args) {
    SpringApplication.run(InnerWebApp.class, args);
  }

}
