package com.google.developers

import org.gradle.api.Project
import org.gradle.api.Plugin

class GradleGetPlugin implements Plugin<Project> {
    void apply(Project target) {
        /*target.task('get', type: GreetingTask)*/
		target.task('get') << {
            println "Getting"
        }
    }
}