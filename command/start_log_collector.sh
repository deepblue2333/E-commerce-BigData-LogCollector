#! /bin/bash

FLUME_HOME="/root/lib_link/flume-ng"
ssh cdh02 "$FLUME_HOME/flume-ng/bin/flume-ng agent --conf-file $FLUME_HOME/conf/file-flume-kafka.properties --name a1
          --conf $FLUME_HOME/conf -Dflume.root.logger=INFO,console > /opt/module/flume/log1.txt 2>&1 &"

ssh cdh03 "$FLUME_HOME/flume-ng/bin/flume-ng agent --conf-file $FLUME_HOME/conf/kafka-flume-hdfs.properties --name a1
          --conf $FLUME_HOME/conf -Dflume.root.logger=INFO,console > /opt/module/flume/log1.txt 2>&1 &"

echo "Start Done"