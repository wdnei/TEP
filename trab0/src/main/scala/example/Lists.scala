package example

import common._

object Lists {
  /**
    * Este método computa a soma de todos os elementos na lista
    * xs. Existem várias técnicas que podem ser utilizadas para
    * implementar este método, e você vai aprender algumas delas
    * durante a disciplina.
    *
    * Para este projeto de programação de exemplo, você pode utilizar
    * os seguintes métodos da classe `List`:
    * - `xs.isEmpty: Boolean` retorna `true` se a lista `xs` for vazia;
    * - `xs.head: Int` retorna a cabeça (primeiro elemento) da lsita
    *   `xs`. Se a lista for fazia é disparada uma exceção.
    * - `xs.tail: List[Int]` retorna a calda da lista `xs`, i.e., a
    *   lista `xs` sem o elemento da cabeça.
    *
    * ''Dica:'' Ao invés de tentar escrever um `for` ou `while`, pense
    * em uma solução recursiva.
    *
    * @param xs Uma lista de número inteiros
    * @return A soma de todos os elementos em `xs`
    */
  def sum(xs: List[Int]): Int =  if(xs.isEmpty) 0 else xs.head+sum(xs.tail)

  /**
    * Este método retorna o maior elemento em uma lista de
    * inteiros. Se a lista `xs` for vazia, é disparada uma exceção
    * `fava.util.NoSuchElementException`.
    *
    * Você pode utilizar os mesmos métodos da classe `List`
    * mencionados acima.
    *
    * ''Dica:'' Novamente, pense em uma solução recurciva ao invés de
    * utilizar laços. Pode ser que você precise definir uma função
    * auxiliar.
    *
    * @param xs Uma lista de números inteiros
    * @return O maior elemento em `xs`
    * @throws java.util.NoSuchElementException Se `xs` for uma lista vazia
    */

  	
  
  def max(xs: List[Int]): Int = {
	def maxIter(xs:List[Int],maior:Int):Int={ 
		if(xs.isEmpty){ maior; }
		else {
			if(maior>xs.head) 
				maxIter(xs.tail,maior); 
			else maxIter(xs.tail,xs.head); 
		}
  	} 
	if(xs.isEmpty) throw new NoSuchElementException("list is empty"); 
	else maxIter(xs.tail,xs.head);
 }     
}
