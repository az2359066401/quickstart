package org.myorg.quickstart


import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment,_}
import org.apache.flink.api.java.utils.ParameterTool


object WordCount {

  def main(args: Array[String]): Unit = {
    //第一步设定执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    //第二步 指定数据源地址  读取输入数据
    val text = env.readTextFile("C:\\Users\\mayn\\Downloads\\2019102561828.csv")
    //第三步 对数据集指定转换操作逻辑
    val counts: DataStream[(String,Int)] = text.flatMap(_.toLowerCase().split(",")).filter(_.nonEmpty).map((_,1)).keyBy(0).sum(1)
    //第四步  指定计算结果输出位置
    counts.writeAsText("C:\\Users\\mayn\\Downloads\\test1.csv")
    env.execute("Flink Streaming Scala API Skeleton")

  }

}
