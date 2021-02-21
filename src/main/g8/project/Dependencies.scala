import sbt._

object Dependencies {

  object Versions {

    val cats          = "2.1.1"
    val catsEffect    = "2.1.2"
    val catsMeowMtl   = "0.4.0"
    val catsRetry     = "1.1.0"
    val circe         = "0.13.0"
    val ciris         = "1.0.4"
    val fs2           = "2.3.0"

    // http
    val http4s        = "0.21.3"
    val http4sJwtAuth = "0.0.4"


    val log4cats      = "1.0.1"
    val newtype       = "0.4.3"
    val refined       = "0.9.13"
    val redis4cats    = "0.9.6"
    val squants       = "1.6.0"
    val monocle       = "2.0.0"
    val tapir         = "0.15.4"

    // db
    val skunk         = "0.0.8"
    val quill         = "3.5.2"
    val doobie        = "0.8.8"


    // generic programming
    val shapless      = "2.3.3"

    // compiler plugins
    val betterMonadicFor = "0.3.1"
    val kindProjector    = "0.11.3"
    val logback          = "1.2.3"

    val scalaCheck    = "1.14.3"
    val scalaTest     = "3.2.0"
  }

  object Libraries {
    def circe(artifact: String): ModuleID  = "io.circe"   %% artifact % Versions.circe
    def ciris(artifact: String): ModuleID  = "is.cir"     %% artifact % Versions.ciris
    def http4s(artifact: String): ModuleID = "org.http4s" %% artifact % Versions.http4s
    def meow(artifact: String): ModuleID   = "com.olegpy" %% artifact % Versions.catsMeowMtl

    val cats        = "org.typelevel"    %% "cats-core"     % Versions.cats
    val catsEffect  = "org.typelevel"    %% "cats-effect"   % Versions.catsEffect
    val catsRetry   = "com.github.cb372" %% "cats-retry"    % Versions.catsRetry
    val squants     = "org.typelevel"    %% "squants"       % Versions.squants
    val fs2         = "co.fs2"           %% "fs2-core"      % Versions.fs2

    val catsMeowMtl = meow("meow-mtl-core")
    val catsMeowMtlEffects = meow("meow-mtl-effects")
    val catsMeowMtlMonix = meow("meow-mtl-monix")

    val circeCore    = circe("circe-core")
    val circeGeneric = circe("circe-generic")
    val circeParser  = circe("circe-parser")
    val circeRefined = circe("circe-refined")

    // configuration
    val cirisCore    = ciris("ciris")

    val cirisEnum    = ciris("ciris-enumeratum")
    val cirisRefined = ciris("ciris-refined")

    val http4sDsl    = http4s("http4s-dsl")
    val http4sServer = http4s("http4s-blaze-server")
    val http4sClient = http4s("http4s-blaze-client")
    val http4sCirce  = http4s("http4s-circe")

    val http4sJwtAuth = "dev.profunktor" %% "http4s-jwt-auth" % Versions.http4sJwtAuth

    val refinedCore = "eu.timepit" %% "refined"      % Versions.refined
    val refinedCats = "eu.timepit" %% "refined-cats" % Versions.refined

    val log4cats = "io.chrisdavenport" %% "log4cats-slf4j" % Versions.log4cats
    val newtype  = "io.estatico"       %% "newtype"        % Versions.newtype

    val redis4catsEffects  = "dev.profunktor" %% "redis4cats-effects"  % Versions.redis4cats
    val redis4catsLog4cats = "dev.profunktor" %% "redis4cats-log4cats" % Versions.redis4cats

    val doobie =   "org.tpolecat" %% "doobie-core" % Versions.doobie
    val doobieH2 = "org.tpolecat" %% "doobie-h2"        % Versions.doobie          // H2 driver 1.4.200 + type mappings.
    val doobieHikari = "org.tpolecat" %% "doobie-hikari"    % Versions.doobie          // HikariCP transactor.
    val doobiePostgres = "org.tpolecat" %% "doobie-postgres"  % Versions.doobie          // Postgres driver 42.2.9 + type mappings.
    val doobieQuill = "org.tpolecat" %% "doobie-quill"     % Versions.doobie          // Support for Quill 3.4.10
    val doobieSpec2 = "org.tpolecat" %% "doobie-specs2"    % Versions.doobie % "test" // Specs2 support for typechecking statements.
    val doobieScalaTest = "org.tpolecat" %% "doobie-scalatest" % Versions.doobie % "test" 

    val quill = "io.getquill" %% "quill-core" % Versions.quill

    val skunkCore  = "org.tpolecat" %% "skunk-core"  % Versions.skunk
    val skunkCirce = "org.tpolecat" %% "skunk-circe" % Versions.skunk

    val monocleCore = "com.github.julien-truffaut" %% "monocle-core" % Versions.monocle
    val monocleMacro = "com.github.julien-truffaut" %% "monocle-macro" % Versions.monocle

    val tapir = "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.tapir

    // shapeless
    val shapeless = "com.chuusai" %% "shapeless" % Versions.shapless

    // Compiler plugins
    val betterMonadicFor = "com.olegpy"    %% "better-monadic-for" % Versions.betterMonadicFor
    val kindProjector    = "org.typelevel" % "kind-projector"      % Versions.kindProjector

    // Runtime
    val logback = "ch.qos.logback" % "logback-classic" % Versions.logback

    // Test
    val scalaCheck    = "org.scalacheck"    %% "scalacheck"      % Versions.scalaCheck
    val scalaTest     = "org.scalatest"     %% "scalatest"       % Versions.scalaTest
  }

  object Resolvers {

    val snapshots = Resolver.sonatypeRepo("snapshots")
    val release = Resolver.sonatypeRepo("release")

    val moreResolvers = Seq(
        "Typesafe Snapshots" at "http://repo.typesafe.com/typesafe/snapshots/",
        "Secured Central Repository" at "https://repo1.maven.org/maven2",
    )
  }
}