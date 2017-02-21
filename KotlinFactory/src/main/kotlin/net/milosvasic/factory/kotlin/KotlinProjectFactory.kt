package net.milosvasic.factory.kotlin

import net.milosvasic.factory.kotlin.content.Messages
import net.milosvasic.factory.project.Project
import net.milosvasic.factory.project.ProjectFactory
import java.io.File

class KotlinProjectFactory : ProjectFactory() {

    override fun create(project: Project, destination: File) {
        if (destination.exists()) throw IllegalStateException(
                "${Messages.PROJECT_ALREADY_EXIST}: ${destination.absolutePath}"
        )
        if (destination.mkdirs()) {

        }
    }

}