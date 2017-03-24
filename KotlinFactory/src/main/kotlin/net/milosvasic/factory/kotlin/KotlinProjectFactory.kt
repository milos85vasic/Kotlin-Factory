package net.milosvasic.factory.kotlin

import net.milosvasic.factory.dependency.Classpath
import net.milosvasic.factory.dependency.Dependency
import net.milosvasic.factory.module.Module
import net.milosvasic.factory.project.Project
import net.milosvasic.factory.project.ProjectFactory
import java.io.File

class KotlinProjectFactory(override val workingFolderName: String) : ProjectFactory() {

    override fun getClasspath(project: Project): Classpath {
        val classpath = Classpath()
        val gradlePlugin = Dependency(
                "org.jetbrains.kotlin",
                "kotlin-gradle-plugin",
                project.language.version
        )
        val kotlinReflect = Dependency(
                "org.jetbrains.kotlin",
                "kotlin-reflect",
                project.language.version
        )
        classpath.dependencies.add(gradlePlugin)
        classpath.dependencies.add(kotlinReflect)
        return classpath
    }

    override fun getModuleNonJavaDirectories(module: Module, root: File): List<File> {
        val name = module.name.replace(" ", "_")
        val localFile = File("${root.absolutePath}${File.separator}$name${File.separator}src")
        val main = File("${localFile.absolutePath}${File.separator}main")
        val test = File("${localFile.absolutePath}${File.separator}test")
        val mainKotlin = File("${main.absolutePath}${File.separator}kotlin")
        val testKotlin = File("${test.absolutePath}${File.separator}kotlin")
        val directories = mutableListOf(mainKotlin, testKotlin)

        var packageDirectoryKotlin = mainKotlin.absolutePath
        var packageDirectoryTestKotlin = testKotlin.absolutePath
        module.pPackage.split(".").forEach {
            packageElement ->
            packageDirectoryKotlin += File.separator + packageElement
            packageDirectoryTestKotlin += File.separator + packageElement
        }
        packageDirectoryKotlin += File.separator + module.group
        packageDirectoryTestKotlin += File.separator + module.group
        directories.add(File(packageDirectoryKotlin))
        directories.add(File(packageDirectoryTestKotlin))

        return directories
    }

}