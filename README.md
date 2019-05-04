# sbt-assembly-log4j2

**Problem**: When including several projects that include `log4j2` plugins,
`sbt-assembly` will encounter multiple versions of the `Log4j2Plugins.dat`
cache file that it won't be able to reconcile.

**Solution**: Log4j2 provides a `PluginCache` class that creates consistent,
serialisable cache from multiple different ones.

**This plugin** provides a simple function to merge those files in a safe way.

## Setup

For sbt 1.x add `sbt-assembly-log4j2` as a dependency in
`project/assembly.sbt` alongside [`sbt-assembly`][sbt-assembly]:

```scala
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "<version>")
addSbtPlugin("com.github.nomadblacky" % "sbt-assembly-log4j2" % "0.1.1")
```

[sbt-assembly]: https://github.com/sbt/sbt-assembly#setup

## Usage

In your merge strategy, add the following case:

```scala
import sbtassembly.Log4j2MergeStrategy

assemblyMergeStrategy in assembly := {
    //...
    case PathList(ps @ _*) if ps.last == "Log4j2Plugins.dat" => Log4j2MergeStrategy.plugincache
    //...
}
```
