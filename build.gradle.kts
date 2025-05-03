plugins {
    kotlin("jvm") version "2.1.20"
}

group = "bagguley.aoc2024"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(23)
}