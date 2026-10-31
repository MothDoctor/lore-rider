// Generated from lore.h 0.12.0 by :codegen. Do not edit.
package com.dzmitryj.lorelens.ffi.generated

/**
 * Status codes carried by a Complete event and returned by operation
 * functions. Distinct from [lore_error_code_t], which is the storage-layer
 * enum in lore.h and is numbered independently.
 */
enum class LoreStatus(val code: Int, val message: String) {
    SUCCESS(0, "success"),
    INVALID_ARGUMENTS(3, "invalid arguments: {reason}"),
    INVALID_PATH(4, "invalid path: {path}"),
    INVALID_ADDRESS(5, "invalid address: {address}"),
    NOT_ALINK(6, "Path is not a link: {path}"),
    NOT_ALAYER(7, "Path is not a layer: {path}"),
    INVALID_NODE_HIERARCHY(8, "Node {node} has parent {actual_parent} but was reached as a child of {expected_parent}"),
    NOT_SUPPORTED(9, "Operation not supported: {operation}"),
    NOT_AUTHENTICATED(16, "Not authenticated"),
    NOT_AUTHORIZED(17, "Not authorized to access repository"),
    TOKEN_NOT_FOUND(18, "No token stored"),
    WRITE_REQUIRED(19, "Operation requires write access"),
    DISCONNECTED(28, "Disconnected from server"),
    NOT_CONNECTED(29, "Not connected to remote: {reason}"),
    MAINTENANCE(30, "Server is in maintenance mode"),
    SLOW_DOWN(31, "Store overloaded, slow down"),
    SERVICE_UNAVAILABLE(32, "Lore service unavailable: {reason}"),
    NOTHING_STAGED(40, "Nothing staged for commit"),
    BRANCH_ADVANCED(41, "Branch has been advanced by another instance, sync and re-stage to commit"),
    DIVERGENT(42, "Branch history is divergent"),
    CONFLICT(43, "Unable to commit when {path} is still in conflict"),
    LOCAL_MODIFICATIONS(44, "Local modifications prevent synchronization"),
    LOCK_NOT_OWNED(45, "resource locked by somebody else"),
    IDENTICAL_METADATA(46, "New metadata was identical to original"),
    DELETE_PROTECTED(47, "Unable to delete a protected branch: {branch}"),
    DELETE_CURRENT(48, "Cannot delete the current branch: {branch}"),
    DELETE_DEFAULT(49, "Unable to delete default branch: {branch}"),
    MOUNTS_BUSY(51, "Mounts are busy: {paths}"),
    ALREADY_LINKED(56, "Target repository is already used in a layer"),
    BRANCH_ALREADY_EXISTS(57, "Branch {branch} already exists, use switch instead"),
    REPOSITORY_ALREADY_EXISTS(58, "Repository already exist in path {path}"),
    NOT_FOUND(79, "Not found"),
    ADDRESS_NOT_FOUND(80, "Address not found: {}"),
    PAYLOAD_NOT_FOUND(81, "Payload not found: {}"),
    FILE_NOT_FOUND(82, "file not found: {resource}"),
    NODE_NOT_FOUND(83, "Node not found"),
    LINK_NOT_FOUND(84, "Link not found"),
    LINK_PATH_NOT_FOUND(85, "Link not found at path: {path}"),
    LAYER_NOT_FOUND(86, "Layer not found"),
    BRANCH_NOT_FOUND(87, "branch not found: {branch}"),
    REVISION_NOT_FOUND(88, "revision not found: {revision}"),
    REPOSITORY_NOT_FOUND(89, "Repository not found: {repository}"),
    SHARED_STORE_NOT_FOUND(90, "A shared store was supposed to exist at {path}"),
    LOCK_NOT_FOUND(91, "lock does not exist"),
    PLUGIN_NOT_FOUND(92, ""),
    MISSING_IDENTITY(110, "No commit identity configured; pass --identity or set identity in .lore/config.toml"),
    NO_REMOTE(111, "No remote configured"),
    PLUGIN_CONFIG_ERROR(112, "Plugin '{plugin_name}' configuration error: {message}"),
    PLUGIN_INIT_ERROR(113, "Plugin '{plugin_name}' initialization failed: {message}"),
    OVERSIZED(118, "Oversized: {context}"),
    MAX_HISTORY_SEARCH_DEPTH(119, "Branch history has reached maximum search depth"),
    INEFFICIENT_COMPRESSION(120, "Compression would be inefficient"),
    SHUT_DOWN(193, "Lore has been shut down"),
    ;

    companion object {
        private val byCode = entries.associateBy { it.code }

        fun of(code: Int): LoreStatus? = byCode[code]
    }
}
