package com.github.huifer.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.Version;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体对象基类
 */
public abstract class BaseEntity implements Serializable {

  private static final long serialVersionUID = -5934947167242117929L;
  /**
   * 版本
   */
  @Version
  protected Integer version;

  /**
   * 删除标志(1删除)
   */
  @TableField("DELETED")
  protected Integer deleted;

  /**
   * 创建用户
   */
  @TableField("CREATE_USER")
  protected Integer createUser;

  /**
   * 创建时间
   */
  @TableField("CREATE_TIME")
  protected Date createTime;

  /**
   * 更新用户
   */
  @TableField("UPDATE_USER")
  protected Integer updateUser;

  /**
   * 更新时间
   */
  @TableField("UPDATE_TIME")
  protected Date updateTime;

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public Integer getDeleted() {
    return deleted;
  }

  public void setDeleted(Integer deleted) {
    this.deleted = deleted;
  }

  public Integer getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Integer createUser) {
    this.createUser = createUser;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Integer getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Integer updateUser) {
    this.updateUser = updateUser;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }
}
