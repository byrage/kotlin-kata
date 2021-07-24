plugins {
    java
    kotlin("jvm") version "1.3.72"
    id("org.jlleitschuh.gradle.ktlint") version "9.3.0"
}

group = "com.tistory.byrage.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.junit.jupiter", "junit-jupiter", "5.6.2")
    testImplementation("org.assertj", "assertj-core", "3.16.1")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    test {
        useJUnitPlatform()
    }
    ktlint {
        verbose.set(true)
        disabledRules.addAll("import-ordering")
    }
}