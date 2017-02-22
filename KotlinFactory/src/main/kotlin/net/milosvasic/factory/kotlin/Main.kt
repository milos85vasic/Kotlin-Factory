package net.milosvasic.factory.kotlin

import net.milosvasic.factory.kotlin.content.Flags
import net.milosvasic.factory.kotlin.content.Labels
import net.milosvasic.factory.kotlin.content.Messages
import net.milosvasic.factory.project.Project
import net.milosvasic.logger.ConsoleLogger
import java.io.File

private class KotlinFactory

fun main(args: Array<String>) {

    val logger = ConsoleLogger()
    val tag = KotlinFactory::class
    val factory = KotlinProjectFactory()

    fun getHome(): File {
        val home = System.getProperty("user.home")
        val root = File("$home${File.separator}${Labels.HOME_FOLDER}")
        if (!root.exists()) {
            root.mkdirs()
        }
        return root
    }

    logger.c(tag, "${BuildConfig.NAME} ${BuildConfig.VERSION.replace("_", " ")} is running.")
    if (args.size < 2) {
        logger.e(tag, Messages.INVALID_ARGUMENTS)
        return
    }

    val projectName = args[0]
    val moduleNames = mutableListOf<String>()
    if (args[1].startsWith(Flags.MODULES)) {
        val modules = args[1].replace(Flags.MODULES, "").split(",")
        modules.mapTo(moduleNames, String::trim)
    } else {
        logger.e(tag, Messages.INVALID_ARGUMENTS)
        return
    }

    var message = "${Messages.PROJECT_CREATE} [ $projectName ]\n${Labels.MODULES}:"
    for (module in moduleNames) {
        message += "\n[ $module ]"
    }
    logger.v(tag, message)

    val project = Project(projectName)
    try {
        factory.create(project, getHome())
        logger.c(tag, Messages.PROJECT_CREATED)
    } catch (e: Exception) {
        logger.e(tag, "${e.message}")
    }

}