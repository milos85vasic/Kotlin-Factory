package net.milosvasic.factory.project

import net.milosvasic.factory.content.Messages
import java.io.File

abstract class ProjectFactory {

    fun create(project: Project, destination: File) {
        if (destination.exists()) throw IllegalStateException(
                "${Messages.PROJECT_ALREADY_EXIST}: ${destination.absolutePath}"
        )
        if (destination.mkdirs()) {

        }
    }

}