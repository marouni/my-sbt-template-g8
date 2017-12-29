// description
organization := "$organization$"
name := "$name$"
version := "$version$"

// scala
scalaVersion := "$scalaVersion$"
val scalaStringVersion = scalaVersion.toString

// dependencies
$if(addSparkDependencies.truthy)$
libraryDependencies += "org.apache.spark" %% "spark-core" % "$sparkVersion$"
libraryDependencies += "org.apache.spark" %% "spark-sql" % "$sparkVersion$"
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "$sparkVersion$"
libraryDependencies += "org.apache.spark" %% "spark-mllib" % "$sparkVersion$"
libraryDependencies += "org.apache.spark" %% "spark-hive" % "$sparkVersion$"
$endif$

$if(addAkkaDependencies.truthy)$
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "$akkaVersion$",
  "com.typesafe.akka" %% "akka-testkit" % "$akkaVersion$" % Test
)
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-stream" % "$akkaVersion$",
  "com.typesafe.akka" %% "akka-stream-testkit" % "$akkaVersion$" % Test
)
libraryDependencies +=
  "com.typesafe.akka" %% "akka-cluster" % "$akkaVersion$"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-cluster-sharding" %  "$akkaVersion$"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-distributed-data" % "$akkaVersion$"
libraryDependencies +=
  "com.typesafe.akka" %% "akka-persistence" % "$akkaVersion$"
$endif$

// test dependencies
libraryDependencies += "org.specs2" %% "specs2-core" % "4.0.0" % "test"
scalacOptions in Test ++= Seq("-Yrangepos")

// Scalariform settings
import scalariform.formatter.preferences._
scalariformPreferences := scalariformPreferences.value
    .setPreference(AlignSingleLineCaseStatements, true)
    .setPreference(DoubleIndentConstructorArguments, true)
    .setPreference(DanglingCloseParenthesis, Preserve)
scalariformAutoformat := true
scalariformWithBaseDirectory := true
