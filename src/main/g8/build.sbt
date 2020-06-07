import Dependencies._
import sbt._

scalaVersion := "2.12.10"

addCompilerPlugin("org.spire-math" %% "kind-projector" % "0.9.6")

lazy val $name;format="camel"$ = (project in file(".")).
  .settings(
    name := "$name$",
    organization := "$organization$",
    version := "$version$",
    scalaVersion := "$scala_version$",
    resolvers := Resolver.mostResolvers,
    libraryDependencies ++= Seq(
          compilerPlugin(Libraries.kindProjector cross CrossVersion.full),
          compilerPlugin(Libraries.betterMonadicFor),
          compilerPlugin(Libraries.macroParadise cross CrossVersion.full),
          Libraries.cats,
          Libraries.circeCore,
          Libraries.circeGeneric,
          Libraries.circeParser,
          Libraries.circeRefined,
          Libraries.monocleCore,
          Libraries.monocleMacro,
          Libraries.log4cats,
          Libraries.logback % Runtime,
          Libraries.newtype,
          Libraries.refinedCore,
          Libraries.refinedCats
        ),
    scalacOptions := CommonBuild.scalacOptions
  )

// ammonite repl
sourceGenerators in Test += Def.task {
  val file = (sourceManaged in Test).value / "amm.scala"
  IO.write(file, """object amm extends App { ammonite.Main().run() }""")
  Seq(file)
}.taskValue