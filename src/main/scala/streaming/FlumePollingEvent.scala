package streaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming._
import org.apache.spark.streaming.flume._
import org.apache.spark.util.IntParam
import java.net.InetSocketAddress

/**
 *  Produces a count of events received from Flume.
 *
 *  This should be used in conjunction with the Spark Sink running in a Flume agent. See
 *  the Spark Streaming programming guide for more details.
 *
 *  Usage: FlumePollingEvent <host> <port>
 *    `host` is the host on which the Spark Sink is running.
 *    `port` is the port at which the Spark Sink is listening.
 *
 *  To run this example:
 *    `$ bin/run-example org.apache.spark.examples.streaming.FlumePollingEventCount [host] [port] `
 *
 *    `cd /usr/lib/spark`
 *    `su hdfs`
 *    `./bin/spark-submit --master local[2] --class org.xuesong.intelligence.FlumePollingEvent ./lib/SparkAlgorithms.jar localhost 999`
 */
object FlumePollingEvent {
  def main(args: Array[String]) {
    if (args.length < 2) {
      System.err.println(
        "Usage: FlumePollingEventCount <host> <port>")
      System.exit(1)
    }

    //val Array(host, IntParam(port)) = args
    val host = args(0)
    val port = Integer.parseInt(args(1))
    val batchInterval = Milliseconds(2000)

    // Create the context and set the batch size
    val sparkConf = new SparkConf().setAppName("FlumePollingEvent")
    val ssc = new StreamingContext(sparkConf, batchInterval)

    // Create a flume stream that polls the Spark Sink running in a Flume agent
    val stream = FlumeUtils.createPollingStream(ssc, host, port)

    // Print out the count of events received from this server in each batch
    stream.count().map(cnt => "Received " + cnt + " flume events." ).print()

    ssc.start()
    ssc.awaitTermination()
  }
}

