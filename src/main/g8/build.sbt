import Dependencies._
import sbt._

// aliases
addCommandAlias("rtu", "; reload ; test:update")
addCommandAlias("rtc", "; reload ; test:compile")
addCommandAlias("ru", "; reload ; update")
addCommandAlias("rc", "; reload ; compile")
addCommandAlias("c", "; compile")


lazy val $name;format="camel"$ = (project in file("."))
  .settings(
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    scalaVersion := "$scala_version$",
    libraryDependencies ++= Seq(
      compilerPlugin(Libraries.kindProjector cross CrossVersion.full),
      compilerPlugin(Libraries.betterMonadicFor),
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
    )
  )

