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
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (r <= 0) 
      if (c <= 0) 1
      else 0
    else if (c <= 0) pascal(c, r-1);      
      else pascal(c, r-1) + pascal(c-1, r-1);
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    if (chars.isEmpty) true
    
    var num = 0
    for (i <- 0 until chars.length) {
      if (chars(i) == '(') num += 1
      if (chars(i) == ')') {
        num -= 1
        if (num < 0) return false
      }
    }
    num == 0
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0) 0
    else if (money == 0) 1
    else if (coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
