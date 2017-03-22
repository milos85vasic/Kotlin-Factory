package net.milosvasic.factory.kotlin

import net.milosvasic.factory.kotlin.content.Messages
import net.milosvasic.factory.kotlin.content.Labels
import net.milosvasic.factory.utils.Text
import net.milosvasic.logger.SimpleLogger
import java.io.File

fun main(args: Array<String>) {

    val logger = SimpleLogger()
    val tag = "kotlin factory"
    val name = Text.splitCamelCase(BuildConfig.NAME)
    val version = BuildConfig.VERSION.replace("_", " ")

    logger.c(tag, "$name $version is running.")
    if (args.isEmpty()) {
        logger.e(tag, Messages.INVALID_ARGUMENTS)
        return
    }

    val jsonPath = File(args[0])
    if (!jsonPath.exists()) {
        logger.e(tag, Messages.FILE_DOES_NOT_EXIST(jsonPath))
        return
    }

    var result = false
    try {
        result = KotlinProjectFactory(Labels.WORKING_FOLDER_NAME).create(jsonPath)
    } catch (e: Exception) {
        logger.e(tag, "${Labels.ERROR.toUpperCase()} [ ${e.message} ]")
    }
    if (result) {
        logger.i(tag, Messages.PROJECT_CREATION_RESULT(result))
    } else {
        logger.e(tag, Messages.PROJECT_CREATION_RESULT(result))
    }

}