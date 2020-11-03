### 完成度：
__Details:__
- \- GroupController.java:20 缺少查看分组的接口

### 测试：
* 写了少量的controller测试
* 对于controller测试，了解下@WebMvcTest

### 知识点：
* 了解下DTO的概念，思考下什么场景引入DTO比较合适。
* 了解下Restful规范

__Details:__
+ \+ 使用了三层架构
+ \+ 使用了Lombok
+ \+ Bean的注入，都是使用构造器注入
- \- StudentRepository.java:18 诸如i++或者++i，这类操作处理id自增，线程不安全。可以了解下AtomicInteger。
- \- StudentController.java:29 根据restful实践，资源名一般是复数
- \- StudentController.java:30 根据restful实践，POST方法一般返回创建的内容或者Id
- \- StudentController.java:31 如果不是有自定义返回的需求，ResponseEntity一般可省略

### 工程实践：
__Details:__
- \- GroupService.java:14 长方法，需要按模块抽取方法，进行重构
- \- GroupService.java:20 Magic number 6



