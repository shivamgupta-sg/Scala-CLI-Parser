name := "Scala-CLI-Parser"

version := "0.1"

scalaVersion := "2.13.5"


lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.3.0-SNAP3" % Test

lazy val root = project.in(file(".")).aggregate(cliParser, flags)

lazy val cliParser = project.in(file("cli-parser"))
  .settings(
    libraryDependencies += scalaTest,
    maintainer := "shivam.gupta@knoldus.com",
    mainClass in assembly := Some("com.knoldus.MainEntryPoint")
  )
  .dependsOn(flags)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(UniversalPlugin)

lazy val flags = project.in(file("flags"))
  .settings(
    libraryDependencies += scalaTest
  )
