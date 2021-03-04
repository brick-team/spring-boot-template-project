# huifer 模板工程
## 设计说明
- [设计说明](/docs/设计说明.md)

## 使用说明
### mvn 使用说明
- 执行下面命令可以快速创建一个项目
```shell
mvn archetype:generate  \
    -DgroupId=com.github.huifer.demo.web \
    -DartifactId=demo-web \
    -Dversion=1.0.0-SNAPSHOT \
    -Dpackage=com.github.huifer \
    -DarchetypeArtifactId=template-project-archetype \
    -DarchetypeGroupId=com.github.huifer \
    -DarchetypeVersion=1.2
```


### 源码使用说明
1. 获取项目
```shell
git clone git@github.com:huifer/spring-boot-template-project.git
```
2. 编译项目
```shell
cd archetype
mvn clean install 
```
3. 使用 archetype 工程
```shell
mvn archetype:generate -DarchetypeCatelog=local
```
输入上述命令后会输出下面内容
```shell
Choose archetype:
1: internal -> org.apache.maven.archetypes:maven-archetype-archetype (An archetype which contains a sample archetype.)
2: internal -> org.apache.maven.archetypes:maven-archetype-j2ee-simple (An archetype which contains a simplifed sample J2EE application.)
3: internal -> org.apache.maven.archetypes:maven-archetype-plugin (An archetype which contains a sample Maven plugin.)
4: internal -> org.apache.maven.archetypes:maven-archetype-plugin-site (An archetype which contains a sample Maven plugin site.
      This archetype can be layered upon an existing Maven plugin project.)
5: internal -> org.apache.maven.archetypes:maven-archetype-portlet (An archetype which contains a sample JSR-268 Portlet.)
6: internal -> org.apache.maven.archetypes:maven-archetype-profiles ()
7: internal -> org.apache.maven.archetypes:maven-archetype-quickstart (An archetype which contains a sample Maven project.)
8: internal -> org.apache.maven.archetypes:maven-archetype-site (An archetype which contains a sample Maven site which demonstrates
      some of the supported document types like APT, XDoc, and FML and demonstrates how
      to i18n your site. This archetype can be layered upon an existing Maven project.)
9: internal -> org.apache.maven.archetypes:maven-archetype-site-simple (An archetype which contains a sample Maven site.)
10: internal -> org.apache.maven.archetypes:maven-archetype-webapp (An archetype which contains a sample Maven Webapp project.)
11: local -> com.github.huifer:template-project-archetype (Template engineering of huifer.)
12: local -> com.github.huifer:web-template-archetype (web-template)
13: local -> com.shands.template:shands-template-archetype (shands-template)
```
在上述的内容中需要选择 com.github.huifer:template-project-archetype ，记住前面的数字，然后输入11,具体操作流程信息如下：

```shell
Choose a number or apply filter (format: [groupId:]artifactId, case sensitive contains): 7: 11
Choose com.github.huifer:template-project-archetype version:
1: 0.0.1
2: 1.1
Choose a number: 2: 2
Define value for property 'groupId': com.github.huifer
Define value for property 'artifactId': mod-project
Define value for property 'version' 1.0-SNAPSHOT: : 1.0.0-SHAPSHOT
Define value for property 'package' com.github.huifer: :
Confirm properties configuration:
groupId: com.github.huifer
artifactId: mod-project
version: 1.0.0-SHAPSHOT
package: com.github.huifer
```





## 分包说明
- 文件说明
  - cache: 缓存相关工程
    - cache-api: 缓存操作API
    - cache-api-impl: 缓存操作API实现类
    - cache-configuration: 缓存配置
  - controller: 控制层，主要编写restapi
    - controller-common: 公共controller
    - controller-inner: 内部服务使用的controller
    - controller-puglic-network: 外部服务使用的controller
      
  - database-object: 数据库层
    - db-config: 数据库配置
    - db-entity: 数据库实体
    - mapper: 数据库mapper层
  - domain: 领域层
    - domain-convert: 领域转换层
    - domain-model: 领域模型层
    - domain-validator: 领域验证层
  - infrastructure: 基础服务
    - infrastructure-api: 基础服务接口定义
    - infrastructure-impl: 基础服务接口实现
  - open-api: 对外API
    - with-dubbo-client: dubbo client
    - with-http-client: http client 支持OKhttp和httpClient
    - with-open-feign: openFeign client
  - project-configuration: 项目配置
  - start: 启动类
    - dubbo-start: dubbo 应用启动类
    - inner-web-start: 内部应用启动类
    - public-network-web-start: 外部应用启动类
    - task-start: 定时任务启动类