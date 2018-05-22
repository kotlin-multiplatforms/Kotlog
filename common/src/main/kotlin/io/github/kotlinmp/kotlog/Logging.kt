package io.github.kotlinmp.kotlog

import io.github.kotlinmp.kotlog.compat.Field

/**
 * A class with logging capabilities.
 * usage examples
 * <code>
 * class ClassWithLogging {
 *     companion object : Logging("ClassWithLogging")
 *
 *     fun test() {
 *         logger.info("test ClassWithLogging")
 *     }
 * }
 * </code>
 */
open class Logging(name: String) {
    /**
     * The member that performs the actual logging.
     */
    @Field
    val logger: Logger = CommonLoggerFactory.getLogger(name)
}
