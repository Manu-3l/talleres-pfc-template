package taller

import org.scalatest.funsuite.AnyFunSuite
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MovsTorreHanoiTest extends AnyFunSuite {
    val torresHanoi = new TorresHanoi(3)

    test("Número de movimientos para 3 discos") {
        assert(torresHanoi.movsTorresHanoi(3) == 7)
    }

    test("Número de movimientos para 4 discos") {
        assert(torresHanoi.movsTorresHanoi(4) == 15)  // 2^4 - 1 = 15 movimientos
    }

    test("Número de movimientos para 6 discos") {
        assert(torresHanoi.movsTorresHanoi(6) == 63)  // 2^4 - 1 = 15 movimientos
    }

    test("Número de movimientos para 8 discos") {
        assert(torresHanoi.movsTorresHanoi(8) == 255)
    }

    test("Número de movimientos para 64 discos") {
        assert(torresHanoi.movsTorresHanoi(64) == BigInt("18446744073709551615"))  // 2^64 - 1 movimientos
    }
}