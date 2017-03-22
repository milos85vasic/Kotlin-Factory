package net.milosvasic.factory.kotlin

import net.milosvasic.factory.kotlin.content.Messages
import net.milosvasic.factory.utils.Text
import net.milosvasic.logger.ConsoleLogger
import java.io.File

fun main(args: Array<String>) {

    val logger = ConsoleLogger()
    val tag = "kotlin factory"
    val name = Text.splitCamelCase(BuildConfig.NAME)
    val version = BuildConfig.VERSION.replace("_", " ")

    logger.c(tag, "$name $version is running.")
    if (args.isEmpty()) {
        logger.e(tag, Messages.INVALID_ARGUMENTS)
        return
    }

    val jsonPath = File(args[0])
    if(!jsonPath.exists()){
        logger.e(tag, Messages.FILE_DOES_NOT_EXIST(jsonPath))
        return
    }

    val factory = KotlinProjectFactory()

//    val project = Project(projectName)
//    for (moduleName in moduleNames) {
//        project.modules.add(Module(moduleName))
//    }
//    try {
//        factory.create(project, getHome())
//        logger.c(tag, Messages.PROJECT_CREATED)
//    } catch (e: Exception) {
//        logger.e(tag, "${e.message}")
//    }

}