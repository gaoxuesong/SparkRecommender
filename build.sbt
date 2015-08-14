//import AssemblyKeys._

//assemblySettings

name := "SparkRecommender"

version := "1.0"

scalaVersion := "2.10.4"

javacOptions ++= Seq("-source", "1.7", "-target", "1.7")

// protocol buffer support
//seq(sbtprotobuf.ProtobufPlugin.protobufSettings: _*)

// additional libraries
libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "1.2.0",
  "org.apache.spark" %% "spark-sql" % "1.2.0",
  "org.apache.spark" %% "spark-hive" % "1.2.0",
  "org.apache.spark" %% "spark-streaming" % "1.2.0",
  "org.apache.spark" %% "spark-streaming-kafka" % "1.2.0",
  "org.apache.spark" %% "spark-streaming-flume" % "1.2.0",
  "org.apache.spark" %% "spark-mllib" % "1.2.0",
  "org.apache.spark" %% "spark-graphx" % "1.2.0",
  "org.apache.commons" % "commons-lang3" % "3.0",
  //"org.scalanlp" % "breeze-natives_2.11" %  "0.10",
  //"org.eclipse.jetty"  % "jetty-client" % "8.1.14.v20131031",
  "com.typesafe.play" % "play-json_2.10" % "2.2.1",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.3.3",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.3.3",
  //"org.elasticsearch" % "elasticsearch-hadoop-mr" % "2.0.0.RC1",
  "net.sf.opencsv" % "opencsv" % "2.0",
  "mysql" % "mysql-connector-java" % "5.1.31",
  "com.datastax.spark" %% "spark-cassandra-connector" % "1.0.0-rc5",
  "com.datastax.spark" %% "spark-cassandra-connector-java" % "1.0.0-rc5",
  //"com.github.scopt" %% "scopt" % "3.2.0",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  //"com.holdenkarau" %% "spark-testing-base" % "0.0.1" % "test"
  // other dependencies here
  "org.scalanlp" %% "breeze" % "0.11.2",
  // native libraries are not included by default. add this if you want them (as of 0.7)
  // native libraries greatly improve performance, but increase jar sizes.
  // It also packages various blas implementations, which have licenses that may or may not
  // be compatible with the Apache License. No GPL code, as best I know.
  "org.scalanlp" %% "breeze-natives" % "0.11.2",
  // the visualization library is distributed separately as well.
  // It depends on LGPL code.
  "org.scalanlp" %% "breeze-viz" % "0.11.2"
)

resolvers ++= Seq(
  //"JBoss Repository" at "http://repository.jboss.org/nexus/content/repositories/releases/",
  "Spray Repository" at "http://repo.spray.cc/",
  //"Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  //"Cloudera Repository" at "https://repository.cloudera.com/artifactory/cloudera-repos/",
  "Akka Repository" at "http://repo.akka.io/releases/",
  "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
  "scala-tools" at "https://oss.sonatype.org/content/groups/scala-tools",
  "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/",
  "Second Typesafe repo" at "http://repo.typesafe.com/typesafe/maven-releases/",
  "Mesosphere Public Repository" at "http://downloads.mesosphere.io/maven",
  "opennlp sourceforge repo" at "http://opennlp.sourceforge.net/maven2",
  "Sonatype Releases" at "https://oss.sonatype.org/content/repositories/releases/",
  Resolver.sonatypeRepo("public")
)
//
//mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
//  {
//    case m if m.toLowerCase.endsWith("manifest.mf") => MergeStrategy.discard
//    case m if m.startsWith("META-INF") => MergeStrategy.discard
//    case PathList("javax", "servlet", xs @ _*) => MergeStrategy.first
//    case PathList("org", "apache", xs @ _*) => MergeStrategy.first
//    case PathList("org", "jboss", xs @ _*) => MergeStrategy.first
//    case "about.html"  => MergeStrategy.rename
//    case "reference.conf" => MergeStrategy.concat
//    case _ => MergeStrategy.first
//  }
//}