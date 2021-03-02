package com.github.huifer.stater.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.github.huifer"})
public class TaskApp {

  public static void main(String[] args) {
    SpringApplication.run(TaskApp.class, args);
  }
}
