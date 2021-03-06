package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

import scala.collection.mutable

class CLIParserTest extends AnyFlatSpec {
  val cliParserTest = new CLIParser()

  "-p flag" should "return Welcome in uppercase" in {
    val args = Array("-p", "Welcome")

    val expectedMap = mutable.HashMap("print" -> "WELCOME")
    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }

  "--print flag" should "return Welcome in uppercase" in {
    val args = Array("--print", "Welcome")

    val expectedMap = mutable.HashMap("print" -> "WELCOME")
    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }


  "-h flag" should "return description of all the flags" in {
    val args = Array("-h")

    val expectedMap = mutable.HashMap("help" ->
      "Usage: cliparser options [message]\n -v => show the version of program \n -h => help \n -p => print the message ")

    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }

  "--help flag" should "return description of all the flags" in {
    val args = Array("--help")

    val flagsMap = Map("-v" -> "show the version of program", "-h" -> "help", "-p" -> "print the message")

    val resultMap = cliParserTest.parser(args)

    assert(resultMap == mutable.HashMap("help" -> flagsMap.map { case (k, v) => s" $k => $v " }.mkString("Usage: cliparser options [message]\n", "\n", "")))
  }


  "-v flag" should "return version of parser" in {
    val args = Array("-v")
    val expectedMap = mutable.HashMap("version" -> "Version : 0.1")
    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }

  "--version flag" should "return version of parser" in {
    val args = Array("--version")
    val expectedMap = mutable.HashMap("version" -> "Version : 0.1")
    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }


  "no arguments" should "return description of all flags" in {
    val args = Array("")

    val flagsMap = Map("-v" -> "show the version of program", "-h" -> "help", "-p" -> "print the message")

    val resultMap = cliParserTest.parser(args)

    assert(resultMap == mutable.HashMap("help" -> flagsMap.map { case (k, v) => s" $k => $v " }.mkString("Usage: cliparser options [message]\n", "\n", "")))
  }


  "Two flags" should "return description of all flags" in {
    val args = Array("-p", "-v")

    val flagsMap = Map("-v" -> "show the version of program", "-h" -> "help", "-p" -> "print the message")

    val resultMap = cliParserTest.parser(args)

    assert(resultMap == mutable.HashMap("help" -> flagsMap.map { case (k, v) => s" $k => $v " }.mkString("Usage: cliparser options [message]\n", "\n", "")))
  }


  "first the value to print and then -p flag" should "return the value in Uppercase" in {
    val args = Array("Welcome", "-p")
    val expectedMap = mutable.HashMap("print" -> "WELCOME")
    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }

  "first the value to print and then --print flag" should "return the value in Uppercase" in {
    val args = Array("Welcome", "--print")
    val expectedMap = mutable.HashMap("print" -> "WELCOME")
    val resultMap = cliParserTest.parser(args)

    assert(resultMap == expectedMap)
  }

  "more than 2 arguments" should "return description of all flags" in {
    val args = Array("-p", "Welcome", "-v")
    val flagsMap = Map("-v" -> "show the version of program", "-h" -> "help", "-p" -> "print the message")

    val resultMap = cliParserTest.parser(args)

    assert(resultMap == mutable.HashMap("help" -> flagsMap.map { case (k, v) => s" $k => $v " }.mkString("Usage: cliparser options [message]\n", "\n", "")))
  }
}
