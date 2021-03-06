package com.knoldus

import org.scalatest.flatspec.AnyFlatSpec

class VersionFlagTest extends AnyFlatSpec {
  "version" should "0.1" in {
    val versionFlagTest = new VersionFlag()
    assert(versionFlagTest.versionFlag() == "Version : 0.1")
  }
}
