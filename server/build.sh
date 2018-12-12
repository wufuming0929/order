#!/bin/sh
mvn clean package -Dmaven.test.skip=true
docker build -t springcloud/order .
docker push registry.cn-hangzhou.aliyuncs.com/formain/springcloud:order