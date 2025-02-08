common 公共的、通用的、常量类、工具类

controller 主要业务功能处理类

handler 全局处理句柄、全局异常处理、全局拦截等

mapper 被serviceImplement调用，与mapper xml一一对应，执行与数据库的交互

pojo/DTO 与前端交互的model(实体去掉image之后剩余部分)
pojo/Entity 与数据库交互的model

service 存接口
service/implement 被业务类调用，负责获取数据库数据

resources/mapper/*.xml 存sql语句

接口规范
localhost:8888/persona/...   全局post请求

localhost:8888/gurei/...   全局get请求

针对某个项目，以Hyperion为例

localhost:8888/persona/hyperion/...  Hyperion所属下的post请求

localhost:8888/gurei/hyperion/...    Hyperion所属下的get请求

example: hyperion下的登录请求为localhost:8888/persona/hyperion/login

相对的，全局通用登录请求为localhost:8888/persona/login

