/* 
* Trabalho 2
* Aluno:Wdnei Ribeiro da Paixao
* 
*/

package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/** Esta classe implementa um conjunto de testes para os métodos do
  * objeto FunSets. Para executar este conjunto de testes você deve
  * executar o comando `test` no console do SBT.
  */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /** Link para o scaladoc - um tutorial bastante detalhado e claro
    * sobre FunSuite (em inglês).
    *
    * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
    *
    * Veja os operadores:
    * - test
    * - ignore
    * - pending
    *
    * Consulte também o exemplo de testes dado no Trabalho 0.
    */

  import FunSets._

  test("contains foi implementado") {
    assert(contains(x => true, 100)) // Você sabe que conjunto é
                                     // definido por `x => true`?
  }

  /** Ao escrever testes é muito comum querer reusar certos valores para
    * múltiplos testes. Por exemplo, pode-se querer criar um IntSet e
    * fazer vários testes como ele.
    *
    * Ao invés de copiar e colar o código para criar os valores em
    * cada testes, pode-se armazenar os valores na classe de testes
    * usando definições `val`:
    *
    * val s1 = singletonSet(1)
    *
    * Entretanto, o que acontece se o método `singletonSet` tiver um
    * erro (bug) e abortar? Nesse caso os testes não serão nem
    * executados, porque a criação dos valores irá falha!
    *
    * Assim, é melhor colocar a criação dos valores para testes dentro
    * de um `trait` separado e criar uma instância do `trait` em cada
    * teste. Há um exemplo abaixo de como fazer isso.
    */

  trait TestSets {
	val s1 = singletonSet(1)
	val s2 = singletonSet(2)
	val s3 = singletonSet(3)
	val s1_10:Set=(x:Int)=>x>=1&&x<=10
	val s5_8:Set=(x:Int)=>x>=5&&x<=8
	val s5_15:Set=(x:Int)=>x>=5&&x<=15
    val s_n10_10:Set=x=>x>=(-10) && x<=10;
  }

  /** Este teste está desabilitado (usando a função `ignore`) porque o
    * método `singletonSet` ainda não foi implementado e o teste iria
    * falhar.
    *
    * Quando você terminar de implementar o `singletonSet`, troque a
    * função `ignore` por `test` para executar o teste.
    */
  test("singletonSet(1) contains 1") {

    /** Ao criar uma nova instância do trait `TestSets`, ganha-se acesso
      * ao valores `s1`, `s2` e `s3` que podem ser usados no teste.
      */
    new TestSets {
      assert(contains(s1, 1), "Singleton(1)")
      assert(contains(s2, 2), "Singleton(2)")
      assert(contains(s3, 3), "Singleton(3)")
    }


  }

  // Escreva o restante dos testes.

    test("contains 1>=x<=10") {
        new TestSets {
            assert(contains(s1_10, 1), "contains 1")
            assert(contains(s1_10, 10), "contains 10")
            assert(contains(s1_10, 5), "contains 5")
            assert(!contains(s1_10, 11), "not contains 11")
            assert(!contains(s1_10, 0), "not contains 0")
            
        }
	}

    test("union 1>=x<=10 && 5>=x<=15 == 1>=x<=15 ") {
        new TestSets {
            val s1_15:Set=union(s1_10,s5_15)
            assert(contains(s1_15, 1), "contains 1")
            assert(contains(s1_15, 10), "contains 10")
            assert(contains(s1_15, 5), "contains 5")
            assert(contains(s1_15, 11), "contains 11")
            assert(contains(s1_15, 15), "contains 15")
            assert(contains(s1_15, 12), "contains 12")
            assert(!contains(s1_15, 0), "not contains 0")
            assert(!contains(s1_15, 16), "not contains 16")
            
        }
	}


    test("intersect 1>=x<=10 && 5>=x<=15 == 5>=x<=10 ") {
        new TestSets {
            val s5_10:Set=intersect(s1_10,s5_15)
            assert(!contains(s5_10, 1), "not contains 1")
            assert(contains(s5_10, 10), "contains 10")
            assert(contains(s5_10, 5), "contains 5")
            assert(!contains(s5_10, 11), "not contains 11")
            assert(!contains(s5_10, 15), "not contains 15")
            assert(!contains(s5_10, 12), "not contains 12")
            assert(!contains(s5_10, 0), "not contains 0")
            assert(!contains(s5_10, 16), "not contains 16")
            
        }
	}

    test("diff 1>=x<=10 && 5>=x<=15 == 1>=x<=4 ") {
        new TestSets {
            val s1_4:Set=diff(s1_10,s5_15)
            assert(contains(s1_4, 1), "contains 1")
            assert(contains(s1_4, 4), "contains 4")
            assert(!contains(s1_4, 10), "not contains 10")
            assert(!contains(s1_4, 5), "not contains 5")
            assert(!contains(s1_4, 11), "not contains 11")
            assert(!contains(s1_4, 15), "not contains 15")
            assert(!contains(s1_4, 12), "not contains 12")
            assert(!contains(s1_4, 0), "not contains 0")
            assert(!contains(s1_4, 16), "not contains 16")
            
        }
	}


    test("filter 1>=x<=10 with x>=5 == 5>=x<=10 ") {
        new TestSets {
            val s5_10:Set=filter(s1_10,x=>x>=5)
            assert(!contains(s5_10, 1), "not contains 1")
            assert(!contains(s5_10, 4), "not contains 4")
            assert(contains(s5_10, 10), "not contains 10")
            assert(contains(s5_10, 5), "contains 5")
            assert(!contains(s5_10, 11), "not contains 11")
            assert(!contains(s5_10, 15), "not contains 15")
            assert(!contains(s5_10, 12), "not contains 12")
            assert(!contains(s5_10, 0), "not contains 0")
            assert(!contains(s5_10, 16), "not contains 16")
            
        }
	}

    test("forall -10>=x<=10") {
        new TestSets {
            
            assert(!forall(s_n10_10, x=>x>5), "x>5 == false")
            assert(forall(s_n10_10, x=>x>=(-5) && x<=5), "-5>x<5 == true")
            assert(!forall(s_n10_10, x=>x<(-5)), "x<-5 == false")
            assert(forall(s_n10_10, x=>x==(-10)), "x=-10 == true")
            assert(forall(s_n10_10, x=>x==10), "x=10 == true")
            assert(forall(s_n10_10, x=>x==0), "x=0 == true")
            assert(!forall(s_n10_10, x=>x==11), "x=11 == false")
            assert(!forall(s_n10_10, x=>x==(-11)), "x=-11 == false")
            assert(forall(s_n10_10, x=>x>(-10) && x<10), "-10>x<10 == true")
            
        }
	}

    test("exists -10>=x<=10") {
        new TestSets {
            
            assert(exists(s_n10_10, x=>x>5), "x>5 == true")
            assert(exists(s_n10_10, x=>x>(-5) && x<5), "-5>x<5 == true")
            assert(exists(s_n10_10, x=>x<(-5)), "x<-5 == true")
            assert(exists(s_n10_10, x=>x==(-10)), "x=-10 == true")
            assert(exists(s_n10_10, x=>x==10), "x=10 == true")
            assert(exists(s_n10_10, x=>x==0), "x=0 == true")
            assert(exists(s_n10_10, x=>x>(-10) && x<10), "-10>x<10 == true")
            assert(!exists(s_n10_10, x=>x==(-11)), "x=-11 == false")
            assert(!exists(s_n10_10, x=>x==11), "x=11 == false")
            assert(!exists(s_n10_10, x=>x>11), "x>11 == false")

            
        }
	}

    test("map -10>=x<=10 with x=>x*2 ") {
        new TestSets {
            val s_n20_20=map(s_n10_10,x=>x*2) //conjunto dos numeros muliplos de 2 entre -20 e 20
            assert(contains(s_n20_20, 0), "contains 0")
            assert(contains(s_n20_20, 2), "contains 2")
            assert(contains(s_n20_20, (-10)), "contains -10")
            assert(contains(s_n20_20, 10), "contains 10")
            assert(!contains(s_n20_20, -(15)), "not contains -15")
            assert(!contains(s_n20_20, 15), "not contains 15")
            assert(contains(s_n20_20, (-20)), "contains -20")
            assert(contains(s_n20_20, 20), "contains 20")
            assert(!contains(s_n20_20, (-21)), "not contains -21")
            assert(!contains(s_n20_20, 21), "not contains 21")
        }
	}




}
