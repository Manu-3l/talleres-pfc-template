package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MaxListTailTest extends AnyFunSuite {
  val maxLists = new maxLists()

  test("El mayor numero en (List(7, 2, 3, 9) es 9") {
    assert(maxLists.maxIt(List(7, 2, 3, 9)) == 9)
  }

  test("El mayor numero en (List(812, 7362, 99) es 7362") {
    assert(maxLists.maxIt(List(812, 7362, 99)) == 7362)
  }

  test("El mayor numero en (List(72, 34, 21, 99) es 99") {
    assert(maxLists.maxIt(List(72, 34, 21, 99)) == 99)
  }

  test("El mayor numero en 0") {
    assert(maxLists.maxIt(List()) == 0)
  }

  test("El mayor numero en (List(2, 18, 9, 42) es 42") {
    assert(maxLists.maxIt(List(2, 18, 9, 42)) == 42)
  }
}