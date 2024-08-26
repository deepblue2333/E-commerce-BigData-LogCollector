#! /bin/bash

ssh cdh02 "ps -ef | grep file-flume-kafka | grep -v grep| awk '{print $2}'| xargs -n1 kill -9"

ssh cdh03 "ps -ef | gp kafka-flume-hdfs | grep -v grep| awk '{print $2}'| xargs -n1 kill -9"

print "Stop Done"