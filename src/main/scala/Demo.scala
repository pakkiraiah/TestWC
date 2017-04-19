import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WordCount {
  def main(args: Array[String]) = {

    val conf = new SparkConf().setAppName("WordCount").setMaster("local")
    val sc = new SparkContext(conf)
    println("reading  file")
    val test = sc.textFile("input.txt")
    println("reading file done")

    test.flatMap { line => line.split(" ") }.map { word => (word, 1) }.reduceByKey(_ + _).saveAsTextFile("output.txt")
    println("writting file dones file")

    sc.stop
  }
} 
