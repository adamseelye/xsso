ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.10"

lazy val root = (project in file("."))
  .settings(
    name := "xsso"
  )

libraryDependencies ++= Seq(
  "com.github.jwt-scala" %% "jwt-core" % "9.2.0",
  "mysql" % "mysql-connector-java" % "8.0.32",
  "com.lihaoyi" %% "requests" % "0.8.0"
)
