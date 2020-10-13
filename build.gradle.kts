import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    maven
    `maven-publish`
}

group = "com.github.IlyasYOY"
version = "0.0.1"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

apply(plugin = "kotlin")
apply(plugin = "maven")
apply(plugin = "maven-publish")

dependencies {
    val junitVersion = "5.7.0"
    val mockitoVersion = "3.5.13"
    val assertjVersion = "3.17.2"
    val kotlinStdLibVersion = "1.3.31"

    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinStdLibVersion")
    implementation("com.github.Steppschuh:Java-Markdown-Generator:master")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))

    // JUnit Dependencies
    testImplementation("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
    testImplementation("org.junit.jupiter:junit-jupiter-api")

    // Mocks
    testImplementation("org.mockito:mockito-core:$mockitoVersion")
    testImplementation("org.mockito:mockito-junit-jupiter:$mockitoVersion")

    // Assertions
    testImplementation("org.assertj:assertj-core:$assertjVersion")
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks {
    test {
        useJUnitPlatform()
    }

    val sourcesJar by creating(Jar::class) {
        dependsOn.add("classes")
        archiveClassifier.set("sources")
        from(sourceSets.main.get().allSource)
    }

    val javadocJar by creating(Jar::class) {
        dependsOn.add(javadoc)
        archiveClassifier.set("javadoc")
        from(javadoc)
    }

    artifacts {
        archives(sourcesJar)
        archives(javadocJar)
        archives(jar)
    }
    
    wrapper {
        version = "6.6"
        distributionType  = Wrapper.DistributionType.BIN
    }

    install {
        repositories {
            withConvention(MavenRepositoryHandlerConvention::class) {
                mavenInstaller {
                    pom.project {
                        withGroovyBuilder {
                            "licenses" {
                                "license" {
                                    "name"("The Apache Software License, Version 2.0")
                                    "url"("http://www.apache.org/licenses/LICENSE-2.0.txt")
                                    "distribution"("repo")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}