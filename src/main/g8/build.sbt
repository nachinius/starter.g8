import Dependencies._
import sbt._

// aliases
addCommandAlias("rtu", "; reload ; test:update")
addCommandAlias("rtc", "; reload ; test:compile")
addCommandAlias("ru", "; reload ; update")
addCommandAlias("rc", "; reload ; compile")
addCommandAlias("c", "; compile")
addCommandAlias("l","; lint:compile")
addCommandAlias("s","; sculpit:compile")

lazy val Lint: Configuration = config("lint") extend Compile
lazy val Sculpit: Configuration = config("sculpit") extend Compile

lazy val $name;format="camel"$ = (project in file("."))
  .settings(
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    scalaVersion := "$scala_version$",
    libraryDependencies ++= Seq(
      compilerPlugin(Libraries.kindProjector cross CrossVersion.full),
      compilerPlugin(Libraries.betterMonadicFor),
      compilerPlugin(Libraries.macroParadise cross CrossVersion.full),
      Libraries.cats,
      Libraries.catsEffect,
      Libraries.catsRetry,
      Libraries.fs2,
      Libraries.catsMeowMtl,
      Libraries.catsMeowMtlEffects,
      Libraries.circeCore,
      Libraries.circeGeneric,
      Libraries.circeParser,
      Libraries.circeRefined,
      Libraries.http4sDsl,
      Libraries.http4sServer,
      Libraries.http4sClient,
      Libraries.http4sCirce,
      Libraries.monocleCore,
      Libraries.monocleMacro,
      Libraries.log4cats,
      Libraries.logback % Runtime,
      Libraries.newtype,
      Libraries.refinedCore,
      Libraries.refinedCats,
      Libraries.tapir
    ),
    // wartremoverErrors ++= Warts.all
  )
  .configs(Lint).
  settings(inConfig(Lint) {
    Defaults.compileSettings ++ wartremover.WartRemover.projectSettings ++
      Seq(
        sources in Lint := {
          val old = (sources in Lint).value
          old ++ (sources in Compile).value
        },
        wartremover.WartRemover.autoImport.wartremoverErrors := wartremover.Warts.all
      ) }: _*).
  settings(
    scalacOptions in Compile := (scalacOptions in Compile).value filterNot { _ contains "wartremover" }
  ).configs(Sculpit).settings(inConfig(Sculpit) {
    Defaults.compileSettings ++
      Seq(scalacOptions ++= Seq("-Xplugin:lib/scala-sculpt_2.12-0.1.4-SNAPSHOT.jar","-Xplugin-require:sculpt","-P:sculpt:out=target/sculpit.json")) ++
      Seq(sources in Sculpit := { val old = (sources in Sculpit).value; old ++ (sources in Compile).value }
      ) }: _*)

/**
 * Ammonite
      sbt projectName/test:run
      sbt projectName/test:run-main amm
**/
addCommandAlias("amm", "test:run")

libraryDependencies += {
  val version = scalaBinaryVersion.value match {
    case "2.10" => "1.0.3"
    case _ ⇒ "2.1.4"
  }
  "com.lihaoyi" % "ammonite" % version % "test" cross CrossVersion.full
}

// ammonite repl
sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main().run() }""")
  Seq(file)
}.taskValue

// Optional, required for the `source` command to work
(fullClasspath in Test) ++= {
  (updateClassifiers in Test).value
    .configurations
    .find(_.configuration.name == Test.name)
    .get
    .modules
    .flatMap(_.artifacts)
    .collect{case (a, f) if a.classifier == Some("sources") => f}
}

