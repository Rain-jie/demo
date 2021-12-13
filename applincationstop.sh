#!/bin/sh
# func:自动监控tomcat脚本并且执行重启操作
#tomcat启动程序(这里注意Tomcat实际安装的路径)

export JAVA_HOME=/usr/local/src/software/jdk/jdk1.8.0_301
export PATH=$JAVA_HOME/bin:$PATH
export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar


StartTomcat=/usr/local/src/software/tomcat/epictopia-tomacat-8.5.71-8081/bin/startup.sh
TomcatWorkCache=/usr/local/src/software/tomcat/epictopia-tomacat-8.5.71-8081/work
TomcatConfCache=/usr/local/src/software/tomcat/epictopia-tomacat-8.5.71-8081/conf
TomcatWebapps=/usr/local/src/software/tomcat/epictopia-tomacat-8.5.71-8081/webapps


#执行脚本是为了方便CodeDeploy部署服务
#Code Deploy 执行此脚本是为了部署并执行此服务，所以每次执行时我们首先清除服务缓存
#清理缓存后在启动服务

#第一步 清理旧服务遗留
rm -rf $TomcatWebapps/epictopia
rm -rf $TomcatWebapps/epictopia.war

#第二步 清理Tomcat缓存
rm -rf $TomcatWorkCache/Catalina
rm -rf $TomcatConfCache/Catalina

#第三步 启动服务
$StartTomcat
#/usr/local/src/software/tomcat/epictopia-tomacat-8.5.71-8081/bin/startup.sh
