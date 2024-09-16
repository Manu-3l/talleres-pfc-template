package taller

class TorresHanoi(n : Int){
    def movsTorresHanoi ( n : Int ) : BigInt = {
        if (n == 1) BigInt(1)
        else 2 * movsTorresHanoi(n - 1) + 1
    }

    def torresHanoi ( n : Int , t1 : Int , t2 : Int , t3 : Int) : List [(Int , Int)] = {
        if (n == 1) {
            List((t1, t3))
        } else {
            // Mover los n-1 discos de t1 a t2 usando t3 como auxiliar
            val movimiento1 = torresHanoi(n - 1, t1, t3, t2)
            // Mover el disco n de t1 a t3
            val movimiento2 = List((t1, t3))
            // Mover los n-1 discos de t2 a t3 usando t1 como auxiliar
            val movimiento3 = torresHanoi(n - 1, t2, t1, t3)
            movimiento1 ++ movimiento2 ++ movimiento3
        }
    }
}