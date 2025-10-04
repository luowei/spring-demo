# Spring MVC Demo 项目

## 项目简介

这是一个基于 Spring MVC 4.0 框架的 Web 应用演示项目，展示了如何使用纯 Java 配置（零 XML 配置）的方式搭建 Spring MVC 应用。项目整合了 FreeMarker 模板引擎和 Groovy 动态语言，提供了一个轻量级的 Web 应用开发示例。

## 技术栈

- **Spring Framework**: 4.0.0.RELEASE
  - Spring MVC - Web 层框架
  - Spring Context Support - 上下文支持
- **模板引擎**: FreeMarker 2.3.19
- **动态语言**: Groovy 2.2.1
- **Web 容器**: Servlet 3.0.1
- **日志框架**: Log4j 1.2.14
- **构建工具**: Maven
- **运行服务器**: Tomcat 7

## 项目结构

```
spring-demo/
├── pom.xml                                    # Maven 项目配置文件
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/rootls/
│   │   │       ├── config/                    # 配置类目录
│   │   │       │   ├── Initializer.java       # Web 应用初始化器
│   │   │       │   ├── AppConfig.java         # 应用配置类
│   │   │       │   └── DispatcherConfig.java  # DispatcherServlet 配置
│   │   │       └── controller/                # 控制器目录
│   │   │           └── DefaultController.java # 默认控制器（Java）
│   │   ├── groovy/
│   │   │   └── com/rootls/controller/
│   │   │       └── HomeController.groovy      # Home 控制器（Groovy）
│   │   ├── resources/
│   │   │   └── log4j.properties               # Log4j 日志配置
│   │   └── webapp/
│   │       └── WEB-INF/
│   │           └── views/                     # FreeMarker 模板目录
│   │               ├── index.ftl              # 首页模板
│   │               └── home/
│   │                   └── index.ftl          # Home 页面模板
└── README.md                                  # 项目说明文档
```

## 主要功能

### 1. **纯 Java 配置（零 XML）**
- 使用 `WebApplicationInitializer` 接口实现应用初始化
- 通过 `@Configuration` 注解实现配置类
- 完全摆脱传统的 web.xml 和 Spring XML 配置文件

### 2. **双控制器实现**
- **DefaultController (Java)**：处理根路径 `/` 请求，返回 index 页面
- **HomeController (Groovy)**：处理 `/home` 路径请求，返回 home/index 页面
- 展示了 Java 和 Groovy 混合开发的能力

### 3. **FreeMarker 模板引擎集成**
- 配置了 FreeMarker 视图解析器
- 模板文件路径：`/WEB-INF/views/`
- 支持 UTF-8 编码
- 自动添加 `.ftl` 后缀

### 4. **日志系统**
- 集成 Log4j 日志框架
- 控制台输出日志
- 包级别日志控制（Spring 和应用包设为 DEBUG 级别）

## 使用方法

### 环境要求
- JDK 1.7+
- Maven 3.0+
- Tomcat 7.0+

### 构建项目

```bash
# 进入项目目录
cd /Users/luowei/projects/My_Java/repos/spring-demo

# 编译打包
mvn clean package
```

### 运行项目

#### 方式一：使用 Maven Tomcat 插件（推荐）

```bash
mvn tomcat7:run
```

项目将在 `http://localhost:8080` 启动

#### 方式二：部署到 Tomcat 服务器

1. 执行 `mvn clean package` 生成 WAR 包
2. 将生成的 WAR 包部署到 Tomcat 的 webapps 目录
3. 启动 Tomcat 服务器

### 访问应用

- **首页**: http://localhost:8080/
- **Home 页**: http://localhost:8080/home

## 依赖说明

### 核心依赖

| 依赖 | 版本 | 说明 |
|------|------|------|
| spring-webmvc | 4.0.0.RELEASE | Spring MVC 核心框架，提供 Web 层支持 |
| spring-context-support | 4.0.0.RELEASE | Spring 上下文支持，提供模板引擎集成等功能 |
| freemarker | 2.3.19 | FreeMarker 模板引擎 |
| groovy-all | 2.2.1 | Groovy 动态语言完整包 |
| javax.servlet-api | 3.0.1 | Servlet API（provided 范围） |
| log4j | 1.2.14 | Log4j 日志框架 |

### Maven 插件

- **tomcat7-maven-plugin** (2.1): 用于快速启动 Tomcat 服务器进行开发测试

## 配置说明

### DispatcherServlet 配置
- **组件扫描**: `com.rootls.controller` 包
- **视图解析器**: FreeMarkerViewResolver
- **模板路径**: `/WEB-INF/views/`
- **模板后缀**: `.ftl`
- **字符编码**: UTF-8

### 日志配置
- **根日志级别**: INFO
- **Spring Beans Factory**: DEBUG
- **应用包 (com.rootls)**: DEBUG
- **输出格式**: 包含时间、级别、线程、类名、行号和消息

## 其他相关信息

### 项目特点

1. **现代化配置方式**: 采用 Java Config 替代传统 XML 配置，代码更清晰易维护
2. **多语言支持**: 同时支持 Java 和 Groovy 编写控制器，展示了 JVM 平台的灵活性
3. **轻量级架构**: 最小化依赖，适合学习和快速开发
4. **即插即用**: 使用 Maven Tomcat 插件可快速启动，无需额外配置服务器

### 适用场景

- Spring MVC 学习和入门
- Java 配置方式的参考示例
- Groovy 与 Spring 集成的实践
- 轻量级 Web 应用快速开发

### 开发者信息

- 创建者: luowei
- 创建日期: 2014/4/25

### 技术要点

1. **WebApplicationInitializer**: Servlet 3.0+ 提供的编程式配置接口，替代 web.xml
2. **AnnotationConfigWebApplicationContext**: 基于注解的应用上下文
3. **@EnableWebMvc**: 启用 Spring MVC 配置
4. **@ComponentScan**: 自动扫描并注册 Spring 组件
5. **混合语言开发**: Java 和 Groovy 控制器共存

### 视频讲解

[项目讲解视频](http://www.tudou.com/programs/view/REg-okqxwCs/)

---

**注意**: 本项目使用的 Spring 4.0.0 和其他依赖版本较旧，仅供学习参考。生产环境建议使用最新稳定版本。
