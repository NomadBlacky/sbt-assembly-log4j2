package sbtassembly

import java.io.{File, FileOutputStream}

import scala.collection.JavaConverters.asJavaEnumerationConverter

import org.apache.logging.log4j.core.config.plugins.processor.PluginCache

object Log4j2MergeStrategy {
  val plugincache: MergeStrategy = new MergeStrategy {
    val name = "log4j2::plugincache"
    def apply(tempDir: File, path: String, files: Seq[File]): Either[String, Seq[(File, String)]] = {
      val file = MergeStrategy.createMergeTarget(tempDir, path)
      val out  = new FileOutputStream(file)

      val aggregator = new PluginCache()
      val filesEnum  = files.toIterator.map(_.toURI.toURL).asJavaEnumeration

      try {
        aggregator.loadCacheFiles(filesEnum)
        aggregator.writeCache(out)
        Right(Seq(file -> path))
      } finally {
        out.close()
      }
    }
  }
}
