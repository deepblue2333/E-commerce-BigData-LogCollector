# E-commerce-BigData-LogCollector

电商数仓项目用户行为日志采集模块

### 目录结构
```shell
.
├── README.md
├── command                   -- 日志采集服务启动脚本
│   └── xxx.sh          
└── flume-conf                -- flume Agent配置文件
    └── xxx.properties


```
用户行为日志的采集模块架构为：

日志.log文件 -> 采集者flume -> Kafka(缓冲层) -> 消费者flume -> HDFS落盘