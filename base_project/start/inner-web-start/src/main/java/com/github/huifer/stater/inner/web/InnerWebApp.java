package com.github.huifer.stater.inner.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

@SpringBootApplication(exclude = {JacksonAutoConfiguration.class}, scanBasePackages = {
    "com.github.huifer"})
public class InnerWebApp {

  public static void main(String[] args) {
    SpringApplication.run(InnerWebApp.class, args);
  }

}
