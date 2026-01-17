package \$package\$

import munit._
import cats.effect._
import org.http4s._
import org.http4s.implicits._

class ServerSpec extends FunSuite {
  test("Routes should respond to hello endpoint") {
    val response = Routes.helloWorldService.run(
      Request[IO](Method.GET, uri"/hello/world")
    ).unsafeRunSync()
    
    assertEquals(response.status, Status.Ok)
  }
}
