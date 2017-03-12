#使用说明

1. Eclipse或MyEclipse import 项目
1. 配置Tomcat:
      工程右键-->Project Facets 右侧RunTimes选择本机可用的Tomcat.
3. IDE工程中复制jar包到/WebContent/WEB-INF/lib目录下（如果jar包没有丢失，可以忽略此步）
4. 配置Tomcat下部署的jar包:
        工程右键-->Deployment Assembly 右侧Add-->Java Build Path Entity-->（Ctrl+A）全部选择
5. 刷新工程，启动Tomcat。项目即可正常运行


