import org.springframework.boot.gradle.tasks.bundling.BootJar

group = "sample.shirohoo"

springBoot {
    mainClass.set("sample.shirohoo.realworld.RealworldApplication")
}

plugins {
    java
    jacoco
    id("com.diffplug.spotless")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

allprojects {
    apply(plugin = "java")
    apply(plugin = "jacoco")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    configurations {
        all { exclude(group = "junit", module = "junit") }
        compileOnly {
            extendsFrom(configurations.annotationProcessor.get())
        }
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        // annotation processor
        annotationProcessor("org.projectlombok:lombok")

        // compile only
        compileOnly("org.projectlombok:lombok")

        // implementation

        // test implementation
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.jacocoTestReport {
        dependsOn(tasks.test)

        reports {
            html.required.set(true)
            html.outputLocation.set(file("$buildDir/jacoco/html"))
        }
    }

    tasks.getByName<BootJar>("bootJar") {
        enabled = false
    }

    tasks.getByName<Jar>("jar") {
        enabled = true
    }

    spotless {
        java {
            palantirJavaFormat("2.38.0")
            indentWithSpaces()
            formatAnnotations()
            removeUnusedImports()
            trimTrailingWhitespace()
            importOrder("java", "jakarta", "org", "com", "net", "io", "lombok", "sample.shirohoo")
        }

        kotlin {
            ktlint()
            indentWithSpaces()
            trimTrailingWhitespace()
        }

        kotlinGradle {
            ktlint()
            indentWithSpaces()
            trimTrailingWhitespace()
        }
    }
}
