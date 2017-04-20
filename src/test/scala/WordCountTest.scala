

import java.io.{ FileWriter, File }

// Scala
import scala.io.Source

// Google Guava
import com.google.common.io.Files

// Specs2
import org.specs2.mutable.Specification
import org.scalatest.FlatSpec

class WordCountTest extends FlatSpec  {

  "java" should "asdf" in {
      val asdf="java"
      val fda="java"
      asdf==fda
  }
  
  "A WordCount job" should "count words correctly" in {

      val tempDir = Files.createTempDir()
      val inputFile = new File(tempDir, "input").getAbsolutePath
      val inWriter = new FileWriter(inputFile)
      inWriter.write("java java scala scala")
      inWriter.close
      val outputDir = new File(tempDir, "output").getAbsolutePath

      WordCount.execute()

      val outputFile = new File("output", "part-00000")
      val actual = Source.fromFile(outputFile).mkString
      actual === "(java,2)\n(scala,2)\n"
  }
}