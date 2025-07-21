# 各种模块的练习  
This is a practice notebook  
Trying to improve my proficiency in Spring by building minimal modules of enterprise-level projects for hands-on practice.

## 登录模块 / Login Module

这是一个用于练习 Spring Boot 登录功能的最小可运行模块（MVP）。通过该模块可以熟悉 Spring Boot 的基础结构、Spring Security、JWT、统一返回格式、全局异常处理、数据库操作等内容。

### 模块结构 / Module Structure

```
springboot-login-demo
├─ src
│  ├─ main
│  │  ├─ java
│  │  │  └─ com.example.login
│  │  │     ├─ LoginApplication.java
│  │  │     ├─ common              // 公共层
│  │  │     │  ├─ config           // 配置
│  │  │     │  │  ├─ JwtConfig.java
│  │  │     │  │  ├─ RedisConfig.java
│  │  │     │  │  └─ SwaggerConfig.java
│  │  │     │  ├─ constant         // 常量
│  │  │     │  │  └─ JwtConstant.java
│  │  │     │  ├─ exception        // 全局异常
│  │  │     │  │  ├─ GlobalExceptionHandler.java
│  │  │     │  │  └─ BizException.java
│  │  │     │  ├─ model            // 统一返回
│  │  │     │  │  └─ ApiResult.java
│  │  │     │  └─ util              // 工具
│  │  │     │     └─ JwtUtil.java
│  │  │     ├─ user                // 用户域
│  │  │     │  ├─ controller
│  │  │     │  │  └─ AuthController.java
│  │  │     │  ├─ dto
│  │  │     │  │  ├─ LoginDTO.java
│  │  │     │  │  └─ UserInfoVO.java
│  │  │     │  ├─ entity
│  │  │     │  │  └─ User.java
│  │  │     │  ├─ mapper
│  │  │     │  │  └─ UserMapper.java
│  │  │     │  ├─ service
│  │  │     │  │  ├─ UserService.java
│  │  │     │  │  └─ impl
│  │  │     │  │     └─ UserServiceImpl.java
│  │  │     │  └─ security          // Spring Security 配置
│  │  │     │     ├─ JwtAuthenticationFilter.java
│  │  │     │     └─ SecurityConfig.java
│  │  └─ resources
│  │     ├─ application.yml
│  │     ├─ db/migration
│  │     │  └─ V1__init.sql
│  │     └─ logback-spring.xml
├─ pom.xml
└─ README.md
```
