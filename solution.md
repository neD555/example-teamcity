TeamCity configuration is stored in the repository via Versioned Settings (Kotlin DSL)

Path: .teamcity/settings.kts
https://github.com/neD555/example-teamcity/blob/master/.teamcity/settings.kts

Branch rules:
master: mvn clean deploy
other branches: mvn clean test

Artifacts:
target/*.jar
