name := "spray-bad-list-example"

version := "1.0"

scalaVersion := "2.10.3"

mainClass in (Compile,run) := Some("com.henri.Main")

scalacOptions  ++= Seq(
  "-feature",
  "-deprecation",
  "-unchecked",
  "-language:_",
  "-Ywarn-dead-code",
  "-target:jvm-1.7",
  "-encoding",
  "UTF-8"
)

resolvers ++= Seq(
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
  Classpaths.typesafeResolver,
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.sonatypeRepo("snapshots"),
  "spray" at "http://repo.spray.io"
)

libraryDependencies <<= scalaVersion { scala_version =>
  val akkaVersion   = "2.2.3"
  val sprayVersion = "1.2.0"
  Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-kernel" % akkaVersion,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.slick" %% "slick" % "1.0.1",
    "com.rabbitmq" % "amqp-client" % "3.1.1",
    "postgresql" % "postgresql" % "9.1-901.jdbc4",
    "ch.qos.logback" % "logback-classic" % "1.1.0",
    "org.scalautils" %% "scalautils" % "2.0",
    "com.codahale.metrics" % "metrics-core" % "3.0.1",
    "nl.grons" %% "metrics-scala" % "3.0.4",
    "io.spray" % "spray-can" % sprayVersion,
    "io.spray" % "spray-routing" % sprayVersion,
    "io.spray" % "spray-client" % sprayVersion,
    "io.spray" %% "spray-json" % "1.2.6",
    "com.github.sstone" %% "amqp-client" % "1.3-ML4",
    "org.scalacheck" %% "scalacheck" % "1.10.1" % "test",
    "org.scalatest" %% "scalatest" % "2.0" % "test",
    "io.spray" % "spray-testkit" % sprayVersion % "test"
  )
}