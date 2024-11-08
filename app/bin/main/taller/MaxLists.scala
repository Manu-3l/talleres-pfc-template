package taller

import scala.annotation.tailrec

class maxLists(){
    def maxLin (l: List [Int]): Int = {
        if(l.isEmpty) 0
        else if(l.head > maxLin(l.tail)) l.head 
        else maxLin(l.tail)
    }


    
    def maxIt (l: List [Int] ) : Int = {
        @tailrec
        def maxItAux (l: List [Int] , max: Int ) :Int = {
            if (l.isEmpty) max
            else {
                  val newMax = if (l.head > max) l.head 
                  else max
                  maxItAux(l.tail, newMax)  
                }
        }
        if(l.isEmpty) 0
        else maxItAux(l, l.head)
    }
    

}