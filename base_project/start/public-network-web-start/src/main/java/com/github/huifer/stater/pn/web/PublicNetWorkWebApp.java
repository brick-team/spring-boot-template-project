package com.github.huifer.stater.pn.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.github.huifer"})
public class PublicNetWorkWebApp {

  public static void main(String[] args) {
    SpringApplication.run(PublicNetWorkWebApp.class, args);
  }
}
