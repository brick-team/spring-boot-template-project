# huifer 模板工程

- 文件说明
  - controller: 存储controller定义的maven工程
  - configuration: 项目额外配置
  - database-object: 存储数据库对象+mapper的maven工程
    - db-config: mybatis 配置层
    - db-entity: 实体对象层
    - mapper: xml+mapper层
  - cache: 缓存层
  - docs: 存储项目文档
  - domain: 领域对象父工程主要分为下面两种类型包
    - domain-convert: 存储对象转换方法的工程
    - domain-model: 存储领域对象的工程, 一般存放请求参数、返回参数、枚举、异常定义
    - domain-validator: 领域模型验证模块
  - infrastructure: 基础设施工程,即服务层
    - infrastructure-api: 存储 service 定义
    - infrastructure-impl: 存储 service 实现

  - open-api: 对外提供的接口包(目前只有 httpClient 和 openFeign 后续如果有dubbo可以再补充)
    - with-http-client: httpClient 的对外rpc接口调用
    - with-open-feign: openFeign 的对外rpc调用
  -
  - start: 项目启动工程

依赖说明

- start
  - controller
    - infrastructure-impl
      - mapper
      - cache
      - configuration
      - infrastructure-api
        - db-entity
        - domain-model

      - domain-convert
        - domain-model
        - database-object
        - db-entity

    - domain-model
  - db-config
  

