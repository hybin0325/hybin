# Version 0.0.1
FROM java:8

MAINTAINER Lins KK "562359728@qq.com"

# 环境变量
ENV WORK_PATH /home/container
ENV APP_NAME @project.build.finalName@.@project.packaging@
ENV APP_VERSION @project.version@

EXPOSE 9191

#USER
#USER user:group

#VOLUME
VOLUME ["/home/container", "/tmp/data"]

#ADD

#COPY
COPY $APP_NAME $WORK_PATH/

#LABEL
#STOPSIGNAL
#ARG
#ONBUILD

# WORKDIR
WORKDIR $WORK_PATH

# ENTRYPOINT
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom"]

# CMD
CMD ["-jar", "@project.build.finalName@.@project.packaging@"]
