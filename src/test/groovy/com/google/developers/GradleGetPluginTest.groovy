package com.google.developers

import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import org.gradle.api.DefaultTask
import static org.junit.Assert.*

class GradleGetPluginTest {
    @Test
    public void getPluginAddsGetTaskToProject() {
        Project project = ProjectBuilder.builder().build()
        project.pluginManager.apply 'com.google.developers.gradleget'

        assertTrue(project.tasks.get instanceof DefaultTask)
    }
}