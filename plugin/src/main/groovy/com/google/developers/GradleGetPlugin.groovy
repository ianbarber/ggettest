package com.google.developers

import org.ajoberstar.grgit.Grgit
import org.gradle.api.Project
import org.gradle.api.Plugin
import java.security.MessageDigest


class GradleGetPlugin implements Plugin<Project> {
    void apply(Project target) {
        /*target.task('get', type: GreetingTask)*/
		target.task('get') << {
			// TODO: Can we work this out automatically?
			def mavenRepo = "~/.m2/repository"
			def githubURL = "https://github.com/ianbarber/ggettest"
			
            println "Getting " + githubURL
		    String urlhash = MessageDigest.getInstance('MD5').digest(githubURL.bytes).encodeHex().toString()
			
			File dir=new File('/tmp/' + urlhash)
			if(dir.exists()) {
				println '/tmp/' + urlhash + ' exists, exiting.'
				return
			}
			def grgit = Grgit.clone(dir: dir, uri: githubURL)			
			
			
			// TODO: Clean up clone URL directory.
        }

        target.task('publish').dependsOn('jar') << {
            println "Publishing..."
			def jar = target.getTasks().getByName('jar')
			def path = (String) jar.getProperties().get("archivePath");
			println path

        }
    }
}