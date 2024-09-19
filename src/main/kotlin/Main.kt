package org.example

import java.net.URLClassLoader
import kotlin.io.path.Path

fun main() {
    val path = Path("m1/build/libs")
    val m1jar = path.toFile().listFiles()?.first()
    val child = URLClassLoader(
        arrayOf(m1jar?.toURI()?.toURL() ?: throw Throwable("not found such a jar file"))
    )
    val classToLoad = Class.forName("org.example.sampleClass.SajjadClass", true, child)
    val instance = classToLoad.newInstance()
    val myMethod = classToLoad.getMethod("sajjadMethod")
    println(myMethod.invoke(instance))
    println(instance.toString())

}