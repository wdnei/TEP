/* 
* Trabalho 1
* Aluno:Wdnei Ribeiro da Paixao
* 
*/
package recfun
import common._

object Main {

  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercício 1
   */
  def pascal(c: Int, r: Int): Int = {
	require(c>=0 && r>=0 && c<=r,"Linha ou Coluna inexistente");
        	
	def pascalIter(c: Int, r: Int): Int={
			
		if (c == 0) {
		   1;
	       } else if (c == r) {
		   1;
	       } else {
		   pascalIter(c - 1, r - 1) + pascalIter(c, r-1);
	       }
	}

	
	pascalIter(c,r);

  }

  /**
   * Exercício 2
   */
  def balance(chars: List[Char]): Boolean = {
	def balanceIter(chars: List[Char],count:Int):Boolean={
				
		if(chars.isEmpty || count<0)
			count==0
		else{
			def c:Char=chars.head;
			if(c =='(')
				balanceIter(chars.tail,count+1);
			else if(c==')')
				balanceIter(chars.tail,count-1);
			else balanceIter(chars.tail,count);			
		}
			
	}
	
	balanceIter(chars,0);

  }

  /**
   * Exercício 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
	
	def countChangeIter(money: Int, coins: List[Int]): Int = {
                if(money == 0) 
                  1
                else if(money < 0) 
                  0
                else if(coins.isEmpty && money>=1 )
                  0
                else
                  countChangeIter(money, coins.tail) + countChangeIter(money - coins.head, coins)
	}

    countChangeIter(money, coins.sortWith(_.compareTo(_) < 0))
  
  }
}
