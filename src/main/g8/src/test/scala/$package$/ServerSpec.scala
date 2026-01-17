package \$package\$

import munit._
import cats.effect._
import org.http4s._
import org.http4s.implicits._
import cats.effect.unsafe.implicits.global

class ServerSpec extends FunSuite {
  test("Routes should respond to hello endpoint with correct greeting") {
    val name = "world"
    val response = Routes.helloWorldService.run(
      Request[IO](Method.GET, uri"/hello/world")
    ).unsafeRunSync()
    
    assertEquals(response.status, Status.Ok)
    
    val body = response.as[String].unsafeRunSync()
    assertEquals(body, s"Hello, \$name")
  }
}
