import sbt._
import Keys._
import Info._

import scala.sys.process._

object ShellPrompt {

  object devnull extends ProcessLogger {
    override def out(s: => String): Unit = {}
    override def err(s: => String): Unit = {}
    override def buffer[T](f: => T): T = f
  }

  val oops = "-?-"

  def currBranch = Info.branch

  def currModifications =
    ("git status -sb"
      .lineStream_!(devnull).tail).foldLeft("")(
        (a, n) => n.trim.split(" ").headOption.map(m => if (a.contains(m)) a else a + m) getOrElse oops
      )

  def currVersion = Process("git rev-parse --short HEAD").lineStream.headOption.getOrElse("<no_git_sha_found>")

  def buildShellPrompt = { (state: State) =>
    {
      val currProject = Project.extract(state).currentProject.id
      s"%s : ${scala.Console.CYAN}%s ${scala.Console.RESET}: %s : ${scala.Console.YELLOW}%s${scala.Console.RESET}> ".format(
        currProject,
        currBranch,
        currVersion,
        currModifications
      )
    }
  }
}
