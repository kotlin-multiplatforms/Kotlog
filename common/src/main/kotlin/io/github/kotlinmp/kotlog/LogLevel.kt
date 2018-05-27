package io.github.kotlinmp.kotlog

/**
 * These enums meaning the level of importance, or behaviors
 */
enum class LogLevel {
    /**
     * Meaning 'Do not log'
     */
    OFF,
    /**
     * Meaning 'Program's work information'
     */
    INFO,
    /**
     * Meaning 'Warning, this program may not works'
     */
    WARN,
    /**
     * Meaning 'This program caught the error'
     */
    ERROR,
    /**
     * Meaning 'This message is for debugging that for developers'
     */
    DEBUG,
    /**
     * Meaning 'This message is for trace some data.'
     */
    TRACE
}
