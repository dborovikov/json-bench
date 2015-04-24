name := "json-bench"

version := "1.0"

scalaVersion := "2.11.6"

jmhSettings

libraryDependencies ++= Seq(
  "io.argonaut" %% "argonaut" % "6.0.4",
  "com.typesafe.play" %% "play-json" % "2.3.8",
  "io.spray" %%  "spray-json" % "1.3.1",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.5.2",
  "org.spire-math" %% "jawn-ast" % "0.7.4",
  "org.spire-math" %% "argonaut-support" % "0.7.4",
  "org.spire-math" %% "spray-support" % "0.7.4"
)