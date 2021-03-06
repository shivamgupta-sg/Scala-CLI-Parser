package com.knoldus

object MainEntryPoint extends App {
  val resultMap = (new CLIParser).parser(args)

  for (key <- resultMap.keys) key match {
    case "version" => println(resultMap(key))
    case "print" => println(resultMap(key))
    case "help" => println(resultMap(key))
    case _ => throw new Exception("Wrong Arguments")
  }
}
