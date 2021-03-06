package com.github.gtache

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class TestUtils {

    public static Project getFreshProject() {

        Project proj = ProjectBuilder.builder().build()

        proj.buildscript {
            repositories {
                mavenLocal()
                mavenCentral()
            }
            dependencies {
                classpath 'com.github.gtache:scalajs-plugin:0.2.0'
            }
        }
        proj.repositories {
            mavenCentral()
        }

        proj.pluginManager.apply('java')

        proj.pluginManager.apply('scala')

        proj.dependencies {
            compile 'org.scala-lang:scala-compiler:2.11.8'
            compile 'org.scala-lang:scala-library:2.11.8'
        }
        /*
        Copy libCopy = proj.tasks.create("copyToLib", Copy.class)
        libCopy.from(proj.configurations.compile.files)
        libCopy.into(offlineLib)
        */
        return proj
    }

    public static void applyPlugin(Project project) {
        project.pluginManager.apply('scalajs-plugin')
    }

    public static void setProperty(Project project, String key, Object value = true) {
        project.extensions.add(key, value)
    }

}
