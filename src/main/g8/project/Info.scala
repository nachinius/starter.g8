  object Info {
    import sys.process._

    val buildTimestamp: Long = Instant.now(Clock.systemUTC()).getEpochSecond
    val defaultZDTParser: DateTimeFormatter = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"))
    val fallBackBuildTime: String = ZonedDateTime.now(Clock.systemUTC).format(defaultZDTParser)

    val buildTime: String = Option(System.getenv("GIT_COMMIT_DT"))
      .orElse("git show --date=format-local:%Y-%m-%dT%H:%M:%SZ --pretty=format:%ad".lineStream_!.headOption)
      .getOrElse(s"${fallBackBuildTime}_<fallback>")

    val branchEnv: Option[String] = Option(System.getenv("GIT_BRANCH"))

    val branch: String = branchEnv
      .orElse(
        ("git branch --remote --verbose --no-abbrev --contains" #| Seq("sed", "-nE", """s/^[^\/]*\/([^\ ]+).*$/\1/p""")).lineStream_!.headOption
      )
      .getOrElse("<no-branch-info>")

    val buildAuthor: String = Option(System.getenv("BUILD_USER")).map(_.replace(" ", "-")).getOrElse("<anonymous>")

  }