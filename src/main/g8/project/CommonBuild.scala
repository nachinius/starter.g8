object CommonBuild {
    val scalacOptions: Seq[String] = Seq(
    "-deprecation", // Emit warning and location for usages of deprecated APIs.
    "-encoding",
    "utf-8", // Specify character encoding used by source files.
    "-explaintypes", // Explain type errors in more detail.
    "-feature", // Emit warning and location for usages of features that should be imported explicitly.
    "-language:higherKinds", // Allow higher-kinded types
    "-language:implicitConversions", // Allow definition of implicit functions called views
    "-unchecked", // Enable additional warnings where generated code depends on assumptions.
    "-Xcheckinit", // Wrap field accessors to throw an exception on uninitialized access.
    "-Xfatal-warnings", // Fail the compilation if there are any warnings.
    "-Xfuture", // Turn on future language features.
    "-Xlint:_", // Lint ALL the code.
    "-Ywarn-unused:params", // Warn if a value parameter is unused.
    "-Ywarn-unused:patvars", // Warn if a variable bound in a pattern is unused.
    "-Ypartial-unification", // Enable partial unification in type constructor inference
    "-Ywarn-dead-code", // Warn when dead code is identified.
    "-Ywarn-extra-implicit", // Warn when more than one implicit parameter section is defined.
    "-Ywarn-numeric-widen", // Warn when numerics are widened.
    "-Ywarn-value-discard" // Warn when non-Unit expression results are unused.
  )

    val typelevelScalacOptions: Seq[String] = Seq(
    //commented out because of https://www.bountysource.com/issues/46109047-compiler-error-with-yinduction-heuristics
    //"-Yinduction-heuristics",       // speeds up the compilation of inductive implicit resolution
    //"-Ykind-polymorphism",          // type and method definitions with type parameters of arbitrary kinds
    "-Yliteral-types", // literals can appear in type position
    "-Xstrict-patmat-analysis" // more accurate reporting of failures of match exhaustivity
  )

  val consoleScalacOptions = scalacOptions -- Seq("-Ywarn-unused", "-Xfatal-warnings")

}