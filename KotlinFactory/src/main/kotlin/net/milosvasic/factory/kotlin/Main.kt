package net.milosvasic.factory.kotlin

import net.milosvasic.factory.Version
import net.milosvasic.logger.ConsoleLogger

private class KotlinFactory

fun main(args: Array<String>) {

    val version = Version()
    val logger = ConsoleLogger()
    val tag = KotlinFactory::class

    logger.c(tag, "Kotlin Factory ${version.VERSION.replace("_", " ")} is running.")

}