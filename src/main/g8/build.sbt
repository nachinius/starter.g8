import Dependencies._
import sbt._

val otherCompile = taskKey[xsbti.compile.CompileAnalysis]("Another compile settings")
otherCompile := (compile in Compile).value

scalacOptions in otherCompile := (Compile / scalacOptions).value.diff(Seq(""))

// aliases
addCommandAlias("rtu", "; reload ; test:update")
addCommandAlias("rtc", "; reload ; test:compile")
addCommandAlias("ru", "; reload ; update")
addCommandAlias("rc", "; reload ; compile")
addCommandAlias("c", "; compile")
addCommandAlias("oc", "; otherCompile")

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
  )

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

