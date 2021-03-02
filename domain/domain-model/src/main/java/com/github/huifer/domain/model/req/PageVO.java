package com.github.huifer.domain.model.req;

/**
 * 分页类
 *
 * @author zst
 */
public class PageVO {

  public static final int PAGE_SIZE = 20;

  public static final int PAGET_FRIST = 1;

  private Integer pageSize;

  private Integer pageNo;

  public PageVO() {
    this(null, null);
  }

  public PageVO(Integer pageSize, Integer pageNo) {
    this.initPage(pageSize, pageNo);
  }


  private void initPage(Integer pageSize, Integer pageNo) {
    if (pageSize != null && pageSize > 0) {
      this.pageSize = pageSize;
    } else {
      this.pageSize = PAGE_SIZE;
    }
    if (pageNo != null && pageNo > 0) {
      this.pageNo = pageNo;
    } else {
      this.pageNo = PAGET_FRIST;
    }
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageNo() {
    return pageNo;
  }

  public void setPageNo(Integer pageNo) {
    this.pageNo = pageNo;
  }

  @Override
  public String toString() {
    return "PageVO{" + "pageSize=" + pageSize + ", pageNo=" + pageNo + '}';
  }
}
