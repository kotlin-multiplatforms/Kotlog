package io.github.kotlinmp.kotlog

import org.slf4j.ILoggerFactory
import org.slf4j.IMarkerFactory
import org.slf4j.helpers.BasicMarkerFactory
import org.slf4j.helpers.NOPMDCAdapter
import org.slf4j.spi.MDCAdapter
import org.slf4j.spi.SLF4JServiceProvider

class KotlogServiceProvider : SLF4JServiceProvider {
    private lateinit var loggerFactory: ILoggerFactory
    private lateinit var markerFactory: IMarkerFactory
    private lateinit var mdcAdapter: MDCAdapter

    override fun getLoggerFactory(): ILoggerFactory {
        return loggerFactory
    }

    override fun getMarkerFactory(): IMarkerFactory {
        return markerFactory
    }

    override fun getMDCAdapter(): MDCAdapter {
        return mdcAdapter
    }

    override fun getRequesteApiVersion(): String {
        return REQUESTED_API_VERSION
    }


    override fun initialize() {
        loggerFactory = KotlogLoggerFactory()
        markerFactory = BasicMarkerFactory()
        mdcAdapter = NOPMDCAdapter()
    }

    companion object {

        /**
         * Declare the version of the SLF4J API this implementation is compiled against.
         * The value of this field is modified with each major release.
         */
        // to avoid constant folding by the compiler, this field must *not* be final
        var REQUESTED_API_VERSION = "1.8.0-beta2" // !final
    }
}
