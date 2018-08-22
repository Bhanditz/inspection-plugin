package org.jetbrains.intellij.extensions

import org.gradle.api.Action
import java.util.*

class InspectionsExtension {

    /**
     * The maximum number of emitted inspections problems that are tolerated before breaking the build
     * or setting the failure property. <tt>null</tt> value means that that there are no limits on the
     * number of problems.
     */
    var max: Int? = null

    /**
     * Registered inspections settings
     */
    val inspections: Map<String, InspectionExtension> = HashMap()

    @Suppress("unused")
    fun inspection(name: String): InspectionExtension {
        return (inspections as MutableMap).getOrPut(name) {
            InspectionExtension()
        }
    }

    @Suppress("unused")
    fun inspection(name: String, action: Action<InspectionExtension>) {
        val extension = inspection(name)
        action.execute(extension)
    }
}