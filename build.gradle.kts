plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter")

    // AssertJ
    testImplementation ("org.assertj:assertj-core:3.18.1")

    // jfree
    implementation("org.jfree:jfreechart:1.5.5")
}

tasks.test {
    useJUnitPlatform()
}
