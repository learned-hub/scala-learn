// See README.md for license details.

name := "scala-learn"
version := "1.0.0"
scalaVersion := "2.13.6"
transitiveClassifiers := Seq(Artifact.SourceClassifier)

//resolvers ++= Seq(
//  Resolver.sonatypeRepo("snapshots"),
//  Resolver.sonatypeRepo("releases")
//)

lazy val root = (project in file("."))
  .settings(
    scalacOptions ++= Seq(
      "-deprecation"
    )
  )