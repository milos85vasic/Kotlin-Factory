package net.milosvasic.factory

import java.util.*

open class Module(val name: String) {

    val maveDependencies = HashSet<String>()
    val moduleDependencies = HashSet<Module>()
    val jarDependencies = HashSet<Jar>()

}