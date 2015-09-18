/* 
* Trabalho 1
* Aluno:Wdnei Ribeiro da Paixao
* 
*/
package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {

  import Main.countChange

  test("countChange: exemplo dado nas instruções") {
    assert(countChange(4,List(1,2)) === 3)
  }

  // ==================================================================
  // Escreva mais testes.
  // ==================================================================

  test("countChange: QUando o valor de dinheiro for 0") {
    assert(countChange(0,List(1,2)) === 1)
  }


  test("countChange: Quando a lista de moedas for vazia ") {
    assert(countChange(10,List()) === 0)
  }

  test("countChange: Quando o valor do dinheiro for 'zero' e a lista de moedas for vazia ") {
    assert(countChange(0,List()) === 1)
  }

  test("countChange: Quando a lista de moedas for (1)") {
    assert(countChange(10,List(1)) === 1)
  }

  test("countChange: Quando a lista de moedas for (1,1) com numero repetidos") {
    assert(countChange(10,List(1,1)) === 1)
  }


  test("countChange: Quando o valor do dinheiro for '10' e a lista de moedas for (1,2) ") {
    assert(countChange(10,List(1,2)) === 6)
  }


  test("countChange: Quando o valor do dinheiro for '10' e a lista de moedas for (11) maior que o dinheiro ")   {
    assert(countChange(10,List(11)) === 0)
  }


  test("countChange: Quando o valor do dinheiro for '10' e a lista de moedas for (1,2,11) ") {
    assert(countChange(10,List(1,2)) === 6)
  }






}
