package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class PrintFlagTest extends AnyFlatSpec {
  "Print flag" should "return message in uppercase" in {
    val printFlagTest = new PrintFlag()

    val resultString = printFlagTest.printFlag("Welcome")

    assert(resultString == "WELCOME")
  }
}
