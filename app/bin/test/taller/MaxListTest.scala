package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MaxListTest extends AnyFunSuite {
  val maxLists = new maxLists()

  test("El mayor numero en (List(1, 2, 3, 4, 5) es 5") {
    assert(maxLists.maxLin(List(1, 2, 3, 4, 5)) == 5)
  }

  test("El mayor numero en (List(42, 53, 77, 15) es 77") {
    assert(maxLists.maxLin(List(42, 53, 77, 15)) == 77)
  }

  test("El mayor numero en (List(21, 22, 25) es 25") {
    assert(maxLists.maxLin(List(21, 22, 25)) == 25)
  }

  test("El mayor numero en (List() es 0") {
    assert(maxLists.maxLin(List()) == 0)
  }

  test("El mayor numero en (List(276, 399, 86) es 399") {
    assert(maxLists.maxLin(List(276, 399, 86)) == 399)
  }
}
