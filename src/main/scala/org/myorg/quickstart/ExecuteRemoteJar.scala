package org.myorg.quickstart

import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment

object ExecuteRemoteJar {


  def main(args: Array[String]): Unit = {
    //设定flink 运行环境  如果在本地启动则创建本地环境  如果是在集群上启动  则创建集群环境
    StreamExecutionEnvironment.getExecutionEnvironment
    //指定并行度 创建本地执行环境
    StreamExecutionEnvironment.createLocalEnvironment(5)
    //指定远程JobManagerIP 和 RPC 端口 以及 运行程序 所在jar包及其依赖包
    StreamExecutionEnvironment.createRemoteEnvironment("s40",6021,5,"E:\\User\\work_idea\\sc\\sc-jar-scan\\jars-scan\\jars-scan-service\\target\\jars-scan-service.jar")

  }

}
