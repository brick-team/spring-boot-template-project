#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.stater.pn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"${package}"})
public class PublicNetWorkWebApp {

  public static void main(String[] args) {
    SpringApplication.run(PublicNetWorkWebApp.class, args);
  }
}
