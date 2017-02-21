package net.milosvasic.factory.project

import java.io.File

abstract class ProjectFactory {

    abstract fun create(project: Project, destination: File)

}