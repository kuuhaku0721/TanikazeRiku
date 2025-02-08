common 公共的、通用的、常量类

controller 主要业务功能处理类

handler 全局处理句柄、全局异常处理、全局拦截等

mapper 被serviceImplement调用，与mapper xml一一对应，执行与数据库的交互

pojo/DTO 与前端交互的model
pojo/Entity 与数据库交互的model

service 存接口
service/implement 被业务类调用，负责获取数据库数据

resources/mapper/*.xml 存sql语句