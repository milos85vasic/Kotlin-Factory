package net.milosvasic.factory.kotlin.content

import java.io.File

object Messages {

    val PROJECT_CREATED = "Project created."
    val INVALID_ARGUMENTS = "Invalid arguments."
    val PROJECT_CREATE = "We are about to create project"

    fun FILE_DOES_NOT_EXIST(file: File) = "File does not exist: ${file.absolutePath}"

    fun PROJECT_CREATION_RESULT(success: Boolean): String {
        var successVal = Labels.SUCCESS.toUpperCase()
        if(!success){
            successVal = Labels.FAILURE.toUpperCase()
        }
        return "Project creation [ $successVal ]"
    }

}