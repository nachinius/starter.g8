import Dependencies._
import sbt._

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
        ),
  )

// ammonite repl
sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main().run() }""")
  Seq(file)
}.taskValue