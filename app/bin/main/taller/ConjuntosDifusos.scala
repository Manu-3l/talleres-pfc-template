package taller

class ConjuntosDifusos {
  type ConjDifuso = Int => Double

  def pertenece(elem: Int, s: ConjDifuso): Double = s(elem)

  def muchoMayorQue(a: Int, m: Int): ConjDifuso = {
    x => if (x <= a) 0.0
         else if (x > a && x <= m) (x - a).toDouble / (m - a).toDouble
         else 1.0
  }

  def grande(d: Int, e: Int): ConjDifuso = n => Math.pow(n.toDouble / (n + d), e)

  def complemento(c: ConjDifuso): ConjDifuso = n => 1.0 - pertenece(n, c)

  def union(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = n =>
    Math.max(pertenece(n, cd1), pertenece(n, cd2))

    
  def interseccion(cd1: ConjDifuso, cd2: ConjDifuso): ConjDifuso = n =>
    Math.min(pertenece(n, cd1), pertenece(n, cd2))

  def inclusion(S1: ConjDifuso, S2: ConjDifuso): Boolean = {
    @annotation.tailrec
    def aux(n: Int, max: Int): Boolean = {
      if (n > max) true
      else if (pertenece(n, S1) > pertenece(n, S2)) false
      else aux(n + 1, max)
    }
    aux(0, 1000)
  }

  def igualdad(S1: ConjDifuso, S2: ConjDifuso): Boolean =
    inclusion(S1, S2) && inclusion(S2, S1)
}
