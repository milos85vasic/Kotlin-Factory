package net.milosvasic.factory

import java.util.*

class Module private constructor(val name: String) {

    val repositories = HashSet<Repository>()
    val moduleDependencies = HashSet<Module>()
    val jarDependencies = HashSet<Jar>()

    class Builder {
        fun build(): Module {

            return Module("")
        }
    }

}