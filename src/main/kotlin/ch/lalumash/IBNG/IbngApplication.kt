package ch.lalumash.IBNG

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
class IbngApplication

fun main(args: Array<String>) {
	runApplication<IbngApplication>(*args)
}
