package \$package\$

import munit._

class MainSpec extends FunSuite {
  test("Main should compile and run") {
    // This test ensures the Main object can be instantiated
    assert(Main != null)
  }

  test("example test") {
    val result = 1 + 1
    assertEquals(result, 2)
  }
}
