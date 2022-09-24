plugins {
    kotlin("jvm")
    id("org.jmailen.kotlinter")
    id("org.springframework.boot")
    id("io.spring.dependency-management") // https://docs.spring.io/spring-boot/docs/2.7.2/reference/html/dependency-versions.html#appendix.dependency-versions.properties
}

group = "com.tistory.byrage.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "11"
    }
    test {
        useJUnitPlatform()
    }
}
