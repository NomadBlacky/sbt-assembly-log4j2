// Your profile name of the sonatype account. The default is the same with the organization value
sonatypeProfileName := "com.github.nomadblacky"

// To sync with Maven central, you need to supply the following information:
publishMavenStyle := true

// License of your choice
licenses := Seq("MIT" -> url("https://github.com/NomadBlacky/sbt-assembly-log4j2/blob/master/LICENSE/"))

// Where is the source code hosted
import xerial.sbt.Sonatype._
sonatypeProjectHosting := Some(GitHubHosting("NomadBlacky", "sbt-assembly-log4j2", "tkadowaki.dev.blackey@gmail.com"))

// or if you want to set these fields manually
homepage := Some(url("https://github.com/NomadBlacky/sbt-assembly-log4j2"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/NomadBlacky/sbt-assembly-log4j2"),
    "scm:git@github.com:NomadBlacky/sbt-assembly-log4j2.git"
  )
)
developers := List(
  Developer(id = "NomadBlacky",
            name = "Takumi Kadowaki",
            email = "tkadowaki.dev.blackey@gmail.com",
            url = url("https://www.nomadblacky.dev"))
)
