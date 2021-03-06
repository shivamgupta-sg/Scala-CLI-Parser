package com.knoldus

import scala.collection.mutable

class CLIParser {
  def parser(args: Array[String]): mutable.HashMap[String, String] = {
    if (args.length == 0)
      return mutable.HashMap("help" -> (new HelpFlag).helpFlag())
    else if (args.length > 2)
      return mutable.HashMap("help" -> (new HelpFlag).helpFlag())
    else if ((args(0) startsWith "-") && (args.length == 2)) {
      if (args(1) startsWith "-")
        return mutable.HashMap("help" -> (new HelpFlag).helpFlag())
    }

    for (arg <- args.indices if args(arg) startsWith "-") {
      args(arg) match {
        case "-p" | "--print" => return mutable.HashMap("print" -> (new PrintFlag).printFlag(if (arg == 0) args(arg + 1) else args(arg - 1)))

        case "-v" | "--version" => return mutable.HashMap("version" -> (new VersionFlag).versionFlag())

        case "-h" | "--help" => return mutable.HashMap("help" -> (new HelpFlag).helpFlag())

        case _ => return mutable.HashMap("help" -> (new HelpFlag).helpFlag())
        //            chf030555
      }
    }
    mutable.HashMap("help" -> (new HelpFlag).helpFlag())
  }
}
