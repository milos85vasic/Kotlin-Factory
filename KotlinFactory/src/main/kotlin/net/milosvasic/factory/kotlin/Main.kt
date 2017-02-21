package net.milosvasic.factory.kotlin

import net.milosvasic.factory.Version
import net.milosvasic.factory.kotlin.content.Flags
import net.milosvasic.factory.kotlin.content.Messages
import net.milosvasic.logger.ConsoleLogger

private class KotlinFactory

fun main(args: Array<String>) {

    val version = Version()
    val logger = ConsoleLogger()
    val tag = KotlinFactory::class

    logger.c(tag, "Kotlin Factory ${version.VERSION.replace("_", " ")} is running.")
    if (args.size < 2) {
        logger.e(tag, Messages.INVALID_ARGUMENTS)
        return
    }

    val projectName = args[0]
    val moduleNames = mutableListOf<String>()
    if (args[1].startsWith(Flags.MODULES)) {
        val modules = args[1].replace(Flags.MODULES, "").split(",")
        modules.mapTo(moduleNames) { it.trim() }
    } else {
        logger.e(tag, Messages.INVALID_ARGUMENTS)
        return
    }

    var message = "We are about to create project [ $projectName ]\nModules:"
    for (module in moduleNames) {
        message += "\n[ $module ]"
    }
    logger.v(tag, message)

}