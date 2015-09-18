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
class BalanceSuite extends FunSuite {
  import Main.balance

  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  // ==================================================================
  // Escreva mais testes.
  // ==================================================================

  test("balance: '(' is not balanced") {
    assert(!balance("(".toList))
  }


  test("balance: ')' is not balanced") {
    assert(!balance(")".toList))
  }


  test("balance: '()' is balanced") {
    assert(balance("()".toList))
  }


  test("balance: ')(' is not balanced") {
    assert(!balance(")(".toList))
  }


  test("balance: ':-)' is not balanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: '())(' is not balanced") {
    assert(!balance("())(".toList))
  }

  test("balance: 'Eu disse a ele (isso (ainda) não acabou). (Mas ele não escutou)' is balanced") {
    assert(balance("Eu disse a ele (isso (ainda) não acabou). (Mas ele não escutou)".toList))
  }
}
