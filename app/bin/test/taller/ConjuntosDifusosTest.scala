package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ConjuntosDifusosTest extends AnyFunSuite {
  val objConjuntosDifusos = new ConjuntosDifusos()
  val conjunto = objConjuntosDifusos.muchoMayorQue(1, 3)
  val conjunto2 = objConjuntosDifusos.muchoMayorQue(2, 5)
  val conjunto3 = objConjuntosDifusos.muchoMayorQue(3, 5)
  val conjunto4 = objConjuntosDifusos.muchoMayorQue(65, 500)
  val conjunto5 = objConjuntosDifusos.muchoMayorQue(800, 900)
  val conjuntoG = objConjuntosDifusos.grande(1, 2)
  val conjuntoG2 = objConjuntosDifusos.grande(2, 3)
  val complemento = objConjuntosDifusos.complemento(conjunto)
  val complemento2 = objConjuntosDifusos.complemento(conjunto2)
  val complemento3 = objConjuntosDifusos.complemento(conjunto3)
  val complemento4 = objConjuntosDifusos.complemento(conjunto4)


  test("Grado de pertenencia de 2 en el conjunto muchoMayorQue(1, 3)") {
    assert(conjunto(2) == 0.5) 
  }

  test("Grado de pertenencia de 1 en el conjunto muchoMayorQue(1, 3)") {
    assert(conjunto(1) == 0.0) 
  }

  test("Grado de pertenencia de 3 en el conjunto muchoMayorQue(1, 3)") {
    assert(conjunto(3) == 1.0) 
  }


  test("Grado de pertenencia de 0 en el conjunto grande(1, 2)") {
    assert(conjuntoG(0) == 0.0) 
  }

  test("Grado de pertenencia de 4 en el conjunto grande(1, 2)") {
    assert(conjuntoG(4) == 0.6400000000000001) 
  }

  test("Grado de pertenencia de 2 en grande(1, 2)") {
    assert(conjuntoG(2) == 0.4444444444444444)  
  }

  test("Grado de pertenencia de 2 en conjunto grande(2, 3)") {
    assert(conjuntoG2(2) == 0.125)
  }





  test("Complemento de 2 en muchoMayorQue(1, 3)") {
    assert(complemento(2) == 0.5) 
  }

  test("Complemento de 4 en muchoMayorQue(1, 3)") {
    assert(complemento(4) == 0.0)  
  }

  test("Complemento de 40 en muchoMayorQue(65, 500)") {
    assert(complemento4(40) == 1.0)  
  }

  test("Complemento de 95 en muchoMayorQue(65, 500)") {
    assert(complemento4(95) == 0.9310344827586207)  
  }

  test("Complemento de 6 en muchoMayorQue(2, 5)") {
    assert(complemento2(6) == 0.0)  
  }



  test("Unión de muchoMayorQue(3, 5) y muchoMayorQue(2, 5) en 4") {
    val union = objConjuntosDifusos.union(conjunto3, conjunto2)
    assert(union(4) == 0.6666666666666666) 
  }

  test("Unión de muchoMayorQue(65, 500) y muchoMayorQue(800, 900) en 1000") {
    val union = objConjuntosDifusos.union(conjunto4, conjunto5)
    assert(union(1000) == 1.0) 
  }

  test("Unión de muchoMayorQue(800, 900) y muchoMayorQue(800, 900) en 850") {
    val union = objConjuntosDifusos.union(conjunto5, conjunto5)
    assert(union(850) == 0.5)
  }

  test("Unión de muchoMayorQue(1, 3) y muchoMayorQue(2, 5) en 4") {
    val union = objConjuntosDifusos.union(conjunto, conjunto2)
    assert(union(4) == 1.0) 
  }

  test("Unión de muchoMayorQue(65, 500) y muchoMayorQue(800, 900) en 800") {
    val union = objConjuntosDifusos.union(conjunto4, conjunto5)
  assert(union(800) == 1.0) 
  }



  test("Intersección de muchoMayorQue(1, 3) y muchoMayorQue(2, 5) en 4") {
    val interseccion = objConjuntosDifusos.interseccion(conjunto, conjunto2)
    assert(interseccion(4) == 0.6666666666666666) 
  }

  test("Intersección de muchoMayorQue(1, 3) y muchoMayorQue(2, 5) en 2") {
    val interseccion = objConjuntosDifusos.interseccion(conjunto, conjunto2)
  assert(interseccion(2) == 0)
  }

  test("Intersección de muchoMayorQue(1, 3) y muchoMayorQue(2, 5) en 5") {
    val interseccion = objConjuntosDifusos.interseccion(conjunto, conjunto2)
  assert(interseccion(5) == 1.0)
  }

  test("Intersección de muchoMayorQue(65, 500) y muchoMayorQue(800, 900) en 40") {
    val interseccion = objConjuntosDifusos.interseccion(conjunto, conjunto5)
  assert(interseccion(40) == 0)
  }

  test("Intersección de dos conjuntos muchoMayorQue(1, 3) iguales en 2") {
    val interseccion = objConjuntosDifusos.interseccion(conjunto, conjunto)
  assert(interseccion(2) == 0.5)
  }



  test("Inclusión de conjunto3 en el conjunto 2") {
    assert(objConjuntosDifusos.inclusion(conjunto3, conjunto2)) 
  }

  test("Inclusión de conjunto2 en el conjunto3") {
    assert(!objConjuntosDifusos.inclusion(conjunto2, conjunto3)) 
  }

  test("Inclusión en un conjunto en el que ambos son iguales") {
    assert(objConjuntosDifusos.inclusion(conjunto, conjunto)) 
  }

  test("Inclusión de conjunto4 en el conjunto5, ambos son mayores a 200") {
    assert(!objConjuntosDifusos.inclusion(conjunto4, conjunto5)) 
  }

  test("Inclusión de g1 en g2 donde g1 y g2 son grandes") {
    assert(!objConjuntosDifusos.inclusion(conjuntoG, conjuntoG2)) 
  }




  test("Igualdad de conjunto2 con el conjunto3") {
    assert(!objConjuntosDifusos.igualdad(conjunto2, conjunto3)) 
  }

  test("Igualdad de g1 con un conjunto igual de grande") {
    assert(objConjuntosDifusos.igualdad(conjuntoG, conjuntoG)) 
  }

  test("Igualdad de g1 y g2 donde g1 y g2 son grandes") {
    assert(!objConjuntosDifusos.igualdad(conjuntoG, conjuntoG2)) 
  }

  test("Igualdad de conjunto4 un conjunto de más de 100 y el conjunto3") {
    assert(!objConjuntosDifusos.igualdad(conjunto4, conjunto3)) 
  }

  test("Igualdad del conjunto3 con uno igual a si mismo") {
    assert(objConjuntosDifusos.igualdad(conjunto3, conjunto3)) 
  }
}