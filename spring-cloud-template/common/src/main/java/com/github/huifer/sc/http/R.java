package com.github.huifer.sc.http;

import java.io.Serializable;

public class R<T> implements Serializable {

  private int code;

  private String msg;

  private T data;

  public static <T> R<T> ok() {
    return generatorR(null, HttpStaticValue.SUCCESS, null);
  }

  public static <T> R<T> ok(T data) {
    return generatorR(data, HttpStaticValue.SUCCESS, null);
  }

  public static <T> R<T> ok(T data, String msg) {
    return generatorR(data, HttpStaticValue.SUCCESS, msg);
  }


  public static <T> R<T> fail() {
    return generatorR(null, HttpStaticValue.FAIL, null);
  }

  public static <T> R<T> fail(T data) {
    return generatorR(data, HttpStaticValue.FAIL, null);
  }

  public static <T> R<T> fail(T data, String msg) {
    return generatorR(data, HttpStaticValue.FAIL, msg);
  }

  private static <T> R<T> generatorR(T data, int code, String msg) {
    R<T> tr = new R<>();
    tr.setCode(code);
    tr.setMsg(msg);
    tr.setData(data);
    return tr;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}
