/* 
* Trabalho 2
* Aluno:Wdnei Ribeiro da Paixao
* 
*/
package funsets

/* Tente melhorar o programa principal.
 */
object Main extends App {
    import FunSets._
    val s1=singletonSet(1)
    val s2=singletonSet(2)
    val s3=singletonSet(2)
    val s1_2=union(s1,s2)
    println(contains(s1, 1))
    println(contains(s1, 2))
    println(contains(s2, 1))
    println(contains(s2, 2))
    println(contains(union(s1,s2), 1))
    println(contains(union(s1,s2), 2))
    println(contains(union(s1,s2), 3))
    println(contains(intersect(s1,s1_2), 1))
    println(contains(intersect(s1,s1_2), 2))
    println(contains(filter(s1,x=>x>1), 1))
    
}
