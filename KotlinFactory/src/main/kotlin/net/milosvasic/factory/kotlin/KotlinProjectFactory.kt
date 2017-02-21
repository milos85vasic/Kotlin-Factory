package net.milosvasic.factory.kotlin

import net.milosvasic.factory.project.Project
import net.milosvasic.factory.project.ProjectFactory
import java.io.File

class KotlinProjectFactory : ProjectFactory() {

    override fun create(project: Project, destination: File) {
        if (destination.exists() || destination.mkdirs()) {

        }
    }

}