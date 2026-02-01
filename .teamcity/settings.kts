import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.maven
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2025.11"

project {
    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        maven {
            id = "MavenDeploy"
            name = "mvn clean deploy"
            goals = "clean deploy"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            conditions {
                equals("teamcity.build.branch.is_default", "true")
            }
        }

        maven {
            id = "MavenTest"
            name = "mvn clean test"
            goals = "clean test"
            runnerArgs = "-Dmaven.test.failure.ignore=true"
            conditions {
                equals("teamcity.build.branch.is_default", "false")
            }
        }
    }

    triggers {
        vcs {
            branchFilter = """
                +:refs/heads/*
            """.trimIndent()
        }
    }

    artifactRules = "target/*.jar"

    features {
        perfmon { }
    }
})

