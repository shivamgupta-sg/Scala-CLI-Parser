package com.knoldus

class HelpFlag {
  def helpFlag() = {
    val flagsMap = Map("-v" -> "show the version of program", "-h" -> "help", "-p" -> "print the message")
    (flagsMap.map { case (k, v) => s" $k => $v " }).mkString("Usage scala [flag]\n", "\n", "")
  }
}
