package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable

class HelpFlagTest extends AnyFlatSpec {
  "Help Map" should "be this" in {
    val helpFlagTest = new HelpFlag()

    val expectedMap = mutable.HashMap("help" ->
      "Usage: cliparser options [message]\n -v => show the version of program \n -h => help \n -p => print the message ")

    val resultMap = helpFlagTest.helpFlag()

    assert(resultMap == expectedMap("help"))
  }
}
