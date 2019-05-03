lazy val commonSettings = Seq(
  organization in ThisBuild := "org.idio"
)

lazy val root = (project in file("."))
  .settings(commonSettings: _*)
  .settings(
    sbtPlugin := true,
    name := "sbt-assembly-log4j2",
    description := "sbt assembly plugin merge strategy for log4j2 plugins",
    licenses := Seq("MIT License" -> url("https://github.com/idio/sbt-assembly-log4j2/blob/master/LICENSE")),
    scalacOptions := Seq("-deprecation", "-unchecked"),
    addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.9"),
    libraryDependencies ++= Seq(
      "org.apache.logging.log4j" % "log4j-core" % "2.11.2"
    ),
    publishArtifact in (Compile, packageBin) := true,
    publishArtifact in (Test, packageBin) := false,
    publishArtifact in (Compile, packageDoc) := false,
    publishArtifact in (Compile, packageSrc) := true
  )
