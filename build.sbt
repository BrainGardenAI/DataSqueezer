organization := "io.brain-garden"
name := "data-admin"
version := "0.1"
scalaVersion := "2.11.8"

libraryDependencies ++= {
  val akkaV       = "2.4.9"
  val scalaTestV  = "3.0.0"
  Seq(
    "com.typesafe"       % "config"                               % "1.3.0",
    "com.typesafe.akka" %% "akka-http-core"                       % akkaV,
    "com.typesafe.akka" %% "akka-stream"                          % akkaV,
    "com.typesafe.akka" %% "akka-http-spray-json-experimental"    % akkaV,
    "com.typesafe.akka" %% "akka-http-testkit-experimental"       % "2.4.2-RC3",
    "org.scalatest"     %% "scalatest"                            % scalaTestV % "test"
  )
}

coverageEnabled := true