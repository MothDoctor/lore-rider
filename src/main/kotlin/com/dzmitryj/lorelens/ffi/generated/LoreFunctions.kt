// Generated from lore.h 0.12.0 by :codegen. Do not edit.
package com.dzmitryj.lorelens.ffi.generated

import com.dzmitryj.lorelens.ffi.LoreLinker
import java.lang.foreign.FunctionDescriptor
import java.lang.foreign.MemoryLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.MethodHandle

/**
 * Handles bind lazily so a symbol missing from the loaded library fails at the
 * call site that needs it rather than at load time.
 */
object LoreFunctions {

    /**
     * Clear all stored authentication data.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_auth_clear: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_clear",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_clear`.
     */
    val lore_auth_clear_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_clear_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all stored authentication identities.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Auth Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_AUTH_IDENTITY` | `lore_auth_identity_event_data_t` | Emitted once per stored identity |
     */
    val lore_auth_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_list`.
     */
    val lore_auth_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve user identities to display names from locally stored JWT tokens.
     * 
     * Decodes cached JWT tokens to extract display names without contacting the
     * auth service. For user IDs without a local token, returns the raw user
     * ID. For remote resolution with proper authorization, use
     * `lore_auth_user_info` which queries the remote authentication service.
     * 
     * When `with_identity_token` is set, identities with a locally stored token
     * are answered as `AUTH_USER_TOKEN` events carrying the cached identity
     * token instead of `AUTH_USER_INFO`.
     * 
     * When `with_access_token` is set, the call requires a repository and
     * additionally emits one `AUTH_IDENTITY` event carrying the
     * repository-scoped authorization (access) token for the current user. A
     * valid cached token is reused. Otherwise a token exchange is performed
     * against the auth service, so this variant can contact the network.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Auth Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_AUTH_USER_INFO` | `lore_auth_user_info_event_data_t` | Emitted with the resolved user id and display name |
     * | `LORE_EVENT_AUTH_USER_TOKEN` | `lore_auth_user_token_event_data_t` | Emitted instead of `AUTH_USER_INFO` when `with_identity_token` is set and a cached token is available, includes full token details |
     * | `LORE_EVENT_AUTH_IDENTITY` | `lore_auth_identity_event_data_t` | Emitted when `with_access_token` is set, carries the repository-scoped authorization token for the current user |
     */
    val lore_auth_local_user_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_local_user_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_local_user_info`.
     */
    val lore_auth_local_user_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_local_user_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Authenticate interactively via a browser-based login flow.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Auth Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_AUTH_URL` | `lore_auth_url_event_data_t` | Emitted with the login URL when no_browser mode is requested, and whenever the login has a code the user may need to enter or confirm at that URL, browser or not. `user_code` holds the code, or is empty |
     * | `LORE_EVENT_AUTH_PENDING` | `lore_auth_pending_event_data_t` | Emitted before each wait while the login awaits the user's approval, with the seconds elapsed, the seconds until the next poll, and the seconds left before the session expires. |
     * | `LORE_EVENT_AUTH_USER_INFO` | `lore_auth_user_info_event_data_t` | Emitted with user id and display name after successful interactive authentication |
     */
    val lore_auth_login_interactive: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_login_interactive",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_login_interactive`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Auth Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_AUTH_URL` | `lore_auth_url_event_data_t` | Emitted with the login URL when no_browser mode is requested, and whenever the login has a code the user may need to enter or confirm at that URL, browser or not. `user_code` holds the code, or is empty |
     * | `LORE_EVENT_AUTH_PENDING` | `lore_auth_pending_event_data_t` | Emitted before each wait while the login awaits the user's approval, with the seconds elapsed, the seconds until the next poll, and the seconds left before the session expires. |
     * | `LORE_EVENT_AUTH_USER_INFO` | `lore_auth_user_info_event_data_t` | Emitted with user id and display name after successful interactive authentication |
     */
    val lore_auth_login_interactive_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_login_interactive_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Authenticate using an existing bearer token, or, when `client_id` is set, as the
     * registered client it names with `client_secret`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Auth Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_AUTH_USER_INFO` | `lore_auth_user_info_event_data_t` | Emitted with user id and display name after successful token authentication |
     */
    val lore_auth_login_with_token: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_login_with_token",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_login_with_token`.
     */
    val lore_auth_login_with_token_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_login_with_token_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove stored authentication and authorization tokens.
     * 
     * Each login removed with its refresh token is then revoked if the auth service offers
     * revocation. A failed revocation fails the call after the tokens are removed, so a non-zero
     * return value or `LORE_EVENT_COMPLETE` status does not mean the tokens are still stored.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_auth_logout: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_logout",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_logout`.
     */
    val lore_auth_logout_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_logout_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve user IDs to display names using the remote authentication service.
     * Requires an authenticated connection.
     * 
     * When no user IDs are provided, returns the current user's identity using
     * locally cached tokens (equivalent to `lore_auth_local_user_info`).
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Auth Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_AUTH_USER_INFO` | `lore_auth_user_info_event_data_t` | Emitted with user id and display name for each resolved user |
     */
    val lore_auth_user_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_user_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_auth_user_info`.
     */
    val lore_auth_user_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_auth_user_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Archive a branch in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_ARCHIVE` | `lore_branch_archive_event_data_t` | Emitted when the branch has been successfully archived |
     */
    val lore_branch_archive: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_archive",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_archive`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_ARCHIVE` | `lore_branch_archive_event_data_t` | Emitted when the branch has been successfully archived |
     */
    val lore_branch_archive_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_archive_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Create a new branch in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_CREATE` | `lore_branch_create_event_data_t` | Emitted when the branch has been successfully created, includes branch name and id |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_BRANCH_CREATE` | `lore_link_branch_create_event_data_t` | Emitted once per linked repository mount, reporting whether its branch was created or an existing one reused |
     */
    val lore_branch_create: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_create",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_create`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_CREATE` | `lore_branch_create_event_data_t` | Emitted when the branch has been successfully created, includes branch name and id |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_BRANCH_CREATE` | `lore_link_branch_create_event_data_t` | Emitted once per linked repository mount, reporting whether its branch was created or an existing one reused |
     */
    val lore_branch_create_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_create_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Show the changes and conflicts between two branches.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_DIFF_BEGIN` | `lore_branch_diff_begin_event_data_t` | Emitted before diff results begin streaming. Includes the resolved branch names and revisions being compared |
     * | `LORE_EVENT_BRANCH_DIFF_CHANGE_BEGIN` | `lore_branch_diff_change_begin_event_data_t` | Emitted before the list of changed files begins |
     * | `LORE_EVENT_BRANCH_DIFF_CHANGE` | `lore_branch_diff_change_event_data_t` | Emitted for each changed file between the two branches |
     * | `LORE_EVENT_BRANCH_DIFF_CHANGE_END` | `lore_branch_diff_change_end_event_data_t` | Emitted after all changed files have been reported |
     * | `LORE_EVENT_BRANCH_DIFF_CONFLICT_BEGIN` | `lore_branch_diff_conflict_begin_event_data_t` | Emitted before the list of conflicting files begins |
     * | `LORE_EVENT_BRANCH_DIFF_CONFLICT` | `lore_branch_diff_conflict_event_data_t` | Emitted for each file that has a conflict between the two branches |
     * | `LORE_EVENT_BRANCH_DIFF_CONFLICT_END` | `lore_branch_diff_conflict_end_event_data_t` | Emitted after all conflict files have been reported |
     * | `LORE_EVENT_BRANCH_DIFF_END` | `lore_branch_diff_end_event_data_t` | Emitted after all diff results have been streamed |
     */
    val lore_branch_diff: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_diff",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_diff`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_DIFF_BEGIN` | `lore_branch_diff_begin_event_data_t` | Emitted before diff results begin streaming; carries the resolved branch names and revisions being compared |
     * | `LORE_EVENT_BRANCH_DIFF_CHANGE_BEGIN` | `lore_branch_diff_change_begin_event_data_t` | Emitted before the list of changed files begins |
     * | `LORE_EVENT_BRANCH_DIFF_CHANGE` | `lore_branch_diff_change_event_data_t` | Emitted for each changed file between the two branches |
     * | `LORE_EVENT_BRANCH_DIFF_CHANGE_END` | `lore_branch_diff_change_end_event_data_t` | Emitted after all changed files have been reported |
     * | `LORE_EVENT_BRANCH_DIFF_CONFLICT_BEGIN` | `lore_branch_diff_conflict_begin_event_data_t` | Emitted before the list of conflicting files begins |
     * | `LORE_EVENT_BRANCH_DIFF_CONFLICT` | `lore_branch_diff_conflict_event_data_t` | Emitted for each file that has a conflict between the two branches |
     * | `LORE_EVENT_BRANCH_DIFF_CONFLICT_END` | `lore_branch_diff_conflict_end_event_data_t` | Emitted after all conflict files have been reported |
     * | `LORE_EVENT_BRANCH_DIFF_END` | `lore_branch_diff_end_event_data_t` | Emitted after all diff results have been streamed |
     */
    val lore_branch_diff_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_diff_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve metadata about a specific branch.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_INFO` | `lore_branch_info_event_data_t` | Emitted with branch metadata (name, id, category, protection status, etc.) |
     */
    val lore_branch_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_info`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_INFO` | `lore_branch_info_event_data_t` | Emitted with branch metadata (name, id, category, protection status, etc.) |
     */
    val lore_branch_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List the revisions the LATEST of a branch has held, most recent first.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_LATEST_LIST_ENTRY` | `lore_branch_latest_list_entry_event_data_t` | Emitted for each revision the branch LATEST has held, most recent first |
     */
    val lore_branch_latest_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_latest_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_latest_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_LATEST_LIST_ENTRY` | `lore_branch_latest_list_entry_event_data_t` | Emitted for each revision the branch LATEST has held, most recent first |
     */
    val lore_branch_latest_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_latest_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all branches in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_LIST_BEGIN` | `lore_branch_list_begin_event_data_t` | Emitted before branch list entries begin streaming |
     * | `LORE_EVENT_BRANCH_LIST_ENTRY` | `lore_branch_list_entry_event_data_t` | Emitted for each branch in the repository |
     * | `LORE_EVENT_BRANCH_LIST_END` | `lore_branch_list_end_event_data_t` | Emitted after all branch entries have been streamed |
     */
    val lore_branch_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_LIST_BEGIN` | `lore_branch_list_begin_event_data_t` | Emitted before branch list entries begin streaming |
     * | `LORE_EVENT_BRANCH_LIST_ENTRY` | `lore_branch_list_entry_event_data_t` | Emitted for each branch in the repository |
     * | `LORE_EVENT_BRANCH_LIST_END` | `lore_branch_list_end_event_data_t` | Emitted after all branch entries have been streamed |
     */
    val lore_branch_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Abort an in-progress branch merge and restore the pre-merge state.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_ABORT_BEGIN` | `lore_branch_merge_abort_begin_event_data_t` | Emitted when aborting a branch merge, includes staged and current revision hashes |
     * | `LORE_EVENT_BRANCH_MERGE_ABORT_END` | `lore_branch_merge_abort_end_event_data_t` | Emitted after the merge abort has been completed |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization while reverting merge changes |
     */
    val lore_branch_merge_abort: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_abort",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_abort`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_ABORT_BEGIN` | `lore_branch_merge_abort_begin_event_data_t` | Emitted when aborting a branch merge, includes staged and current revision hashes |
     * | `LORE_EVENT_BRANCH_MERGE_ABORT_END` | `lore_branch_merge_abort_end_event_data_t` | Emitted after the merge abort has been completed |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization while reverting merge changes |
     */
    val lore_branch_merge_abort_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_abort_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Merge the current branch into a target branch.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FILE_BEGIN` | `lore_branch_merge_into_file_begin_event_data_t` | Emitted when starting to merge files into the target branch |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FILE` | `lore_branch_merge_into_file_event_data_t` | Emitted for each file being merged into the target branch |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FILE_END` | `lore_branch_merge_into_file_end_event_data_t` | Emitted after all files have been merged |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_BEGIN` | `lore_branch_merge_into_fragment_begin_event_data_t` | Emitted when starting fragment transfer for a file |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_PROGRESS` | `lore_branch_merge_into_fragment_progress_event_data_t` | Emitted periodically during fragment transfer |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_END` | `lore_branch_merge_into_fragment_end_event_data_t` | Emitted when fragment transfer for a file completes |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_REVISION` | `lore_branch_merge_into_revision_event_data_t` | Emitted with the resulting revision after the merge into is complete |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_SYNC_BEGIN` | `lore_branch_merge_into_sync_begin_event_data_t` | Emitted when starting to apply the changes on the target state |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_SYNC_END` | `lore_branch_merge_into_sync_end_event_data_t` | Emitted after applying the changes on the target state is complete |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (if no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted periodically during auto-commit file processing |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit file processing completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revision details |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during changes realization |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the committed revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each file fragment written or deduplicated during commit |
     */
    val lore_branch_merge_into: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_into",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_into`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FILE_BEGIN` | `lore_branch_merge_into_file_begin_event_data_t` | Emitted when starting to merge files into the target branch |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FILE` | `lore_branch_merge_into_file_event_data_t` | Emitted for each file being merged into the target branch |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FILE_END` | `lore_branch_merge_into_file_end_event_data_t` | Emitted after all files have been merged |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_BEGIN` | `lore_branch_merge_into_fragment_begin_event_data_t` | Emitted when starting fragment transfer for a file |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_PROGRESS` | `lore_branch_merge_into_fragment_progress_event_data_t` | Emitted periodically during fragment transfer |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_END` | `lore_branch_merge_into_fragment_end_event_data_t` | Emitted when fragment transfer for a file completes |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_REVISION` | `lore_branch_merge_into_revision_event_data_t` | Emitted with the resulting revision after the merge into is complete |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_SYNC_BEGIN` | `lore_branch_merge_into_sync_begin_event_data_t` | Emitted when starting to apply the changes on the target state |
     * | `LORE_EVENT_BRANCH_MERGE_INTO_SYNC_END` | `lore_branch_merge_into_sync_end_event_data_t` | Emitted after applying the changes on the target state is complete |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (if no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted periodically during auto-commit file processing |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit file processing completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revision details |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during changes realization |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the committed revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each file fragment written or deduplicated during commit |
     */
    val lore_branch_merge_into_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_into_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Mark conflicting files in a merge as resolved.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE` | `lore_branch_merge_resolve_file_event_data_t` | Emitted for each file that was marked as resolved |
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION` | `lore_branch_merge_resolve_revision_event_data_t` | Emitted with the updated staged revision after resolve completes |
     */
    val lore_branch_merge_resolve: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_resolve",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_resolve`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE` | `lore_branch_merge_resolve_file_event_data_t` | Emitted for each file that was marked as resolved |
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION` | `lore_branch_merge_resolve_revision_event_data_t` | Emitted with the updated staged revision after resolve completes |
     */
    val lore_branch_merge_resolve_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_resolve_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a merge conflict by accepting the "mine" version of each conflicting file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE` | `lore_branch_merge_resolve_file_event_data_t` | Emitted for each file resolved by keeping "mine" |
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION` | `lore_branch_merge_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_branch_merge_resolve_mine: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_resolve_mine",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_resolve_mine`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE` | `lore_branch_merge_resolve_file_event_data_t` | Emitted for each file resolved by keeping "mine" |
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION` | `lore_branch_merge_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_branch_merge_resolve_mine_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_resolve_mine_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a merge conflict by accepting the "theirs" version of each conflicting file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE` | `lore_branch_merge_resolve_file_event_data_t` | Emitted for each file resolved by keeping "theirs" |
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION` | `lore_branch_merge_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_branch_merge_resolve_theirs: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_resolve_theirs",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_resolve_theirs`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE` | `lore_branch_merge_resolve_file_event_data_t` | Emitted for each file resolved by keeping "theirs" |
     * | `LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION` | `lore_branch_merge_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_branch_merge_resolve_theirs_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_resolve_theirs_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Restart an in-progress merge, re-materializing conflicted files.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE` | `lore_branch_merge_conflict_file_event_data_t` | Emitted for each file with a remaining merge conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization during restart |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file re-materialized during restart |
     */
    val lore_branch_merge_restart: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_restart",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_restart`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE` | `lore_branch_merge_conflict_file_event_data_t` | Emitted for each file with a remaining merge conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization during restart |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file re-materialized during restart |
     */
    val lore_branch_merge_restart_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_restart_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Start a merge from another branch into the current branch.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_START_BEGIN` | `lore_branch_merge_start_begin_event_data_t` | Emitted when merge begins, includes source branch and revision info |
     * | `LORE_EVENT_BRANCH_MERGE_START_END` | `lore_branch_merge_start_end_event_data_t` | Emitted when merge operation completes, includes sync stats and conflict flag |
     * | `LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE` | `lore_branch_merge_conflict_file_event_data_t` | Emitted for each file with an unresolved merge conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during the apply_diff phase of the merge |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified during merge realization |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during merge realization |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (no conflicts, no_commit=false) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted periodically during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit file processing completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revision details |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the committed revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written during auto-commit |
     */
    val lore_branch_merge_start: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_start",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_start`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_START_BEGIN` | `lore_branch_merge_start_begin_event_data_t` | Emitted when merge begins, includes source branch and revision info |
     * | `LORE_EVENT_BRANCH_MERGE_START_END` | `lore_branch_merge_start_end_event_data_t` | Emitted when merge operation completes, includes sync stats and conflict flag |
     * | `LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE` | `lore_branch_merge_conflict_file_event_data_t` | Emitted for each file with an unresolved merge conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during the apply_diff phase of the merge |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified during merge realization |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during merge realization |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (no conflicts, no_commit=false) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted periodically during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit file processing completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revision details |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the committed revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written during auto-commit |
     */
    val lore_branch_merge_start_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_start_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Mark conflicting files in a merge as unresolved.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_UNRESOLVE_FILE` | `lore_branch_merge_unresolve_file_event_data_t` | Emitted for each file that was marked as unresolved |
     * | `LORE_EVENT_BRANCH_MERGE_UNRESOLVE_REVISION` | `lore_branch_merge_unresolve_revision_event_data_t` | Emitted with the updated staged revision after unresolve completes |
     */
    val lore_branch_merge_unresolve: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_unresolve",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_merge_unresolve`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_MERGE_UNRESOLVE_FILE` | `lore_branch_merge_unresolve_file_event_data_t` | Emitted for each file that was marked as unresolved |
     * | `LORE_EVENT_BRANCH_MERGE_UNRESOLVE_REVISION` | `lore_branch_merge_unresolve_revision_event_data_t` | Emitted with the updated staged revision after unresolve completes |
     */
    val lore_branch_merge_unresolve_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_merge_unresolve_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Clear branch metadata keys.
     */
    val lore_branch_metadata_clear: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_metadata_clear",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_metadata_clear`.
     */
    val lore_branch_metadata_clear_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_metadata_clear_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve branch metadata.
     */
    val lore_branch_metadata_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_metadata_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_metadata_get`.
     */
    val lore_branch_metadata_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_metadata_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set branch metadata key-value pairs.
     */
    val lore_branch_metadata_set: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_metadata_set",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_metadata_set`.
     */
    val lore_branch_metadata_set_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_metadata_set_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Enable write protection on a branch to prevent direct commits.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_PROTECT` | `lore_branch_protect_event_data_t` | Emitted when the branch has been successfully protected |
     */
    val lore_branch_protect: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_protect",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_protect`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_PROTECT` | `lore_branch_protect_event_data_t` | Emitted when the branch has been successfully protected |
     */
    val lore_branch_protect_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_protect_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Push local branch commits to the remote repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_PUSH` | `lore_branch_push_event_data_t` | Emitted when push begins, includes branch name and revision info |
     * | `LORE_EVENT_BRANCH_PUSH_BRANCH_CREATE_BEGIN` | `lore_branch_push_branch_create_begin_event_data_t` | Emitted when creating the remote branch (first push) |
     * | `LORE_EVENT_BRANCH_PUSH_BRANCH_CREATE_END` | `lore_branch_push_branch_create_end_event_data_t` | Emitted when remote branch creation completes |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_UPDATE_BEGIN` | `lore_branch_push_revision_update_begin_event_data_t` | Emitted when updating a revision on the remote |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_UPDATE_END` | `lore_branch_push_revision_update_end_event_data_t` | Emitted when a revision update completes |
     * | `LORE_EVENT_BRANCH_PUSH_FRAGMENT_BEGIN` | `lore_branch_push_fragment_begin_event_data_t` | Emitted when uploading fragment data begins |
     * | `LORE_EVENT_BRANCH_PUSH_FRAGMENT_PROGRESS` | `lore_branch_push_fragment_progress_event_data_t` | Emitted periodically during fragment upload |
     * | `LORE_EVENT_BRANCH_PUSH_FRAGMENT_END` | `lore_branch_push_fragment_end_event_data_t` | Emitted when fragment upload completes |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_BEGIN` | `lore_branch_push_revision_push_begin_event_data_t` | Emitted when pushing a revision to the remote begins |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_UPDATE` | `lore_branch_push_revision_push_update_event_data_t` | Emitted with progress updates during revision push |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_END` | `lore_branch_push_revision_push_end_event_data_t` | Emitted when revision push completes |
     */
    val lore_branch_push: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_push",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_push`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_PUSH` | `lore_branch_push_event_data_t` | Emitted when push begins, includes branch name and revision info |
     * | `LORE_EVENT_BRANCH_PUSH_BRANCH_CREATE_BEGIN` | `lore_branch_push_branch_create_begin_event_data_t` | Emitted when creating the remote branch (first push) |
     * | `LORE_EVENT_BRANCH_PUSH_BRANCH_CREATE_END` | `lore_branch_push_branch_create_end_event_data_t` | Emitted when remote branch creation completes |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_UPDATE_BEGIN` | `lore_branch_push_revision_update_begin_event_data_t` | Emitted when updating a revision on the remote |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_UPDATE_END` | `lore_branch_push_revision_update_end_event_data_t` | Emitted when a revision update completes |
     * | `LORE_EVENT_BRANCH_PUSH_FRAGMENT_BEGIN` | `lore_branch_push_fragment_begin_event_data_t` | Emitted when uploading fragment data begins |
     * | `LORE_EVENT_BRANCH_PUSH_FRAGMENT_PROGRESS` | `lore_branch_push_fragment_progress_event_data_t` | Emitted periodically during fragment upload |
     * | `LORE_EVENT_BRANCH_PUSH_FRAGMENT_END` | `lore_branch_push_fragment_end_event_data_t` | Emitted when fragment upload completes |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_BEGIN` | `lore_branch_push_revision_push_begin_event_data_t` | Emitted when pushing a revision to the remote begins |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_UPDATE` | `lore_branch_push_revision_push_update_event_data_t` | Emitted with progress updates during revision push |
     * | `LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_END` | `lore_branch_push_revision_push_end_event_data_t` | Emitted when revision push completes |
     */
    val lore_branch_push_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_push_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Reset the current branch to a specific revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_RESET` | `lore_branch_reset_event_data_t` | Emitted when the branch has been reset to the target revision |
     */
    val lore_branch_reset: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_reset",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_reset`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_RESET` | `lore_branch_reset_event_data_t` | Emitted when the branch has been reset to the target revision |
     */
    val lore_branch_reset_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_reset_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Switch to a different branch and update the working directory.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_SWITCH_BEGIN` | `lore_branch_switch_begin_event_data_t` | Emitted when branch switch starts |
     * | `LORE_EVENT_BRANCH_SWITCH_END` | `lore_branch_switch_end_event_data_t` | Emitted when branch switch completes successfully |
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted with target revision info after resolving the switch target |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified/added/deleted during switch |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during file realization |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted with the resulting revision after switch |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision number |
     */
    val lore_branch_switch: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_switch",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_switch`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_SWITCH_BEGIN` | `lore_branch_switch_begin_event_data_t` | Emitted when branch switch starts |
     * | `LORE_EVENT_BRANCH_SWITCH_END` | `lore_branch_switch_end_event_data_t` | Emitted when branch switch completes successfully |
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted with target revision info after resolving the switch target |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified/added/deleted during switch |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during file realization |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted with the resulting revision after switch |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision number |
     */
    val lore_branch_switch_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_switch_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove write protection from a branch.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_UNPROTECT` | `lore_branch_unprotect_event_data_t` | Emitted when the branch has been successfully unprotected |
     */
    val lore_branch_unprotect: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_unprotect",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_branch_unprotect`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Branch Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_BRANCH_UNPROTECT` | `lore_branch_unprotect_event_data_t` | Emitted when the branch has been successfully unprotected |
     */
    val lore_branch_unprotect_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_branch_unprotect_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Return the tag identifying the type of an event.
     */
    val lore_event_type: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_event_type",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS),
        )
    }

    /**
     * Attribute each line of a file to the revision that last changed it.
     * 
     * One `LORE_EVENT_FILE_AUDIT` event carries each range of consecutive lines
     * sharing an attribution. Each range arrives as soon as the step of the walk
     * that resolves it ends. The walk resolves the most recently changed lines
     * first, so ranges arrive in that order, not in line order. Each range is
     * complete and never needs joining with another. A caller with what it needs
     * may stop reading; the events already delivered stand.
     * 
     * A range names its revision and repository, not the revision's metadata. Read
     * the metadata with `lore_revision_info`, once per distinct revision.
     * 
     * An error that ends the walk, such as a lost connection to the remote, ends
     * the audit: every line is still delivered, those the walk did not reach with
     * the outcome `LORE_FILE_AUDIT_OUTCOME_UNRESOLVED`, and `LORE_EVENT_COMPLETE`
     * carries the error.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_AUDIT` | `lore_file_audit_event_data_t` | Emitted for each range of consecutive lines sharing an attribution |
     */
    val lore_file_audit: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_audit",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_audit`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_AUDIT` | `lore_file_audit_event_data_t` | Emitted for each range of consecutive lines sharing an attribution |
     */
    val lore_file_audit_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_audit_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Adds dependency relationships between files.
     * 
     * # Events
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Dependency Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DEPENDENCY_ADD_BEGIN` | `lore_file_dependency_add_begin_event_data_t` | Start of operation |
     * | `LORE_EVENT_FILE_DEPENDENCY_ADD_ENTRY` | `lore_file_dependency_add_entry_event_data_t` | Each dependency added |
     * | `LORE_EVENT_FILE_DEPENDENCY_ADD_END` | `lore_file_dependency_add_end_event_data_t` | Operation complete |
     */
    val lore_file_dependency_add: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dependency_add",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dependency_add`.
     * 
     * # Events
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Dependency Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DEPENDENCY_ADD_BEGIN` | `lore_file_dependency_add_begin_event_data_t` | Start of operation |
     * | `LORE_EVENT_FILE_DEPENDENCY_ADD_ENTRY` | `lore_file_dependency_add_entry_event_data_t` | Each dependency added |
     * | `LORE_EVENT_FILE_DEPENDENCY_ADD_END` | `lore_file_dependency_add_end_event_data_t` | Operation complete |
     */
    val lore_file_dependency_add_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dependency_add_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Queries dependency information for files.
     * 
     * # Events
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Dependency Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_BEGIN` | `lore_file_dependency_list_begin_event_data_t` | Start of listing |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_FILE` | `lore_file_dependency_list_file_event_data_t` | Start of entries for one file |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_ENTRY` | `lore_file_dependency_list_entry_event_data_t` | One dependency entry |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_FILE_END` | `lore_file_dependency_list_file_end_event_data_t` | End of entries for one file |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_END` | `lore_file_dependency_list_end_event_data_t` | End of listing |
     */
    val lore_file_dependency_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dependency_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dependency_list`.
     * 
     * # Events
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Dependency Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_BEGIN` | `lore_file_dependency_list_begin_event_data_t` | Start of listing |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_FILE` | `lore_file_dependency_list_file_event_data_t` | Start of entries for one file |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_ENTRY` | `lore_file_dependency_list_entry_event_data_t` | One dependency entry |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_FILE_END` | `lore_file_dependency_list_file_end_event_data_t` | End of entries for one file |
     * | `LORE_EVENT_FILE_DEPENDENCY_LIST_END` | `lore_file_dependency_list_end_event_data_t` | End of listing |
     */
    val lore_file_dependency_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dependency_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Removes dependency relationships between files.
     * 
     * # Events
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Dependency Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DEPENDENCY_REMOVE_BEGIN` | `lore_file_dependency_remove_begin_event_data_t` | Start of operation |
     * | `LORE_EVENT_FILE_DEPENDENCY_REMOVE_ENTRY` | `lore_file_dependency_remove_entry_event_data_t` | Each dependency removed |
     * | `LORE_EVENT_FILE_DEPENDENCY_REMOVE_END` | `lore_file_dependency_remove_end_event_data_t` | Operation complete |
     */
    val lore_file_dependency_remove: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dependency_remove",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dependency_remove`.
     * 
     * # Events
     * 
     * ## Standard Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Dependency Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DEPENDENCY_REMOVE_BEGIN` | `lore_file_dependency_remove_begin_event_data_t` | Start of operation |
     * | `LORE_EVENT_FILE_DEPENDENCY_REMOVE_ENTRY` | `lore_file_dependency_remove_entry_event_data_t` | Each dependency removed |
     * | `LORE_EVENT_FILE_DEPENDENCY_REMOVE_END` | `lore_file_dependency_remove_end_event_data_t` | Operation complete |
     */
    val lore_file_dependency_remove_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dependency_remove_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Show which files differ between two revisions.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DIFF` | `lore_file_diff_event_data_t` | Emitted for each file that differs between the two revisions |
     */
    val lore_file_diff: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_diff",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_diff`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DIFF` | `lore_file_diff_event_data_t` | Emitted for each file that differs between the two revisions |
     */
    val lore_file_diff_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_diff_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Mark files as dirty in the staged state without staging their content.
     * 
     * Action is determined by checking filesystem existence and current revision state
     * (modify, add, delete, or revert-add). Respects ignore and view filters.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_PATH_IGNORE` | `lore_path_ignore_event_data_t` | Emitted for each input path that could not be resolved to a repository-relative path |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     */
    val lore_file_dirty: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dirty",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dirty`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_PATH_IGNORE` | `lore_path_ignore_event_data_t` | Emitted for each input path that could not be resolved to a repository-relative path |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     */
    val lore_file_dirty_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dirty_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Mark a file as dirty-copied from one path to another in the staged state.
     * 
     * Creates a new destination node flagged `DirtyCopy`; the source node is unchanged.
     * No filesystem access is performed.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_file_dirty_copy: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dirty_copy",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dirty_copy`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_file_dirty_copy_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dirty_copy_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Mark a file as dirty-moved from one path to another in the staged state.
     * 
     * Updates the source node's parent/name and flags it with `DirtyMove`, propagating
     * `Dirty` to both the old and new parent directories. For directories, the move
     * is propagated recursively to children. No filesystem access is performed.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_file_dirty_move: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dirty_move",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dirty_move`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_file_dirty_move_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dirty_move_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve the binary content of a file at a specific revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DUMP` | `lore_file_dump_event_data_t` | Emitted with binary content of the requested file |
     */
    val lore_file_dump: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dump",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_dump`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_DUMP` | `lore_file_dump_event_data_t` | Emitted with binary content of the requested file |
     */
    val lore_file_dump_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_dump_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Compute the hash of a local file for comparison with repository content.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_HASH` | `lore_file_hash_event_data_t` | Emitted with the computed hash and size of the specified file |
     */
    val lore_file_hash: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_hash",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_hash`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_HASH` | `lore_file_hash_event_data_t` | Emitted with the computed hash and size of the specified file |
     */
    val lore_file_hash_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_hash_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve the revision history for a specific file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_HISTORY` | `lore_file_history_event_data_t` | Emitted for each revision in which the file was modified |
     */
    val lore_file_history: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_history",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_history`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_HISTORY` | `lore_file_history_event_data_t` | Emitted for each revision in which the file was modified |
     */
    val lore_file_history_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_history_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve metadata for one or more files in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_INFO` | `lore_file_info_event_data_t` | Emitted for each file with its metadata (size, hash, staged status, etc.) |
     */
    val lore_file_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_info`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_INFO` | `lore_file_info_event_data_t` | Emitted for each file with its metadata (size, hash, staged status, etc.) |
     */
    val lore_file_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Clear all metadata from a file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA_CLEAR_FILE` | `lore_metadata_clear_file_event_data_t` | Emitted when metadata has been cleared for the file |
     */
    val lore_file_metadata_clear: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_clear",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_metadata_clear`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA_CLEAR_FILE` | `lore_metadata_clear_file_event_data_t` | Emitted when metadata has been cleared for the file |
     */
    val lore_file_metadata_clear_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_clear_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Get a specific metadata key/value pair from a file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for the requested metadata key/value pair |
     */
    val lore_file_metadata_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_metadata_get`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for the requested metadata key/value pair |
     */
    val lore_file_metadata_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all metadata key/value pairs associated with a file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata key/value pair associated with the file |
     */
    val lore_file_metadata_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_metadata_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata key/value pair associated with the file |
     */
    val lore_file_metadata_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set a metadata key/value pair on a file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_file_metadata_set: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_set",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_metadata_set`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_file_metadata_set_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_metadata_set_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Permanently remove a file and all its history from the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_OBLITERATE` | `lore_file_obliterate_event_data_t` | Emitted for each file permanently removed from repository history |
     */
    val lore_file_obliterate: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_obliterate",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_obliterate`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_OBLITERATE` | `lore_file_obliterate_event_data_t` | Emitted for each file permanently removed from repository history |
     */
    val lore_file_obliterate_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_obliterate_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Reset files to the state recorded in the current or target revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_RESET_BEGIN` | `lore_file_reset_begin_event_data_t` | Emitted when reset starts, includes path count |
     * | `LORE_EVENT_FILE_RESET_PROGRESS` | `lore_file_reset_progress_event_data_t` | Emitted periodically during file reset with progress counts |
     * | `LORE_EVENT_FILE_RESET_END` | `lore_file_reset_end_event_data_t` | Emitted when reset completes |
     * | `LORE_EVENT_FILE_RESET_FILE` | `lore_file_reset_file_event_data_t` | Emitted for each file that was reset |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file materialized |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by filters |
     */
    val lore_file_reset: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_reset",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_reset`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_RESET_BEGIN` | `lore_file_reset_begin_event_data_t` | Emitted when reset starts, includes path count |
     * | `LORE_EVENT_FILE_RESET_PROGRESS` | `lore_file_reset_progress_event_data_t` | Emitted periodically during file reset with progress counts |
     * | `LORE_EVENT_FILE_RESET_END` | `lore_file_reset_end_event_data_t` | Emitted when reset completes |
     * | `LORE_EVENT_FILE_RESET_FILE` | `lore_file_reset_file_event_data_t` | Emitted for each file that was reset |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file materialized |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by filters |
     */
    val lore_file_reset_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_reset_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Reset files to their state at the last merged revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_RESET_BEGIN` | `lore_file_reset_begin_event_data_t` | Emitted when reset starts |
     * | `LORE_EVENT_FILE_RESET_PROGRESS` | `lore_file_reset_progress_event_data_t` | Emitted periodically during file reset |
     * | `LORE_EVENT_FILE_RESET_END` | `lore_file_reset_end_event_data_t` | Emitted when reset completes |
     * | `LORE_EVENT_FILE_RESET_FILE` | `lore_file_reset_file_event_data_t` | Emitted for each file that was reset |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file materialized |
     */
    val lore_file_reset_to_last_merged: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_reset_to_last_merged",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_reset_to_last_merged`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_RESET_BEGIN` | `lore_file_reset_begin_event_data_t` | Emitted when reset starts |
     * | `LORE_EVENT_FILE_RESET_PROGRESS` | `lore_file_reset_progress_event_data_t` | Emitted periodically during file reset |
     * | `LORE_EVENT_FILE_RESET_END` | `lore_file_reset_end_event_data_t` | Emitted when reset completes |
     * | `LORE_EVENT_FILE_RESET_FILE` | `lore_file_reset_file_event_data_t` | Emitted for each file that was reset |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file materialized |
     */
    val lore_file_reset_to_last_merged_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_reset_to_last_merged_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Stage files for the next commit.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_STAGE_BEGIN` | `lore_file_stage_begin_event_data_t` | Emitted when staging begins, includes path count |
     * | `LORE_EVENT_FILE_STAGE_PROGRESS` | `lore_file_stage_progress_event_data_t` | Emitted periodically during staging with file counts |
     * | `LORE_EVENT_FILE_STAGE_END` | `lore_file_stage_end_event_data_t` | Emitted when staging completes |
     * | `LORE_EVENT_FILE_STAGE_REVISION` | `lore_file_stage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged or staged for deletion |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by filters |
     */
    val lore_file_stage: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_stage",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_stage`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_STAGE_BEGIN` | `lore_file_stage_begin_event_data_t` | Emitted when staging begins, includes path count |
     * | `LORE_EVENT_FILE_STAGE_PROGRESS` | `lore_file_stage_progress_event_data_t` | Emitted periodically during staging with file counts |
     * | `LORE_EVENT_FILE_STAGE_END` | `lore_file_stage_end_event_data_t` | Emitted when staging completes |
     * | `LORE_EVENT_FILE_STAGE_REVISION` | `lore_file_stage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged or staged for deletion |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by filters |
     */
    val lore_file_stage_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_stage_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Stage files for a merge commit, recording resolved merge content.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_STAGE_BEGIN` | `lore_file_stage_begin_event_data_t` | Emitted when merge-staging begins |
     * | `LORE_EVENT_FILE_STAGE_PROGRESS` | `lore_file_stage_progress_event_data_t` | Emitted periodically during merge-staging |
     * | `LORE_EVENT_FILE_STAGE_REVISION` | `lore_file_stage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged |
     */
    val lore_file_stage_merge: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_stage_merge",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_stage_merge`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_STAGE_BEGIN` | `lore_file_stage_begin_event_data_t` | Emitted when merge-staging begins |
     * | `LORE_EVENT_FILE_STAGE_PROGRESS` | `lore_file_stage_progress_event_data_t` | Emitted periodically during merge-staging |
     * | `LORE_EVENT_FILE_STAGE_REVISION` | `lore_file_stage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged |
     */
    val lore_file_stage_merge_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_stage_merge_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Stage a file move (rename) operation for commit.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_STAGE_BEGIN` | `lore_file_stage_begin_event_data_t` | Emitted when move staging begins |
     * | `LORE_EVENT_FILE_STAGE_END` | `lore_file_stage_end_event_data_t` | Emitted when move staging completes |
     * | `LORE_EVENT_FILE_STAGE_REVISION` | `lore_file_stage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged (deletion of original and new path) |
     */
    val lore_file_stage_move: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_stage_move",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_stage_move`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_STAGE_BEGIN` | `lore_file_stage_begin_event_data_t` | Emitted when move staging begins |
     * | `LORE_EVENT_FILE_STAGE_END` | `lore_file_stage_end_event_data_t` | Emitted when move staging completes |
     * | `LORE_EVENT_FILE_STAGE_REVISION` | `lore_file_stage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged (deletion of original and new path) |
     */
    val lore_file_stage_move_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_stage_move_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove files from the staging area without discarding local changes.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_UNSTAGE_BEGIN` | `lore_file_unstage_begin_event_data_t` | Emitted when unstage begins, includes path count |
     * | `LORE_EVENT_FILE_UNSTAGE_PROGRESS` | `lore_file_unstage_progress_event_data_t` | Emitted periodically during unstaging |
     * | `LORE_EVENT_FILE_UNSTAGE_END` | `lore_file_unstage_end_event_data_t` | Emitted when unstaging completes |
     * | `LORE_EVENT_FILE_UNSTAGE_REVISION` | `lore_file_unstage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_UNSTAGE_FILE` | `lore_file_unstage_file_event_data_t` | Emitted for each file that was unstaged |
     */
    val lore_file_unstage: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_unstage",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_unstage`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_UNSTAGE_BEGIN` | `lore_file_unstage_begin_event_data_t` | Emitted when unstage begins, includes path count |
     * | `LORE_EVENT_FILE_UNSTAGE_PROGRESS` | `lore_file_unstage_progress_event_data_t` | Emitted periodically during unstaging |
     * | `LORE_EVENT_FILE_UNSTAGE_END` | `lore_file_unstage_end_event_data_t` | Emitted when unstaging completes |
     * | `LORE_EVENT_FILE_UNSTAGE_REVISION` | `lore_file_unstage_revision_event_data_t` | Emitted with the resulting staged revision |
     * | `LORE_EVENT_FILE_UNSTAGE_FILE` | `lore_file_unstage_file_event_data_t` | Emitted for each file that was unstaged |
     */
    val lore_file_unstage_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_unstage_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Write binary content to a file in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_WRITE` | `lore_file_write_event_data_t` | Emitted when the file has been successfully written to the repository |
     */
    val lore_file_write: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_write",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_file_write`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## File Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_FILE_WRITE` | `lore_file_write_event_data_t` | Emitted when the file has been successfully written to the repository |
     */
    val lore_file_write_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_file_write_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Add a new layer to the repository configuration.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Layer Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LAYER_ADD` | `lore_layer_add_event_data_t` | Emitted when a layer has been successfully added |
     */
    val lore_layer_add: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_layer_add",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_layer_add`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Layer Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LAYER_ADD` | `lore_layer_add_event_data_t` | Emitted when a layer has been successfully added |
     */
    val lore_layer_add_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_layer_add_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all layers configured in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Layer Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LAYER_ENTRY` | `lore_layer_entry_event_data_t` | Emitted for each layer configured in the repository |
     */
    val lore_layer_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_layer_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_layer_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Layer Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LAYER_ENTRY` | `lore_layer_entry_event_data_t` | Emitted for each layer configured in the repository |
     */
    val lore_layer_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_layer_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove a layer from the repository configuration.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_layer_remove: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_layer_remove",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_layer_remove`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_layer_remove_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_layer_remove_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Add a link to another repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_CLONE_BEGIN` | `lore_repository_clone_begin_event_data_t` | Emitted when cloning a linked repository begins |
     * | `LORE_EVENT_REPOSITORY_CLONE_END` | `lore_repository_clone_end_event_data_t` | Emitted when cloning a linked repository completes |
     * | `LORE_EVENT_LINK_BRANCH_CREATE` | `lore_link_branch_create_event_data_t` | Emitted when branching is enabled, reporting whether the link's branch was created or an existing one reused |
     * | `LORE_EVENT_LINK_CHANGE` | `lore_link_change_event_data_t` | Emitted when the link has been added and saved |
     */
    val lore_link_add: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_add",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_link_add`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_CLONE_BEGIN` | `lore_repository_clone_begin_event_data_t` | Emitted when cloning a linked repository begins |
     * | `LORE_EVENT_REPOSITORY_CLONE_END` | `lore_repository_clone_end_event_data_t` | Emitted when cloning a linked repository completes |
     * | `LORE_EVENT_LINK_BRANCH_CREATE` | `lore_link_branch_create_event_data_t` | Emitted when branching is enabled, reporting whether the link's branch was created or an existing one reused |
     * | `LORE_EVENT_LINK_CHANGE` | `lore_link_change_event_data_t` | Emitted when the link has been added and saved |
     */
    val lore_link_add_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_add_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Report detailed information about a single repository link.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_INFO` | `lore_link_info_event_data_t` | Emitted once for the described link |
     */
    val lore_link_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_link_info`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_INFO` | `lore_link_info_event_data_t` | Emitted once for the described link |
     */
    val lore_link_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all repository links configured in the current repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_ENTRY` | `lore_link_entry_event_data_t` | Emitted for each linked repository |
     */
    val lore_link_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_link_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_ENTRY` | `lore_link_entry_event_data_t` | Emitted for each linked repository |
     */
    val lore_link_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List the links whose linked repositories hold staged changes, including nested links.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_STAGED_ENTRY` | `lore_link_staged_entry_event_data_t` | Emitted for each link with staged changes |
     */
    val lore_link_list_staged: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_list_staged",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_link_list_staged`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_STAGED_ENTRY` | `lore_link_staged_entry_event_data_t` | Emitted for each link with staged changes |
     */
    val lore_link_list_staged_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_list_staged_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove a link to another repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_CHANGE` | `lore_link_change_event_data_t` | Emitted when the link has been removed |
     */
    val lore_link_remove: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_remove",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_link_remove`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_CHANGE` | `lore_link_change_event_data_t` | Emitted when the link has been removed |
     */
    val lore_link_remove_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_remove_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Update properties of an existing repository link.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_CHANGE` | `lore_link_change_event_data_t` | Emitted when a link property is updated or finalized |
     */
    val lore_link_update: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_update",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_link_update`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Link Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LINK_CHANGE` | `lore_link_change_event_data_t` | Emitted when a link property is updated or finalized |
     */
    val lore_link_update_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_link_update_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Acquire exclusive locks on one or more files in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_ACQUIRE` | `lore_lock_file_acquire_event_data_t` | Emitted for each file for which a lock was successfully acquired |
     * | `LORE_EVENT_LOCK_FILE_ACQUIRE_IGNORE` | `lore_lock_file_acquire_ignore_event_data_t` | Emitted for each file for which a lock was ignored (already owned) |
     */
    val lore_lock_file_acquire: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_acquire",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_lock_file_acquire`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_ACQUIRE` | `lore_lock_file_acquire_event_data_t` | Emitted for each file for which a lock was successfully acquired |
     * | `LORE_EVENT_LOCK_FILE_ACQUIRE_IGNORE` | `lore_lock_file_acquire_ignore_event_data_t` | Emitted for each file for which a lock was ignored (already owned) |
     */
    val lore_lock_file_acquire_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_acquire_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Query which files are currently locked, optionally filtered by user or path.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_QUERY_BEGIN` | `lore_lock_file_query_begin_event_data_t` | Emitted before query results begin streaming |
     * | `LORE_EVENT_LOCK_FILE_QUERY` | `lore_lock_file_query_event_data_t` | Emitted for each file matching the query |
     */
    val lore_lock_file_query: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_query",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_lock_file_query`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_QUERY_BEGIN` | `lore_lock_file_query_begin_event_data_t` | Emitted before query results begin streaming |
     * | `LORE_EVENT_LOCK_FILE_QUERY` | `lore_lock_file_query_event_data_t` | Emitted for each file matching the query |
     */
    val lore_lock_file_query_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_query_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Release file locks previously acquired by this client.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_RELEASE` | `lore_lock_file_release_event_data_t` | Emitted for each file lock successfully released |
     * | `LORE_EVENT_LOCK_FILE_RELEASE_NOT_FOUND` | `lore_lock_file_release_not_found_event_data_t` | Emitted for each file whose lock was not found |
     */
    val lore_lock_file_release: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_release",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_lock_file_release`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_RELEASE` | `lore_lock_file_release_event_data_t` | Emitted for each file lock successfully released |
     * | `LORE_EVENT_LOCK_FILE_RELEASE_NOT_FOUND` | `lore_lock_file_release_not_found_event_data_t` | Emitted for each file whose lock was not found |
     */
    val lore_lock_file_release_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_release_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Get the lock status of files in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_STATUS_BEGIN` | `lore_lock_file_status_begin_event_data_t` | Emitted before lock status results begin streaming |
     * | `LORE_EVENT_LOCK_FILE_STATUS` | `lore_lock_file_status_event_data_t` | Emitted for each locked file with owner and lock details |
     */
    val lore_lock_file_status: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_status",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_lock_file_status`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Lock Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOCK_FILE_STATUS_BEGIN` | `lore_lock_file_status_begin_event_data_t` | Emitted before lock status results begin streaming |
     * | `LORE_EVENT_LOCK_FILE_STATUS` | `lore_lock_file_status_event_data_t` | Emitted for each locked file with owner and lock details |
     */
    val lore_lock_file_status_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_lock_file_status_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Apply the given logging configuration.
     * 
     * Returns 0 when the configuration was applied and a non-zero value when it
     * was not.
     */
    val lore_log_configure: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_log_configure",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS),
        )
    }

    /**
     * Subscribe to repository notifications.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Notification Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_NOTIFICATION_SUBSCRIBED` | `lore_notification_subscribed_event_data_t` | Emitted when successfully subscribed to repository notifications |
     * | `LORE_EVENT_NOTIFICATION_BRANCH_CREATED` | `lore_notification_branch_created_event_data_t` | Emitted when a branch is created in the repository (push notification) |
     * | `LORE_EVENT_NOTIFICATION_BRANCH_DELETED` | `lore_notification_branch_deleted_event_data_t` | Emitted when a branch is deleted in the repository (push notification) |
     * | `LORE_EVENT_NOTIFICATION_BRANCH_PUSHED` | `lore_notification_branch_pushed_event_data_t` | Emitted when a branch is pushed to (push notification) |
     * | `LORE_EVENT_NOTIFICATION_RESOURCE_LOCKED` | `lore_notification_resource_locked_event_data_t` | Emitted when a resource is locked (push notification) |
     * | `LORE_EVENT_NOTIFICATION_RESOURCE_UNLOCKED` | `lore_notification_resource_unlocked_event_data_t` | Emitted when a resource is unlocked (push notification) |
     */
    val lore_notification_subscribe: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_notification_subscribe",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_notification_subscribe`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Notification Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_NOTIFICATION_SUBSCRIBED` | `lore_notification_subscribed_event_data_t` | Emitted when successfully subscribed to repository notifications |
     * | `LORE_EVENT_NOTIFICATION_BRANCH_CREATED` | `lore_notification_branch_created_event_data_t` | Emitted when a branch is created in the repository (push notification) |
     * | `LORE_EVENT_NOTIFICATION_BRANCH_DELETED` | `lore_notification_branch_deleted_event_data_t` | Emitted when a branch is deleted in the repository (push notification) |
     * | `LORE_EVENT_NOTIFICATION_BRANCH_PUSHED` | `lore_notification_branch_pushed_event_data_t` | Emitted when a branch is pushed to (push notification) |
     * | `LORE_EVENT_NOTIFICATION_RESOURCE_LOCKED` | `lore_notification_resource_locked_event_data_t` | Emitted when a resource is locked (push notification) |
     * | `LORE_EVENT_NOTIFICATION_RESOURCE_UNLOCKED` | `lore_notification_resource_unlocked_event_data_t` | Emitted when a resource is unlocked (push notification) |
     */
    val lore_notification_subscribe_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_notification_subscribe_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Unsubscribe from repository notifications.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Notification Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_NOTIFICATION_UNSUBSCRIBED` | `lore_notification_unsubscribed_event_data_t` | Emitted when successfully unsubscribed from repository notifications |
     */
    val lore_notification_unsubscribe: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_notification_unsubscribe",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_notification_unsubscribe`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Notification Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_NOTIFICATION_UNSUBSCRIBED` | `lore_notification_unsubscribed_event_data_t` | Emitted when successfully unsubscribed from repository notifications |
     */
    val lore_notification_unsubscribe_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_notification_unsubscribe_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Clone a remote repository to a local path.
     * 
     * A clone needs the remote, so the `offline` global argument does not keep it from connecting: it
     * prepares the clone for working offline instead. With `offline` or `cache`, a clone that writes
     * its files caches every file metadata block of the cloned revision, which staging and committing
     * write to, so both work without the remote, and fails if it cannot. A bare clone writes no files
     * and reads them from the remote when a call needs them.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_CLONE_BEGIN` | `lore_repository_clone_begin_event_data_t` | Emitted when clone begins, includes remote URL and target path |
     * | `LORE_EVENT_REPOSITORY_CLONE_PROGRESS` | `lore_repository_clone_progress_event_data_t` | Emitted periodically during clone with progress data |
     * | `LORE_EVENT_REPOSITORY_CLONE_END` | `lore_repository_clone_end_event_data_t` | Emitted only when the clone succeeds; `LORE_EVENT_COMPLETE` reports the outcome of every clone |
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted after resolving the target revision to sync during clone |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file written during initial sync |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during initial file sync |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted with the resulting revision |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view filters |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written to the local store |
     */
    val lore_repository_clone: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_clone",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_clone`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_CLONE_BEGIN` | `lore_repository_clone_begin_event_data_t` | Emitted when clone begins, includes remote URL and target path |
     * | `LORE_EVENT_REPOSITORY_CLONE_PROGRESS` | `lore_repository_clone_progress_event_data_t` | Emitted periodically during clone with progress data |
     * | `LORE_EVENT_REPOSITORY_CLONE_END` | `lore_repository_clone_end_event_data_t` | Emitted only when the clone succeeds; `LORE_EVENT_COMPLETE` reports the outcome of every clone |
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted after resolving the target revision to sync during clone |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file written during initial sync |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during initial file sync |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted with the resulting revision |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view filters |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written to the local store |
     */
    val lore_repository_clone_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_clone_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read a configuration value of the current repository by key.
     */
    val lore_repository_config_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_config_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_config_get`.
     */
    val lore_repository_config_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_config_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Create a new Lore repository on the remote server.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_CREATE` | `lore_repository_create_event_data_t` | Emitted when the repository has been successfully created |
     */
    val lore_repository_create: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_create",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_create`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_CREATE` | `lore_repository_create_event_data_t` | Emitted when the repository has been successfully created |
     */
    val lore_repository_create_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_create_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Delete a Lore repository on the remote server.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_delete: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_delete",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_delete`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_delete_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_delete_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Dump the internal state of the repository for diagnostic purposes.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_DUMP_BEGIN` | `lore_repository_dump_begin_event_data_t` | Emitted before dump output begins |
     * | `LORE_EVENT_REPOSITORY_DUMP_END` | `lore_repository_dump_end_event_data_t` | Emitted when dump completes |
     * | `LORE_EVENT_REPOSITORY_STATE_DUMP` | `lore_repository_state_dump_event_data_t` | Emitted with repository state summary |
     * | `LORE_EVENT_REPOSITORY_STATE_DUMP_NODE` | `lore_repository_state_dump_node_event_data_t` | Emitted for each node in the state tree |
     */
    val lore_repository_dump: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_dump",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_dump`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_DUMP_BEGIN` | `lore_repository_dump_begin_event_data_t` | Emitted before dump output begins |
     * | `LORE_EVENT_REPOSITORY_DUMP_END` | `lore_repository_dump_end_event_data_t` | Emitted when dump completes |
     * | `LORE_EVENT_REPOSITORY_STATE_DUMP` | `lore_repository_state_dump_event_data_t` | Emitted with repository state summary |
     * | `LORE_EVENT_REPOSITORY_STATE_DUMP_NODE` | `lore_repository_state_dump_node_event_data_t` | Emitted for each node in the state tree |
     */
    val lore_repository_dump_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_dump_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Flush pending repository state to persistent storage.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_flush: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_flush",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_flush`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_flush_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_flush_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Run garbage collection to reclaim unreferenced storage in the repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_gc: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_gc",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_gc`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_gc_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_gc_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve metadata about the current repository.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_DATA` | `lore_repository_data_event_data_t` | Emitted with repository metadata (name, URL, branch info, etc.) |
     */
    val lore_repository_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_info`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_DATA` | `lore_repository_data_event_data_t` | Emitted with repository metadata (name, URL, branch info, etc.) |
     */
    val lore_repository_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List the tracked instances of the repository.
     */
    val lore_repository_instance_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_instance_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_instance_list`.
     */
    val lore_repository_instance_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_instance_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove stale instances of the repository: those whose path no longer
     * exists, those whose path holds no checkout, and those whose path now holds
     * a repository naming a different current instance. Each removed instance is
     * reported through a `RepositoryInstance` event whose `stale` field gives the
     * reason.
     */
    val lore_repository_instance_prune: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_instance_prune",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_instance_prune`.
     */
    val lore_repository_instance_prune_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_instance_prune_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all repositories available on the remote server.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_LIST_ENTRY` | `lore_repository_list_entry_event_data_t` | Emitted for each repository found |
     */
    val lore_repository_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_LIST_ENTRY` | `lore_repository_list_entry_event_data_t` | Emitted for each repository found |
     */
    val lore_repository_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Clear repository metadata keys. Clears all user-defined keys when none are
     * given.
     */
    val lore_repository_metadata_clear: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_metadata_clear",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_metadata_clear`.
     */
    val lore_repository_metadata_clear_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_metadata_clear_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve repository metadata. Reads a single key, or all entries when no
     * key is given.
     */
    val lore_repository_metadata_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_metadata_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_metadata_get`.
     */
    val lore_repository_metadata_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_metadata_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set repository metadata key-value pairs.
     */
    val lore_repository_metadata_set: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_metadata_set",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_metadata_set`.
     */
    val lore_repository_metadata_set_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_metadata_set_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Release all cached store references for the given repository path.
     * 
     * Frees cached in-memory store data. Disk-backed stores are not forced closed:
     * each is released once nothing uses it, and a later open reuses one that is still
     * alive, which the store epoch keeps current with what other processes wrote.
     * Any active repository contexts for this path remain valid.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_release: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_release",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_release`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_repository_release_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_release_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Show the working directory status, including staged, dirty, and conflicted files.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_STATUS_REVISION` | `lore_repository_status_revision_event_data_t` | Emitted with current and staged revision info |
     * | `LORE_EVENT_REPOSITORY_STATUS_FILE` | `lore_repository_status_file_event_data_t` | Emitted for each file with pending changes, conflict status, or untracked status |
     * | `LORE_EVENT_PATH_IGNORE` | `lore_path_ignore_event_data_t` | Emitted for each path excluded by ignore rules |
     */
    val lore_repository_status: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_status",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_status`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_STATUS_REVISION` | `lore_repository_status_revision_event_data_t` | Emitted with current and staged revision info |
     * | `LORE_EVENT_REPOSITORY_STATUS_FILE` | `lore_repository_status_file_event_data_t` | Emitted for each file with pending changes, conflict status, or untracked status |
     * | `LORE_EVENT_PATH_IGNORE` | `lore_path_ignore_event_data_t` | Emitted for each path excluded by ignore rules |
     */
    val lore_repository_status_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_status_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Query the repository's immutable fragment store.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_STORE_IMMUTABLE_QUERY` | `lore_repository_store_immutable_query_event_data_t` | Emitted for each fragment entry found in the immutable store |
     */
    val lore_repository_store_immutable_query: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_store_immutable_query",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_store_immutable_query`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_STORE_IMMUTABLE_QUERY` | `lore_repository_store_immutable_query_event_data_t` | Emitted for each fragment entry found in the immutable store |
     */
    val lore_repository_store_immutable_query_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_store_immutable_query_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Update the recorded path of the current repository instance to its present
     * location.
     */
    val lore_repository_update_path: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_update_path",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_update_path`.
     */
    val lore_repository_update_path_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_update_path_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Verify the integrity of the repository's stored fragments.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_VERIFY_STATE_BEGIN` | `lore_repository_verify_state_begin_event_data_t` | Emitted when verify begins |
     * | `LORE_EVENT_REPOSITORY_VERIFY_STATE_END` | `lore_repository_verify_state_end_event_data_t` | Emitted when verify completes (success or with errors) |
     * | `LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT` | `lore_repository_verify_fragment_event_data_t` | Emitted for each fragment verified in the local store |
     * | `LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT_REMOTE` | `lore_repository_verify_fragment_remote_event_data_t` | Emitted for each fragment verified against the remote store |
     */
    val lore_repository_verify_state: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_verify_state",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_repository_verify_state`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Repository Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REPOSITORY_VERIFY_STATE_BEGIN` | `lore_repository_verify_state_begin_event_data_t` | Emitted when verify begins |
     * | `LORE_EVENT_REPOSITORY_VERIFY_STATE_END` | `lore_repository_verify_state_end_event_data_t` | Emitted when verify completes (success or with errors) |
     * | `LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT` | `lore_repository_verify_fragment_event_data_t` | Emitted for each fragment verified in the local store |
     * | `LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT_REMOTE` | `lore_repository_verify_fragment_remote_event_data_t` | Emitted for each fragment verified against the remote store |
     */
    val lore_repository_verify_state_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_repository_verify_state_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Amend the most recent revision with updated metadata.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the amended revision details |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the amended revision |
     */
    val lore_revision_amend: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_amend",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_amend`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the amended revision details |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the amended revision |
     */
    val lore_revision_amend_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_amend_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Take one step of a bisect between two revisions, synchronizing the working directory to the
     * revision halfway between them.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Bisect Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_BISECT` | `lore_revision_bisect_event_data_t` | Emitted once the working directory is synchronized to the selected revision, with the revision numbers of the range and whether the search is done |
     * 
     * ## Sync Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted once after resolving the selected revision |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file deleted, modified, added, or merged during sync |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during file realization and once at completion |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted once at the end with the resulting revision |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     */
    val lore_revision_bisect: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_bisect",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_bisect`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Bisect Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_BISECT` | `lore_revision_bisect_event_data_t` | Emitted once the working directory is synchronized to the selected revision, with the revision numbers of the range and whether the search is done |
     * 
     * ## Sync Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted once after resolving the selected revision |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file deleted, modified, added, or merged during sync |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during file realization and once at completion |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted once at the end with the resulting revision |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     */
    val lore_revision_bisect_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_bisect_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Cherry-pick a revision onto the current branch, applying its changes to the working tree.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Cherry-Pick Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_CHERRY_PICK_START_BEGIN` | `lore_cherry_pick_start_begin_event_data_t` | Emitted when cherry-pick begins, includes picked revision info |
     * | `LORE_EVENT_CHERRY_PICK_START_END` | `lore_cherry_pick_start_end_event_data_t` | Emitted when cherry-pick completes, includes conflict flag |
     * | `LORE_EVENT_CHERRY_PICK_CONFLICT_FILE` | `lore_cherry_pick_conflict_file_event_data_t` | Emitted for each file with an unresolved cherry-pick conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted while the picked changes are applied |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified during cherry-pick realization |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during cherry-pick |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed cherry-pick revision |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the auto-commit |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for fragments written during auto-commit |
     */
    val lore_revision_cherry_pick: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_cherry_pick",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_cherry_pick`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Cherry-Pick Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_CHERRY_PICK_START_BEGIN` | `lore_cherry_pick_start_begin_event_data_t` | Emitted when cherry-pick begins, includes picked revision info |
     * | `LORE_EVENT_CHERRY_PICK_START_END` | `lore_cherry_pick_start_end_event_data_t` | Emitted when cherry-pick completes, includes conflict flag |
     * | `LORE_EVENT_CHERRY_PICK_CONFLICT_FILE` | `lore_cherry_pick_conflict_file_event_data_t` | Emitted for each file with an unresolved cherry-pick conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted while the picked changes are applied |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified during cherry-pick realization |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during cherry-pick |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed cherry-pick revision |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the auto-commit |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for fragments written during auto-commit |
     */
    val lore_revision_cherry_pick_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_cherry_pick_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Commit staged files to create a new revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when commit begins fragmenting files |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted periodically during commit with file processing counts |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when commit file processing completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revision details (hash, branch, parents) |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the committed revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written or deduplicated |
     */
    val lore_revision_commit: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_commit",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_commit`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when commit begins fragmenting files |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted periodically during commit with file processing counts |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when commit file processing completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revision details (hash, branch, parents) |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata entry of the committed revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written or deduplicated |
     */
    val lore_revision_commit_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_commit_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Show files that differ between two revisions.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_DIFF_FILE` | `lore_revision_diff_file_event_data_t` | Emitted for each file that differs between the two revisions |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision number |
     */
    val lore_revision_diff: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_diff",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_diff`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_DIFF_FILE` | `lore_revision_diff_file_event_data_t` | Emitted for each file that differs between the two revisions |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision number |
     */
    val lore_revision_diff_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_diff_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Find a revision by metadata or revision number.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_FIND` | `lore_revision_find_event_data_t` | Emitted when a matching revision is found (exact or partial match) |
     */
    val lore_revision_find: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_find",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_find`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_FIND` | `lore_revision_find_event_data_t` | Emitted when a matching revision is found (exact or partial match) |
     */
    val lore_revision_find_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_find_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve the revision history of the current branch.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_HISTORY` | `lore_revision_history_event_data_t` | Emitted once with summary info before entries stream |
     * | `LORE_EVENT_REVISION_HISTORY_ENTRY` | `lore_revision_history_entry_event_data_t` | Emitted for each revision in the history |
     */
    val lore_revision_history: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_history",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_history`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_HISTORY` | `lore_revision_history_event_data_t` | Emitted once with summary info before entries stream |
     * | `LORE_EVENT_REVISION_HISTORY_ENTRY` | `lore_revision_history_entry_event_data_t` | Emitted for each revision in the history |
     */
    val lore_revision_history_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_history_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve metadata and delta information about a specific revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_INFO` | `lore_revision_info_event_data_t` | Emitted with revision metadata (hash, branch, parents, file count, etc.) |
     * | `LORE_EVENT_REVISION_INFO_DELTA` | `lore_revision_info_delta_event_data_t` | Emitted with delta information between revision and its parent (when delta=true) |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata key/value of the revision (when metadata=true) |
     */
    val lore_revision_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_info`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_INFO` | `lore_revision_info_event_data_t` | Emitted with revision metadata (hash, branch, parents, file count, etc.) |
     * | `LORE_EVENT_REVISION_INFO_DELTA` | `lore_revision_info_delta_event_data_t` | Emitted with delta information between revision and its parent (when delta=true) |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata key/value of the revision (when metadata=true) |
     */
    val lore_revision_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Clear all metadata from the current revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA_CLEAR_REVISION` | `lore_metadata_clear_revision_event_data_t` | Emitted when metadata has been cleared for the current revision |
     */
    val lore_revision_metadata_clear: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_clear",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_metadata_clear`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA_CLEAR_REVISION` | `lore_metadata_clear_revision_event_data_t` | Emitted when metadata has been cleared for the current revision |
     */
    val lore_revision_metadata_clear_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_clear_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Get a specific metadata key/value pair from the current revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted with the requested key/value for the revision |
     */
    val lore_revision_metadata_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_metadata_get`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted with the requested key/value for the revision |
     */
    val lore_revision_metadata_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List all metadata key/value pairs associated with the current revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata key/value associated with the revision |
     */
    val lore_revision_metadata_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_metadata_list`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for each metadata key/value associated with the revision |
     */
    val lore_revision_metadata_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set a metadata key/value pair on the current revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_revision_metadata_set: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_set",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_metadata_set`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_revision_metadata_set_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_metadata_set_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Restore the working directory to a previously committed revision.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_RESTORE_FILE_BEGIN` | `lore_revision_restore_file_begin_event_data_t` | Emitted when restore starts processing files |
     * | `LORE_EVENT_REVISION_RESTORE_FILE` | `lore_revision_restore_file_event_data_t` | Emitted for each file being restored |
     * | `LORE_EVENT_REVISION_RESTORE_FILE_END` | `lore_revision_restore_file_end_event_data_t` | Emitted when file processing completes |
     * | `LORE_EVENT_REVISION_RESTORE_FRAGMENT_BEGIN` | `lore_revision_restore_fragment_begin_event_data_t` | Emitted when fragment download begins for a file |
     * | `LORE_EVENT_REVISION_RESTORE_FRAGMENT_PROGRESS` | `lore_revision_restore_fragment_progress_event_data_t` | Emitted periodically during fragment download |
     * | `LORE_EVENT_REVISION_RESTORE_FRAGMENT_END` | `lore_revision_restore_fragment_end_event_data_t` | Emitted when fragment download completes |
     * | `LORE_EVENT_REVISION_RESTORE_REVISION` | `lore_revision_restore_revision_event_data_t` | Emitted with the restored revision details |
     * | `LORE_EVENT_REVISION_RESTORE_SYNC_BEGIN` | `lore_revision_restore_sync_begin_event_data_t` | Emitted when starting to apply the changes on the target state |
     * | `LORE_EVENT_REVISION_RESTORE_SYNC_END` | `lore_revision_restore_sync_end_event_data_t` | Emitted after applying the changes on the target state is complete |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit of restored revision starts |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed restored revision |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during changes realization |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the restored revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for fragments written during restore commit |
     */
    val lore_revision_restore: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_restore",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_restore`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revision Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_RESTORE_FILE_BEGIN` | `lore_revision_restore_file_begin_event_data_t` | Emitted when restore starts processing files |
     * | `LORE_EVENT_REVISION_RESTORE_FILE` | `lore_revision_restore_file_event_data_t` | Emitted for each file being restored |
     * | `LORE_EVENT_REVISION_RESTORE_FILE_END` | `lore_revision_restore_file_end_event_data_t` | Emitted when file processing completes |
     * | `LORE_EVENT_REVISION_RESTORE_FRAGMENT_BEGIN` | `lore_revision_restore_fragment_begin_event_data_t` | Emitted when fragment download begins for a file |
     * | `LORE_EVENT_REVISION_RESTORE_FRAGMENT_PROGRESS` | `lore_revision_restore_fragment_progress_event_data_t` | Emitted periodically during fragment download |
     * | `LORE_EVENT_REVISION_RESTORE_FRAGMENT_END` | `lore_revision_restore_fragment_end_event_data_t` | Emitted when fragment download completes |
     * | `LORE_EVENT_REVISION_RESTORE_REVISION` | `lore_revision_restore_revision_event_data_t` | Emitted with the restored revision details |
     * | `LORE_EVENT_REVISION_RESTORE_SYNC_BEGIN` | `lore_revision_restore_sync_begin_event_data_t` | Emitted when sync begins |
     * | `LORE_EVENT_REVISION_RESTORE_SYNC_END` | `lore_revision_restore_sync_end_event_data_t` | Emitted when sync completes |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit of restored revision starts |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed restored revision |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during changes realization |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the restored revision |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for fragments written during restore commit |
     */
    val lore_revision_restore_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_restore_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Revert a revision, applying its inverse changes to the working tree.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_START_BEGIN` | `lore_revert_start_begin_event_data_t` | Emitted when revert begins, includes target revision info |
     * | `LORE_EVENT_REVERT_START_END` | `lore_revert_start_end_event_data_t` | Emitted when revert completes, includes conflict flag |
     * | `LORE_EVENT_REVERT_CONFLICT_FILE` | `lore_revert_conflict_file_event_data_t` | Emitted for each file with an unresolved revert conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during apply_diff phase |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified during revert realization |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during revert |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revert revision |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the auto-commit |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for fragments written during auto-commit |
     */
    val lore_revision_revert: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Abort an in-progress revert operation and restore the previous state.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_ABORT_BEGIN` | `lore_revert_abort_begin_event_data_t` | Emitted when revert abort begins |
     * | `LORE_EVENT_REVERT_ABORT_END` | `lore_revert_abort_end_event_data_t` | Emitted when revert abort completes |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization while reverting |
     */
    val lore_revision_revert_abort: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_abort",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert_abort`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_ABORT_BEGIN` | `lore_revert_abort_begin_event_data_t` | Emitted when revert abort begins |
     * | `LORE_EVENT_REVERT_ABORT_END` | `lore_revert_abort_end_event_data_t` | Emitted when revert abort completes |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization while reverting |
     */
    val lore_revision_revert_abort_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_abort_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_START_BEGIN` | `lore_revert_start_begin_event_data_t` | Emitted when revert begins, includes target revision info |
     * | `LORE_EVENT_REVERT_START_END` | `lore_revert_start_end_event_data_t` | Emitted when revert completes, includes conflict flag |
     * | `LORE_EVENT_REVERT_CONFLICT_FILE` | `lore_revert_conflict_file_event_data_t` | Emitted for each file with an unresolved revert conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during apply_diff phase |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file modified during revert realization |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during revert |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-commit starts (no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed revert revision |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the auto-commit |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for fragments written during auto-commit |
     */
    val lore_revision_revert_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a revert conflict by marking conflicting files as resolved.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_RESOLVE_FILE` | `lore_revert_resolve_file_event_data_t` | Emitted for each file marked as resolved |
     * | `LORE_EVENT_REVERT_RESOLVE_REVISION` | `lore_revert_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_resolve: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_resolve",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert_resolve`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_RESOLVE_FILE` | `lore_revert_resolve_file_event_data_t` | Emitted for each file marked as resolved |
     * | `LORE_EVENT_REVERT_RESOLVE_REVISION` | `lore_revert_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_resolve_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_resolve_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a revert conflict by accepting the "mine" version of each conflicting file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_RESOLVE_FILE` | `lore_revert_resolve_file_event_data_t` | Emitted for each file resolved by keeping "mine" |
     * | `LORE_EVENT_REVERT_RESOLVE_REVISION` | `lore_revert_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_resolve_mine: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_resolve_mine",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert_resolve_mine`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_RESOLVE_FILE` | `lore_revert_resolve_file_event_data_t` | Emitted for each file resolved by keeping "mine" |
     * | `LORE_EVENT_REVERT_RESOLVE_REVISION` | `lore_revert_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_resolve_mine_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_resolve_mine_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a revert conflict by accepting the "theirs" version of each conflicting file.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_RESOLVE_FILE` | `lore_revert_resolve_file_event_data_t` | Emitted for each file resolved by keeping "theirs" |
     * | `LORE_EVENT_REVERT_RESOLVE_REVISION` | `lore_revert_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_resolve_theirs: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_resolve_theirs",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert_resolve_theirs`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_RESOLVE_FILE` | `lore_revert_resolve_file_event_data_t` | Emitted for each file resolved by keeping "theirs" |
     * | `LORE_EVENT_REVERT_RESOLVE_REVISION` | `lore_revert_resolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_resolve_theirs_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_resolve_theirs_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Restart a revert operation, re-materializing files with conflicts.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_CONFLICT_FILE` | `lore_revert_conflict_file_event_data_t` | Emitted for each file with a remaining revert conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file re-materialized |
     */
    val lore_revision_revert_restart: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_restart",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert_restart`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_CONFLICT_FILE` | `lore_revert_conflict_file_event_data_t` | Emitted for each file with a remaining revert conflict |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted during file realization |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file re-materialized |
     */
    val lore_revision_revert_restart_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_restart_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Mark conflicting files in a revert operation as unresolved.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_UNRESOLVE_FILE` | `lore_revert_unresolve_file_event_data_t` | Emitted for each file marked as unresolved |
     * | `LORE_EVENT_REVERT_UNRESOLVE_REVISION` | `lore_revert_unresolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_unresolve: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_unresolve",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_revert_unresolve`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Revert Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVERT_UNRESOLVE_FILE` | `lore_revert_unresolve_file_event_data_t` | Emitted for each file marked as unresolved |
     * | `LORE_EVENT_REVERT_UNRESOLVE_REVISION` | `lore_revert_unresolve_revision_event_data_t` | Emitted with the updated staged revision |
     */
    val lore_revision_revert_unresolve_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_revert_unresolve_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Synchronize the working directory to a target revision, optionally merging divergent branches.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Sync Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted once after resolving the target revision with source/target revision info, branch, and remote URL |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file deleted, modified, added, or merged during sync |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during file realization and once at completion with cumulative update/delete/automerge/conflict counts |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted once at the end with the resulting revision, branch, and merge/conflict flags |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision number |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     * | `LORE_EVENT_BRANCH_MERGE_START_BEGIN` | `lore_branch_merge_start_begin_event_data_t` | Emitted when an auto-merge is initiated (diverged branches) |
     * | `LORE_EVENT_BRANCH_MERGE_START_END` | `lore_branch_merge_start_end_event_data_t` | Emitted when the auto-merge operation completes |
     * | `LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE` | `lore_branch_merge_conflict_file_event_data_t` | Emitted for each file with an unresolved merge conflict |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-merge auto-commits (no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed merge revision |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the auto-merge commit |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written during auto-merge commit |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during merge realization |
     */
    val lore_revision_sync: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_sync",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_revision_sync`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Sync Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_REVISION_SYNC_TARGET` | `lore_revision_sync_target_event_data_t` | Emitted once after resolving the target revision with source/target revision info, branch, and remote URL |
     * | `LORE_EVENT_REVISION_SYNC_FILE` | `lore_revision_sync_file_event_data_t` | Emitted for each file deleted, modified, added, or merged during sync |
     * | `LORE_EVENT_REVISION_SYNC_PROGRESS` | `lore_revision_sync_progress_event_data_t` | Emitted periodically during file realization and once at completion with cumulative update/delete/automerge/conflict counts |
     * | `LORE_EVENT_REVISION_SYNC_REVISION` | `lore_revision_sync_revision_event_data_t` | Emitted once at the end with the resulting revision, branch, and merge/conflict flags |
     * | `LORE_EVENT_REVISION_RESOLVE` | `lore_revision_resolve_event_data_t` | Emitted when resolving a revision number |
     * | `LORE_EVENT_FILTER_EXCLUDE` | `lore_filter_exclude_event_data_t` | Emitted for each path excluded by view or ignore filters |
     * | `LORE_EVENT_BRANCH_MERGE_START_BEGIN` | `lore_branch_merge_start_begin_event_data_t` | Emitted when an auto-merge is initiated (diverged branches) |
     * | `LORE_EVENT_BRANCH_MERGE_START_END` | `lore_branch_merge_start_end_event_data_t` | Emitted when the auto-merge operation completes |
     * | `LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE` | `lore_branch_merge_conflict_file_event_data_t` | Emitted for each file with an unresolved merge conflict |
     * | `LORE_EVENT_REVISION_COMMIT_BEGIN` | `lore_revision_commit_begin_event_data_t` | Emitted when auto-merge auto-commits (no conflicts) |
     * | `LORE_EVENT_REVISION_COMMIT_PROGRESS` | `lore_revision_commit_progress_event_data_t` | Emitted during auto-commit |
     * | `LORE_EVENT_REVISION_COMMIT_END` | `lore_revision_commit_end_event_data_t` | Emitted when auto-commit completes |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION` | `lore_revision_commit_revision_event_data_t` | Emitted with the committed merge revision |
     * | `LORE_EVENT_METADATA` | `lore_metadata_event_data_t` | Emitted for metadata of the auto-merge commit |
     * | `LORE_EVENT_FRAGMENT_WRITE` | `lore_fragment_write_event_data_t` | Emitted for each fragment written during auto-merge commit |
     * | `LORE_EVENT_FILE_STAGE_FILE` | `lore_file_stage_file_event_data_t` | Emitted for each file staged for deletion during merge realization |
     */
    val lore_revision_sync_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_sync_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Add a batch of nodes to a loaded revision tree. An entry parents onto an
     * existing node or onto an earlier entry, so one call builds a subtree. Every
     * entry is checked before any node is created, so one bad entry rejects the
     * call and creates nothing; the reason names the offending entry's batch index,
     * which a caller leaving `entry_id` at zero has no other way to identify. A failure
     * after those checks pass is internal and may leave part of the batch created.
     * 
     * A link entry's target revision is not resolved here, so a link naming a
     * revision that cannot be read is accepted and fails only when something later
     * reads through it. Entries under separate parents are created concurrently,
     * but allocating a node slot is serialized per loaded tree.
     * 
     * | Terminal event                            | Payload                                          | Notes                                                    |
     * |-------------------------------------------|--------------------------------------------------|----------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_ADD_COMPLETE`   | `lore_revision_tree_add_complete_event_data_t`   | One per entry, carrying its `entry_id`                    |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE` | `lore_revision_tree_batch_complete_event_data_t` | Exactly one, carrying the `batch_id` and the call's outcome |
     */
    val lore_revision_tree_add: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_add",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Add a batch of nodes to a loaded revision tree (async variant).
     */
    val lore_revision_tree_add_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_add_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Release a memory-based revision tree handle.
     * 
     * Subsequent calls against the same handle return `InvalidArguments`. The
     * call blocks until every in-flight op on the handle has paired its
     * decrement. Closing a tree on a storage handle that is already closed
     * flushes what the tree wrote since, and closing the last one releases
     * what was keeping that handle's claim on its stores.
     * 
     * | Terminal event                              | Payload                                       | Notes                                              |
     * |---------------------------------------------|-----------------------------------------------|----------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_CLOSE_COMPLETE`   | `lore_revision_tree_close_complete_event_data_t` | Emitted on success carrying the caller id       |
     */
    val lore_revision_tree_close: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_close",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Release a memory-based revision tree handle (async variant).
     */
    val lore_revision_tree_close_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_close_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Freeze a loaded revision tree into a new revision and advance its branch tip.
     * 
     * **The branch is not an argument.** It is the revision's own, read from the
     * `branch` metadata key: set it with `lore_revision_tree_metadata_set` to start a
     * branch's history, and leave it unset to continue the loaded revision's branch. A
     * key that is set must name either the loaded revision's branch or a branch whose
     * branch point is exactly the loaded revision. A handle loaded from the zero
     * revision has no parent to read a branch from and must set the key.
     * 
     * The revision records exactly the metadata set on the handle — nothing is
     * inherited from the revision it was loaded on — plus the three facts about the
     * commit the caller did not supply: the branch, the timestamp if unset, and
     * `created-by` / `committed-by` if unset. The commit message is caller metadata like
     * any other: set `"message"` before committing.
     * 
     * On success the handle stays usable and now *is* the new revision: node ids
     * captured before the commit still resolve, and further edits commit on top. The
     * pending metadata is emptied, so the next revision starts fresh.
     * 
     * **A commit is all-or-nothing against the handle.** Either it succeeds and the
     * handle is consistent on the new revision, or it fails and the handle is
     * consistent on the state it had before the call. A call rejected before any write
     * — nothing staged, an unusable branch, a tree the validator refuses, or a branch
     * tip that has already moved — writes nothing at all. A failure once the freeze has
     * begun leaves a part-frozen tree, which is discarded and rebuilt from a snapshot
     * taken before the freeze started, so the handle comes back on the revision it was
     * on with the edits still staged. Either way recovery is to fix what the terminal
     * reported and retry **on the same handle**: no close, no reload, no re-applying
     * edits. The one failure that still poisons the handle is a restore that itself
     * fails, which reports `INTERNAL` saying so. When the branch had advanced,
     * `new_tip_hash` on the terminal carries that tip, which is also how a caller tells
     * that failure apart: neither a tip collision nor an empty commit has a
     * `lore_error_code_t` of its own, so both report `INTERNAL` with the reason in the
     * completion detail — the same codes the file-system commit returns.
     * 
     * `options.remote_write = 1` uploads within the call. It is a request, not a
     * guarantee: a store bound offline or local-only, or a call passing
     * `globals.local`, silently commits local-only. So does a store opened without a
     * remote configuration — there is nothing to upload to, and the commit still
     * reports success. Per-call flags contradicting the store's bound flags reject the
     * call.
     * 
     * **The commit holds the handle for the length of the call.** No other call on the
     * same handle runs while the tree is frozen, so an edit issued concurrently lands
     * wholly before the commit reads the tree or wholly after it finishes, two commits
     * on one handle serialize, and `metadata_set` can no longer lose an edit to the
     * commit. A commit on a large tree therefore blocks reads on that handle for its
     * duration, and a callback that re-enters the API on the same handle deadlocks —
     * which the callback contract already forbids. Commits from *different* handles or
     * processes still race, and the branch tip compare-and-swap decides them.
     * 
     * `remote_write` is resolved onto the handle's shared repository context, so the
     * value outlives the call: the handle carries whatever the last commit resolved.
     * 
     * | Terminal event                                | Payload                                             | Notes                                                             |
     * |-----------------------------------------------|-----------------------------------------------------|-------------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_COMMIT_COMPLETE`    | `lore_revision_tree_commit_complete_event_data_t`   | Exactly one; carries the new revision, or the new tip on collision |
     * | `LORE_EVENT_REVISION_COMMIT_REVISION`         | `lore_revision_commit_revision_event_data_t`        | On success, for continuity with file-system commit consumers       |
     */
    val lore_revision_tree_commit: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_commit",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Freeze a loaded revision tree into a new revision (async variant).
     */
    val lore_revision_tree_commit_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_commit_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove a batch of subtrees from a loaded revision tree. Each entry names a
     * subtree root and removes it whole, transitive children included. Every entry
     * is checked before any node is touched, so one bad entry rejects the call and
     * leaves every subtree in place; the reason names the offending entry's batch
     * index, which a caller leaving `entry_id` at zero has no other way to
     * identify. A failure after those checks pass is internal and may leave part of
     * the batch removed.
     * 
     * A node the loaded revision holds is **staged** for deletion and stays in the
     * tree: it keeps its name and its place among its siblings, still lists through
     * `lore_revision_tree_list_children`, and reports
     * `LORE_NODE_STAGED_ACTION_DELETE` in its `staged_action`. The commit that
     * freezes the tree is what drops it. A node added through this handle is in no
     * revision yet, so it is discarded outright instead, freeing its name and its
     * node id. A link is removed as one node — its subtree belongs to the linked
     * repository's tree.
     * 
     * A staged deletion is reversible: `lore_revision_tree_add` of the same name
     * under the same parent with the same kind restores the node. A zero
     * `address.context` on that add preserves the node's `file_id`; supplying one
     * replaces it, as on `lore_revision_tree_modify`. Only the named node comes back
     * — restoring a directory leaves its children staged for deletion, so each has to
     * be added back in turn. A discarded node is not restorable, since its id is
     * gone.
     * 
     * Staging fans out one depth level at a time; discarding an added node rewrites
     * sibling pointers and so runs serially, deepest first. Memory while the call
     * runs is proportional to the widest level of the subtrees being removed rather
     * than to the entry count, since a level is collected before it is staged. The
     * root cannot be deleted, and an entry whose ancestor another entry deletes is
     * rejected rather than removed twice.
     * 
     * | Terminal event                              | Payload                                           | Notes                                                    |
     * |---------------------------------------------|---------------------------------------------------|----------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_DELETE_COMPLETE`  | `lore_revision_tree_delete_complete_event_data_t` | One per entry, carrying its `entry_id` and `node_count`   |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE`   | `lore_revision_tree_batch_complete_event_data_t`  | Exactly one, carrying the `batch_id` and the call's outcome |
     */
    val lore_revision_tree_delete: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_delete",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove a batch of subtrees from a loaded revision tree (async variant).
     */
    val lore_revision_tree_delete_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_delete_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Fetch the loaded revision's record-level metadata (parents, creation
     * timestamp, author identity, metadata key count). Revision-scoped — no node id.
     * 
     * | Terminal event                     | Payload                                | Notes                                                   |
     * |------------------------------------|----------------------------------------|---------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_INFO`    | `lore_revision_tree_info_event_data_t` | Carries the revision record metadata for the handle     |
     */
    val lore_revision_tree_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Fetch the loaded revision's record-level metadata (async variant).
     */
    val lore_revision_tree_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Stream the children of a directory node in a loaded revision tree.
     * 
     * | Terminal event                       | Payload                                | Notes                                                          |
     * |--------------------------------------|----------------------------------------|----------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_CHILD`     | `lore_revision_tree_child_event_data_t` | One per child; an empty directory emits none before `Complete` |
     */
    val lore_revision_tree_list_children: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_list_children",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Stream the children of a directory node (async variant).
     */
    val lore_revision_tree_list_children_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_list_children_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Open a memory-based revision tree handle on the given
     * `(store, repository, revision_hash)` tuple. `revision_hash == 0` opens an
     * empty tree suitable for committing an initial revision.
     * 
     * The tree keeps the storage handle's claim on its stores for as long as it is
     * open, past `lore_storage_close` on that handle.
     * 
     * | Terminal event                       | Payload                                | Notes                                              |
     * |--------------------------------------|----------------------------------------|----------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_LOADED`    | `lore_revision_tree_loaded_event_data_t` | Emitted on success carrying the opened handle id |
     */
    val lore_revision_tree_load: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_load",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Open a memory-based revision tree handle (async variant).
     */
    val lore_revision_tree_load_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_load_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove a batch of keys from a loaded revision tree's in-progress metadata.
     * Every entry is checked before any key is removed, so one bad entry rejects the
     * call and removes nothing; the reason names the offending entry's batch index,
     * which a caller leaving `entry_id` at zero has no other way to identify.
     * 
     * **Clearing a key that is not set is a no-op success**, not a failure. The
     * terminal's `removed` field says which happened: `1` when the key was there and
     * is now gone, `0` when there was nothing to remove. A repeated key is likewise
     * not rejected — the second entry naming it reports `removed = 0`.
     * 
     * This clears the **pending** metadata that `lore_revision_tree_metadata_set`
     * records and `lore_revision_tree_metadata_get` reads first; a key frozen in the
     * loaded revision is not reachable from here, since clearing edits the revision
     * being built and the one it was loaded from is immutable. The whole batch
     * applies under one write lock, which is what makes it atomic.
     * 
     * | Terminal event                                      | Payload                                                   | Notes                                                       |
     * |-----------------------------------------------------|-----------------------------------------------------------|-------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_METADATA_CLEAR_COMPLETE`  | `lore_revision_tree_metadata_clear_complete_event_data_t` | One per entry, carrying its `entry_id` and `removed`        |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE`           | `lore_revision_tree_batch_complete_event_data_t`          | Exactly one, carrying the `batch_id` and the call's outcome  |
     */
    val lore_revision_tree_metadata_clear: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_metadata_clear",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Remove a batch of metadata keys from a loaded revision tree (async variant).
     */
    val lore_revision_tree_metadata_clear_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_metadata_clear_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read a batch of metadata values from a loaded revision tree.
     * 
     * By default this reads only the **revision being built** — what
     * `lore_revision_tree_metadata_set` recorded on this handle, which is exactly
     * what `lore_revision_tree_commit` will write. Nothing is inherited from the
     * revision the handle was loaded on. Set `include_revision` to `1` to also fall
     * back to that revision for a key the handle has no entry for; a pending entry
     * still wins, so the flag only adds answers.
     * 
     * A key present in neither emits **no event at all** and does not fail the call,
     * matching `lore_revision_metadata_get`: detect an absent key by tracking
     * whether a value event arrived for its `entry_id`. This verb is therefore **not
     * all-or-nothing**, unlike the other batch verbs — it mutates nothing, so one
     * unanswerable key costs the others nothing. Bad arguments still reject the
     * whole call.
     * 
     * A value comes back as the same `lore_metadata_t` that
     * `lore_revision_tree_metadata_set` takes, so it round-trips without either
     * side encoding it as text. Every kind is returned, raw binary included.
     * 
     * A value whose stored bytes do not match the kind they are tagged with, or
     * whose tag this build does not recognize, reports `LORE_ERROR_CODE_INTERNAL`
     * on that entry rather than staying silent, so it is never mistaken for an
     * absent key.
     * 
     * The revision's metadata is read once for the whole batch, which is what
     * batching buys here.
     * 
     * | Terminal event                                    | Payload                                                 | Notes                                                       |
     * |---------------------------------------------------|---------------------------------------------------------|-------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_METADATA_GET_COMPLETE`  | `lore_revision_tree_metadata_get_complete_event_data_t` | One per key that resolved, carrying its `entry_id`; none for an absent key |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE`         | `lore_revision_tree_batch_complete_event_data_t`        | Exactly one, carrying the `batch_id` and the call's outcome  |
     */
    val lore_revision_tree_metadata_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_metadata_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read a batch of metadata values from a loaded revision tree (async variant).
     */
    val lore_revision_tree_metadata_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_metadata_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Record a batch of `(key, value)` pairs on a loaded revision tree's in-progress
     * metadata.
     * 
     * `value` is a `lore_metadata_t`, which carries its own kind — set the union's
     * `tag` and the matching member. There is no separate format field and nothing
     * is parsed, so a value cannot be stored under a kind it is not, and a binary
     * value can hold any bytes rather than only text. This differs from
     * `lore_revision_metadata_set`, which takes text plus a parallel format array.
     * `lore_revision_tree_metadata_get` returns the same union.
     * 
     * Every entry is checked before any pair is recorded, so one bad entry rejects
     * the call and records nothing; the reason names the offending entry's batch
     * index, which a caller leaving `entry_id` at zero has no other way to
     * identify.
     * 
     * A repeated key is **not** rejected, unlike the duplicate-target rules on the
     * node verbs: entries apply in index order, so the last entry naming a key wins
     * — the same result as sending those pairs as separate calls.
     * 
     * Nothing reaches storage here. The pairs live on the handle until
     * `lore_revision_tree_commit` serializes them, so only this handle's
     * `lore_revision_tree_metadata_get` sees them. The whole batch applies under one
     * write lock, which is what makes it atomic and why there is no concurrency to
     * gain: the work is buffer writes, not I/O.
     * 
     * A revision's whole metadata is capped at 1 MiB. The cap counts the metadata
     * itself — keys, values and per-entry overhead — and not what a value refers
     * to: a value holding a content address costs the address, not the content
     * behind it.
     * 
     * A single entry larger than the whole cap is rejected here, since no amount of
     * removing other keys could make it fit. The running total is not checked here,
     * because what a revision ends up carrying is only known once every set has
     * run: a batch of individually legal entries that together push past the limit
     * is reported as recorded and fails later, at `lore_revision_tree_commit`.
     * 
     * | Terminal event                                    | Payload                                                 | Notes                                                       |
     * |---------------------------------------------------|---------------------------------------------------------|-------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_METADATA_SET_COMPLETE`  | `lore_revision_tree_metadata_set_complete_event_data_t` | One per entry, carrying its `entry_id`                      |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE`         | `lore_revision_tree_batch_complete_event_data_t`        | Exactly one, carrying the `batch_id` and the call's outcome  |
     */
    val lore_revision_tree_metadata_set: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_metadata_set",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Record a batch of metadata pairs on a loaded revision tree (async variant).
     */
    val lore_revision_tree_metadata_set_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_metadata_set_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Rewrite a batch of file nodes' `mode`, `size` and `address` in a loaded
     * revision tree. Every entry is checked before any node is rewritten, so one bad
     * entry rejects the call and leaves every target untouched; the reason names the
     * offending entry's batch index, which a caller leaving `entry_id` at zero has no
     * other way to identify. A failure after those checks pass is internal and may
     * leave part of the batch rewritten.
     * 
     * Only a file is modifiable: a directory's size and address are derived at
     * commit and a link's address is its target. A zero `address.context` preserves
     * the node's existing file id rather than generating one, which is the opposite
     * of `lore_revision_tree_add` — the node already has an identity, and replacing
     * it would record the edit as a move. Entries touch no parent or sibling chain,
     * so the whole batch applies concurrently.
     * 
     * | Terminal event                              | Payload                                           | Notes                                                    |
     * |---------------------------------------------|---------------------------------------------------|----------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_MODIFY_COMPLETE`  | `lore_revision_tree_modify_complete_event_data_t` | One per entry, carrying its `entry_id`                    |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE`   | `lore_revision_tree_batch_complete_event_data_t`  | Exactly one, carrying the `batch_id` and the call's outcome |
     */
    val lore_revision_tree_modify: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_modify",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Rewrite a batch of file nodes in a loaded revision tree (async variant).
     */
    val lore_revision_tree_modify_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_modify_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Move a batch of nodes to new parents and/or new names in a loaded revision tree. An
     * entry naming the node's current parent renames it where it is. Every entry is checked
     * before any node is moved, so one bad entry rejects the call and leaves every node
     * where it was; the reason names the offending entry's batch index, which a caller
     * leaving `entry_id` at zero has no other way to identify. A failure after those checks
     * pass is internal and may leave earlier entries applied.
     * 
     * A move keeps the node: its node id, its `file_id` and its children come along, and
     * the change is recorded as a move rather than as a deletion and an addition, so the
     * revision graph carries the node's history across it. The node reports
     * `LORE_NODE_STAGED_ACTION_MOVE` until the commit that freezes the tree, and so does
     * every node under a moved directory — their records do not change, but their paths do.
     * Two exceptions: a node added through this handle stays staged as an addition wherever
     * it lands, since it is in no revision a move could be recorded against; and a node
     * under the moved directory that is staged for deletion keeps its deletion, since it is
     * leaving the revision at the commit either way.
     * 
     * Both batch-level rules read the tree the whole batch produces rather than the one in
     * front of them. A destination inside the moved node's own subtree is rejected, and so
     * is one that lands there once the batch is applied — moving A under B and B under A is
     * a loop neither entry shows on its own. A name a live child of the destination already
     * holds is rejected, but a name the batch itself vacates is not: moving `x` out of a
     * directory while moving another node to `x` in it succeeds, and two entries taking one
     * name under one destination reject even though neither collides with the tree.
     * 
     * Entries apply one at a time, in batch order, because a move rewrites the parent and
     * sibling pointers of two child chains where `lore_revision_tree_add` only prepends to
     * one. For the same reason concurrent calls have more to lose here than on `add` or
     * `modify`: two calls moving nodes that share a parent chain can interleave their
     * unlinks, which the pre-commit validator then refuses. Moves that may touch one parent
     * chain belong in one call.
     * 
     * | Terminal event                            | Payload                                          | Notes                                                       |
     * |-------------------------------------------|--------------------------------------------------|-------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_MOVE_COMPLETE`  | `lore_revision_tree_move_complete_event_data_t`  | One per entry, carrying its `entry_id` and the moved node    |
     * | `LORE_EVENT_REVISION_TREE_BATCH_COMPLETE` | `lore_revision_tree_batch_complete_event_data_t` | Exactly one, carrying the `batch_id` and the call's outcome  |
     */
    val lore_revision_tree_move: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_move",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Move a batch of nodes in a loaded revision tree (async variant).
     */
    val lore_revision_tree_move_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_move_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Fetch the per-node record for a single node id in a loaded revision tree.
     * 
     * | Terminal event                          | Payload                                     | Notes                                                          |
     * |-----------------------------------------|---------------------------------------------|----------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_NODE_INFO`    | `lore_revision_tree_node_info_event_data_t` | Carries the node record, uniform across every node id (revision metadata: `lore_revision_tree_info`) |
     */
    val lore_revision_tree_node_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_node_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Fetch the per-node record for a single node id (async variant).
     */
    val lore_revision_tree_node_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_node_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Reconstruct the full UTF-8 path for a node id by walking parent pointers,
     * relative to the handle's own tree root.
     * 
     * | Terminal event                       | Payload                                     | Notes                                                  |
     * |--------------------------------------|---------------------------------------------|--------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_NODE_PATH` | `lore_revision_tree_node_path_event_data_t` | Carries the path; the root resolves to the empty path  |
     */
    val lore_revision_tree_node_path: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_node_path",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Reconstruct the full UTF-8 path for a node id (async variant).
     */
    val lore_revision_tree_node_path_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_node_path_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a UTF-8 path against a loaded revision tree to a node id. An empty
     * path resolves to the root node.
     * 
     * | Terminal event                                       | Payload                                             | Notes                                                       |
     * |------------------------------------------------------|-----------------------------------------------------|-------------------------------------------------------------|
     * | `LORE_EVENT_REVISION_TREE_RESOLVE_PATH_COMPLETE`     | `lore_revision_tree_resolve_path_complete_event_data_t` | Carries the resolved node id and the per-call outcome   |
     */
    val lore_revision_tree_resolve_path: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_resolve_path",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve a UTF-8 path against a loaded revision tree (async variant).
     */
    val lore_revision_tree_resolve_path_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_revision_tree_resolve_path_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Name the executable the Lore background service runs from, for this machine.
     * 
     * Written to the user-level global config, so it holds for later commands and
     * for other clients that read it. An empty `executable` clears the setting.
     * Naming it decides which build serves the machine, rather than leaving that to
     * whichever client happens to start a service first.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_set_executable: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_set_executable",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_service_set_executable`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_set_executable_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_set_executable_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set whether commands are carried out by the Lore background service.
     * 
     * Written to the user-level global config, so the service stays in use for
     * later commands rather than for one command at a time. A non-zero `enabled`
     * turns it on; zero turns it off.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_set_use_automatically: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_set_use_automatically",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_service_set_use_automatically`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_set_use_automatically_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_set_use_automatically_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Start the Lore background service, unless one is already running.
     * 
     * Connects to the running service, and starts one when nothing is listening.
     * Returns `0` once a service is reachable, whether it was already running or
     * was started by this call.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_start: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_start",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_service_start`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_start_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_start_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Report whether the Lore background service is running, and its metadata.
     * 
     * Answers from inside the service when called there, and otherwise reaches the
     * one that is listening. Nothing listening is an answer rather than a failure:
     * the call returns `0` with `running` set to `0`, so a caller branches on the
     * event rather than on a connection error. Also hands back the log messages the
     * service buffered while no command was running, emptying the buffer as it
     * reads it.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Operation-Specific Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SERVICE_STATUS` | `lore_service_status_event_data_t` | Service running state and metadata |
     * | `LORE_EVENT_SERVICE_MESSAGE` | `lore_service_message_event_data_t` | A log message the service buffered outside command execution |
     */
    val lore_service_status: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_status",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_service_status`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Operation-Specific Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SERVICE_STATUS` | `lore_service_status_event_data_t` | Service running state and metadata |
     * | `LORE_EVENT_SERVICE_MESSAGE` | `lore_service_message_event_data_t` | A log message the service buffered outside command execution |
     */
    val lore_service_status_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_status_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Stop the running Lore background service.
     * 
     * Does not start a service in order to stop one. Returns `0` when no service
     * is running, since that is the state the call asks for. A mount the service
     * cannot release because something holds it refuses the stop with `MountsBusy`,
     * unless the global `force` argument is set, which detaches busy mounts lazily.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_stop: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_stop",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Asynchronous version of `lore_service_stop`.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_service_stop_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_service_stop_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Install the memory allocator the library uses for its own allocations.
     * Provide functions for allocation, zeroed allocation, reallocation and
     * freeing. Call this before the library makes its first allocation; once it
     * has allocated, the allocator can no longer be changed.
     * 
     * Returns 0 when the allocator was installed and a non-zero value when it was
     * too late to install one, in which case the call does nothing.
     */
    val lore_set_allocator: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_set_allocator",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.ADDRESS),
        )
    }

    /**
     * Select the level payloads are compressed at.
     * 
     * `level` is a zstd level, `1` through `22`, trading time spent per byte for
     * bytes stored, or `-1` for the level each codec defaults to, `6` for zstd. A
     * level outside the range a codec accepts is clamped into it, one level serving
     * every codec and each accepting its own, so `0` selects the lowest zstd has.
     * 
     * The `LORE_COMPRESSION_LEVEL` environment variable outranks this selection where
     * it names a level the codec accepts.
     * 
     * Call before the first payload is written: the level is read once, by the first
     * compression, which sizes the workspace every later one is built in.
     * 
     * Returns `0` when the level was selected and `1` when a payload had already
     * fixed it, in which case the selection decides nothing.
     */
    val lore_set_compression_level: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_set_compression_level",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT),
        )
    }

    /**
     * Select how payloads are compressed before they are stored, over
     * `lore_storage::COMPRESSION_MODE`.
     * 
     * `mode` is a `lore_compression_mode_t` value, which names what each mode does.
     * 
     * The default attempts compression, which is wasted work for a caller whose
     * payloads arrive already compressed: the attempt reads every byte written and
     * buys nothing back. A caller that knows the shape of its own data can say so.
     * 
     * Applies to payloads written after the call. Content already stored keeps the
     * encoding it was written with, since every fragment records its own.
     * 
     * A mode selected here outranks the one a server states it prefers in the
     * environment it answers a connection with: that preference is taken only where
     * no mode has been selected yet, so a call made before the first connection
     * stands.
     * 
     * Returns `0` when the mode was applied and `3`
     * (`LORE_ERROR_CODE_INVALID_ARGUMENTS`) when it was not, in which case the call
     * does nothing. Rejected are any value the enum does not name, and
     * `LORE_COMPRESSION_MODE_OODLE`: `compress` refuses that mode as deprecated
     * whether or not the `oodle` feature is compiled in, so accepting it here would
     * only move the failure to the first write.
     */
    val lore_set_compression_mode: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_set_compression_mode",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_INT),
        )
    }

    /**
     * Limits the total number of threads Lore sizes its pools for.
     * 
     * Pass `0` for "no limit", which is the default and sizes every pool from the
     * host's processor count. The `LORE_MAX_THREADS` environment variable overrides
     * this count when set above zero.
     * 
     * # The pools
     * 
     * Four pools share the limit:
     * 
     * - **worker** — the async runtime executing Lore's own work. Asks for one
     * thread per processor.
     * - **blocking** — OS APIs with no async form (keyring, cloud SDK
     * initialization, service IPC). Asks for 3 regardless of processor count,
     * two for the async runtime and one for the network runtime, because file
     * I/O does not run here.
     * - **net** — the network runtime carrying QUIC, TLS and HTTP/2, kept separate
     * so protocol timers are not delayed by other work. Asks for 2 on a client,
     * one per processor on a server.
     * - **io** — the syscall pool every file operation dispatches through. Asks for
     * twice the processor count, capped at 16.
     * 
     * # How a limit is divided
     * 
     * Each pool states an ideal, as above. Where a pool takes a configuration or
     * environment control (`LORE_NET_THREADS`, `LORE_IO_POOL_THREADS`, the server's
     * thread settings), that control raises the pool's ideal — it never sets the
     * pool's final size, so no knob can lift the process above a limit set here.
     * Retired per-pool variables are ignored outright.
     * 
     * With no limit, every pool gets its ideal. With one, the pools are scaled to
     * fit by the largest-remainder method: each is granted its proportional share
     * of the limit, and the threads left over by rounding go to the pools with the
     * largest remainders. A pool never drops below 2 threads, since a starved pool
     * can deadlock work another pool waits on. That floor outranks the limit, so a
     * limit below 8 yields 8.
     * 
     * # What is not counted
     * 
     * Threads the host application or a linked library creates. Lore accounts only
     * for its own.
     * 
     * Must be called before the first Lore operation, while the runtime is still
     * unconstructed. Returns `0` if the limit was applied, `1` if it had already
     * been set (or the runtime was already running).
     */
    val lore_set_thread_limit: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_set_thread_limit",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.JAVA_LONG),
        )
    }

    /**
     * Create a new shared store at the specified path.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Shared Store Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SHARED_STORE_CREATE` | `lore_shared_store_create_event_data_t` | Emitted on success after the shared store is created, carrying the path of the newly created store |
     */
    val lore_shared_store_create: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_create",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Create a new shared store at the specified path (async).
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Shared Store Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SHARED_STORE_CREATE` | `lore_shared_store_create_event_data_t` | Emitted on success after the shared store is created, carrying the path of the newly created store |
     */
    val lore_shared_store_create_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_create_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve the path of the configured default shared store.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Shared Store Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SHARED_STORE_INFO` | `lore_shared_store_info_event_data_t` | Emitted on success carrying the path of the configured default shared store |
     */
    val lore_shared_store_info: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_info",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Retrieve the path of the configured default shared store (async).
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Shared Store Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SHARED_STORE_INFO` | `lore_shared_store_info_event_data_t` | Emitted on success carrying the path of the configured default shared store |
     */
    val lore_shared_store_info_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_info_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List every registered shared store.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Shared Store Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SHARED_STORE_LIST` | `lore_shared_store_list_event_data_t` | Emitted on success carrying every registered shared store, and the instances using each when `include_instances` is set |
     */
    val lore_shared_store_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List every registered shared store (async).
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     * 
     * ## Shared Store Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_SHARED_STORE_LIST` | `lore_shared_store_list_event_data_t` | Emitted on success carrying every registered shared store, and the instances using each when `include_instances` is set |
     */
    val lore_shared_store_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set whether to automatically use the shared store.
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_shared_store_set_use_automatically: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_set_use_automatically",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Set whether to automatically use the shared store (async).
     * 
     * # Events
     * 
     * Events are delivered via the callback as `lore_event_t`. Use the `tag` field to identify the event type.
     * 
     * ## Standard Events
     * 
     * These events are emitted by all interface functions:
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_LOG` | `lore_log_event_data_t` | Diagnostic messages throughout execution |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | Always emitted at the end; `status` is `0` on success or the error code on failure |
     * | `LORE_EVENT_END` | `lore_end_event_data_t` | Always emitted after `COMPLETE` to signal callback termination |
     */
    val lore_shared_store_set_use_automatically_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shared_store_set_use_automatically_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Shut the library down, stopping its worker threads and releasing the
     * resources it holds. Call this once, when no further calls will be made and
     * every call made has completed. The library makes a best effort to cancel
     * calls still executing safely, but a call it does not stop in time may still
     * use the memory passed to it after this returns.
     * 
     * Returns 0 on success and a non-zero value on failure.
     */
    val lore_shutdown: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_shutdown",
            FunctionDescriptor.of(ValueLayout.JAVA_INT),
        )
    }

    /**
     * Release a content-addressed storage handle.
     * 
     * Subsequent calls against the same handle return `InvalidArguments`.
     * Close does not block on the flush it spawns — `Complete` fires after
     * the in-flight counter drains, not after the flush finishes. The handle's
     * claim on its stores ends once that flush has finished and every revision
     * tree loaded against the handle has been closed. With `LORE_STORE_RETAIN`
     * set to `1` or `true`, a disk-backed handle's stores stay in memory without
     * the claim for the window `store_keep_alive_seconds` gives, so a
     * `lore_storage_open` of the same repository in that window reuses them.
     */
    val lore_storage_close: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_close",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Release a content-addressed storage handle (async variant).
     */
    val lore_storage_close_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_close_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Copy content from one partition to another within the same store.
     * 
     * Same-partition source/target rejects with `INVALID_ARGUMENTS`. The
     * item's content hash is preserved; only the source address is carried
     * in the per-item event.
     */
    val lore_storage_copy: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_copy",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Copy content (async variant).
     */
    val lore_storage_copy_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_copy_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Flush pending writes through the handle's stores.
     * 
     * On disk-backed stores this performs an fsync honoring `globals.sync_data`.
     * On in-memory stores the underlying flush is a no-op and the call still
     * completes with `status: 0`.
     */
    val lore_storage_flush: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_flush",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Flush pending writes through the handle's stores (async variant).
     */
    val lore_storage_flush_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_flush_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read one or more content-addressed buffers.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_GET_HEADER` | `lore_storage_get_header_event_data_t` | Size of the item's reassembled content, emitted before any DATA events |
     * | `LORE_EVENT_STORAGE_GET_DATA` | `lore_storage_get_data_event_data_t` | Payload bytes — valid only during the callback invocation |
     * | `LORE_EVENT_STORAGE_GET_ITEM_COMPLETE` | `lore_storage_get_item_complete_event_data_t` | Terminal per-item event |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_get: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read one or more content-addressed buffers (async variant).
     */
    val lore_storage_get_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Write content-addressed payloads to filesystem paths.
     * 
     * Each item emits `LORE_EVENT_STORAGE_GET_ITEM_COMPLETE`. No HEADER or DATA events are produced —
     * the payload is written straight to disk. Multi-fragment writes stage through `<path>.loretmp`
     * and rename atomically, and a failure mid-write removes the temp file, so the target is either
     * the finished range or untouched. An `offset` past the end of the content is rejected with
     * `INVALID_ARGUMENTS` without opening the target, so a destination that was already there
     * survives.
     */
    val lore_storage_get_file: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_file",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Write content to file (async variant).
     */
    val lore_storage_get_file_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_file_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve one or more mutable keys and write the content they name to filesystem paths, in one
     * round trip.
     * 
     * `lore_storage_get_resolved` writing to a path instead of to the callback. Nothing is held whole
     * on either side of the boundary: the resolve and the read of the root fragment share one request,
     * and the content goes to disk fragment by fragment at its own offset, so a key naming something
     * large needs neither the `streaming` mode nor a buffer for it. No
     * `LORE_EVENT_STORAGE_GET_HEADER` or `LORE_EVENT_STORAGE_GET_DATA` is emitted, as with
     * `lore_storage_get_file`.
     * 
     * The terminal event's `address` is the *resolved* address, so a caller still learns the
     * key-to-hash mapping. A key with no mapping, or one naming absent content, reports
     * `error_code = ADDRESS_NOT_FOUND`, carries a zero address, and leaves `path` untouched — there is
     * no zero-hash truncation as in `lore_storage_get_file`, because a resolve that finds nothing is a
     * miss rather than an address for empty content.
     * 
     * `offset` and `length` select part of the content and multi-fragment writes stage through
     * `<path>.loretmp` before an atomic rename, both as in `lore_storage_get_file`: the file holds
     * exactly the requested range from its own first byte, and the target is either the finished range
     * or untouched. A start past the end is rejected with `INVALID_ARGUMENTS` without opening the
     * target, so a destination that was already there survives.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_GET_ITEM_COMPLETE` | `lore_storage_get_item_complete_event_data_t` | Terminal per-item event, carrying the resolved address |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_get_file_resolved: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_file_resolved",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve mutable keys and write the content they name to files (async variant).
     */
    val lore_storage_get_file_resolved_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_file_resolved_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Fetch fragment metadata for one or more `(partition, address)` pairs without paying the
     * payload bytes. Each item's terminal event carries the resolved `Fragment` (`flags`,
     * `size_payload`, `size_content`); on miss `error_code == ADDRESS_NOT_FOUND`.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_GET_METADATA_ITEM_COMPLETE` | `lore_storage_get_metadata_item_complete_event_data_t` | Per-item terminal event |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_get_metadata: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_metadata",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Fetch fragment metadata for one or more addresses (async variant).
     */
    val lore_storage_get_metadata_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_metadata_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve one or more mutable keys and read the content they name, in one round trip.
     * 
     * `lore_storage_mutable_load` followed by `lore_storage_get`, performed by the server. The keys
     * are read under the `LORE_KEY_TYPE_RESOLVE` key type, which is what `lore_storage_put_resolved`
     * publishes; no other key type is resolvable this way.
     * 
     * The `address` in every event is the *resolved* address, so a caller can learn the key-to-hash
     * mapping from the event stream. A key with no mapping, or one naming absent content, reports
     * `error_code = ADDRESS_NOT_FOUND`, and the terminal event then carries a zero address.
     * 
     * Set `streaming` to receive one `LORE_EVENT_STORAGE_GET_DATA` per leaf fragment instead of a
     * single reassembled buffer, exactly as `lore_storage_get` does. Without it the whole content is
     * materialised in memory before the first byte reaches the callback, so a key naming something
     * large should set it.
     * 
     * Set `fragments` to receive one `LORE_EVENT_STORAGE_GET_FRAGMENT` per leaf fragment in place of
     * `LORE_EVENT_STORAGE_GET_DATA`, each carrying the leaf's `lore_fragment_t` and its payload as
     * stored. No leaf is expanded or checked against its hash.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_GET_HEADER` | `lore_storage_get_header_event_data_t` | Size of the item's reassembled content, emitted before any DATA events |
     * | `LORE_EVENT_STORAGE_GET_DATA` | `lore_storage_get_data_event_data_t` | Payload bytes — valid only during the callback invocation. One event per item, or one per leaf fragment when `streaming` is set |
     * | `LORE_EVENT_STORAGE_GET_FRAGMENT` | `lore_storage_get_fragment_event_data_t` | One leaf fragment and its payload, in content order, when `fragments` is set. The payload is valid only during the callback invocation |
     * | `LORE_EVENT_STORAGE_GET_ITEM_COMPLETE` | `lore_storage_get_item_complete_event_data_t` | Terminal per-item event |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_get_resolved: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_resolved",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Resolve one or more mutable keys and read the content they name (async variant).
     */
    val lore_storage_get_resolved_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_get_resolved_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Conditionally swap one or more mutable key values. Each item updates the key to `value` when
     * its current value matches `expected`, and reports the value the key held before the swap.
     * 
     * Each item acts on the local mutable store by default, or the remote mutable store when
     * `globals.remote` is set (or the handle was opened remote-bound), over the shared storage
     * session.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_MUTABLE_COMPARE_AND_SWAP_ITEM_COMPLETE` | `lore_storage_mutable_compare_and_swap_item_complete_event_data_t` | Per-item terminal event carrying `previous`; the swap took effect when `previous == expected` |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status: 0` iff every item succeeded |
     */
    val lore_storage_mutable_compare_and_swap: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_compare_and_swap",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Conditionally swap one or more mutable key values (async variant).
     */
    val lore_storage_mutable_compare_and_swap_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_compare_and_swap_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List the mutable key-value pairs of a given type for one or more partitions.
     * 
     * Acts on the local mutable store only; a remote-targeted call (`globals.remote`, or a
     * remote-bound handle) is rejected with `INVALID_ARGUMENTS`. A zero/default partition lists
     * every partition the caller can access.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_MUTABLE_LIST_ENTRY` | `lore_storage_mutable_list_entry_event_data_t` | One `(key, value)` pair, emitted before the item's terminal event |
     * | `LORE_EVENT_STORAGE_MUTABLE_LIST_ITEM_COMPLETE` | `lore_storage_mutable_list_item_complete_event_data_t` | Per-item terminal event |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status: 0` iff every item succeeded |
     */
    val lore_storage_mutable_list: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_list",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * List mutable key-value pairs (async variant).
     */
    val lore_storage_mutable_list_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_list_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read one or more mutable key values.
     * 
     * Each item acts on the local mutable store by default, or the remote mutable store when
     * `globals.remote` is set (or the handle was opened remote-bound), over the shared storage
     * session.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_MUTABLE_LOAD_ITEM_COMPLETE` | `lore_storage_mutable_load_item_complete_event_data_t` | Per-item terminal event carrying the value; `error_code == ADDRESS_NOT_FOUND` on a miss |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status: 0` iff every item succeeded |
     */
    val lore_storage_mutable_load: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_load",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read one or more mutable key values (async variant).
     */
    val lore_storage_mutable_load_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_load_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Write one or more mutable key-value pairs. Storing the null value removes the key.
     * 
     * Each item acts on the local mutable store by default, or the remote mutable store when
     * `globals.remote` is set (or the handle was opened remote-bound), over the shared storage
     * session.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_MUTABLE_STORE_ITEM_COMPLETE` | `lore_storage_mutable_store_item_complete_event_data_t` | Per-item terminal event |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status: 0` iff every item succeeded |
     */
    val lore_storage_mutable_store: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_store",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Write one or more mutable key-value pairs (async variant).
     */
    val lore_storage_mutable_store_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_mutable_store_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Delete one or more `(partition, address)` entries from the store.
     * 
     * Idempotent on absent items; emits one `OBLITERATE_ITEM_COMPLETE` event
     * per item carrying `local_success` / `remote_success` / `error_code`.
     */
    val lore_storage_obliterate: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_obliterate",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Delete content (async variant).
     */
    val lore_storage_obliterate_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_obliterate_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Open a content-addressed storage handle.
     * 
     * A disk-backed handle claims its stores for this process until it is released, so
     * another process using the same stores waits until then. The claim ends once the
     * flush `lore_storage_close` starts has finished and every revision tree loaded
     * against the handle has been closed.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_OPENED` | `lore_storage_opened_event_data_t` | Emitted on success carrying the opened handle id |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` on success or the error code on failure |
     */
    val lore_storage_open: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_open",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Open a content-addressed storage handle (async variant).
     */
    val lore_storage_open_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_open_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Store one or more content-addressed buffers.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_PUT_ITEM_COMPLETE` | `lore_storage_put_item_complete_event_data_t` | Emitted once per input item — success or failure; `stored_local`/`stored_remote` report where the content landed |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_put: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Store one or more content-addressed buffers (async variant).
     */
    val lore_storage_put_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read one or more files into the content-addressed store.
     * 
     * Each item emits `LORE_EVENT_STORAGE_PUT_ITEM_COMPLETE` carrying the
     * computed address. Empty files short-circuit to the zero-hash address
     * without opening for read.
     */
    val lore_storage_put_file: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_file",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Read files into the store (async variant).
     */
    val lore_storage_put_file_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_file_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Store one or more files and publish a mutable key naming each, in one round trip.
     * 
     * `lore_storage_put_resolved` reading its content from a path instead of a buffer, and identical
     * to it in everything but the source: the key is published under `LORE_KEY_TYPE_RESOLVE`, the
     * mapping is written only once the content is stored, publishing is last-writer-wins, and
     * `remote_write = 1` publishes remotely as well as locally.
     * 
     * The caller never loads the file, and the library holds no more than one fragment of it: a file
     * at or below the fragment threshold is read once into the single fragment it becomes, a larger
     * one chunks straight off disk.
     * 
     * A zero `key` or a zero `partition` rejects with `INVALID_ARGUMENTS`, as does a missing,
     * unreadable, or non-file `path` — a path that cannot be read is never taken for a delete, so a
     * typo cannot retract a live key. A **zero-length** file does retract it, exactly as a
     * zero-length `data` does in `lore_storage_put_resolved`.
     * 
     * A remote content upload that fails still leaves a successful local write, so the key is not
     * published remotely and `stored_remote` is `0` while `error_code` stays `NONE`. Check
     * `stored_remote`, not `error_code`, to confirm the key is visible to other clients.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_PUT_ITEM_COMPLETE` | `lore_storage_put_item_complete_event_data_t` | Emitted once per input item; `address` is the content the key now resolves to, and `stored_local`/`stored_remote` report where it landed |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_put_file_resolved: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_file_resolved",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Store one or more files and publish a mutable key naming each (async variant).
     */
    val lore_storage_put_file_resolved_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_file_resolved_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Store one or more buffers and publish a mutable key naming each, in one round trip.
     * 
     * `lore_storage_put` followed by `lore_storage_mutable_store`, with the mapping riding on
     * whichever request carries the content's top-level fragment rather than costing one of its own.
     * The key is published under `LORE_KEY_TYPE_RESOLVE`, making it readable by
     * `lore_storage_get_resolved`, and the mapping is written only once the content is stored — so a
     * key published this way never resolves to content that is not there. Writing the same key type
     * directly with `lore_storage_mutable_store` carries no such guarantee. Content the server
     * already holds uploads nothing, so its key takes a mapping write instead — still one request.
     * 
     * The local store always receives both the content and the mapping. `remote_write = 1` also
     * publishes them remotely, matching `lore_storage_put`; there is no local-then-remote fallback.
     * A zero `key` or a zero `partition` rejects with `INVALID_ARGUMENTS`.
     * 
     * A zero-length `data` **removes** the key's mapping rather than publishing one: no content is
     * stored, the key is set to the zero hash, and `lore_storage_get_resolved` then reports
     * `ADDRESS_NOT_FOUND` for it. The terminal event carries the zero content hash and the caller's
     * context.
     * 
     * With `remote_write = 0` this evicts only the locally cached mapping. The local mutable store
     * is a cache, not an authority, so a key published remotely resolves again on the next call.
     * Deleting a published key requires `remote_write = 1`.
     * 
     * A remote content upload that fails still leaves a successful local write, so the key is not
     * published remotely and `stored_remote` is `0` while `error_code` stays `NONE`. Check
     * `stored_remote`, not `error_code`, to confirm the key is visible to other clients.
     * 
     * Publishing is last-writer-wins. Two callers publishing the same key concurrently both
     * succeed, and the key ends up naming whichever content was published second — the first
     * publisher is not told it was overwritten. Callers needing to detect a lost update should
     * store the content with `lore_storage_put` and publish with
     * `lore_storage_mutable_compare_and_swap`, which costs the second round trip this operation
     * exists to avoid.
     * 
     * # Events
     * 
     * | Tag | Data Type | Description |
     * |-----|-----------|-------------|
     * | `LORE_EVENT_STORAGE_PUT_ITEM_COMPLETE` | `lore_storage_put_item_complete_event_data_t` | Emitted once per input item; `address` is the content the key now resolves to, and `stored_local`/`stored_remote` report where it landed |
     * | `LORE_EVENT_ERROR` | `lore_error_event_data_t` | Emitted for a non-fatal error during the operation |
     * | `LORE_EVENT_COMPLETE` | `lore_complete_event_data_t` | `status` is `0` iff every item succeeded, else the error code |
     */
    val lore_storage_put_resolved: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_resolved",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Store one or more buffers and publish a mutable key naming each (async variant).
     */
    val lore_storage_put_resolved_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_put_resolved_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Push locally-stored, not-yet-durable content to the remote store.
     * 
     * Whole-call pre-dispatch fails when the handle has no remote, when `globals.offline=1`,
     * or when `globals.local=1`. Per-item: `partition == 0` → `INVALID_ARGUMENTS`; zero hash and
     * already-durable both succeed with `already_durable=1` and no remote call; missing local
     * payload → `ADDRESS_NOT_FOUND`. Otherwise the bytes are uploaded and the local entry is
     * updated with `PayloadStoredDurable` set.
     */
    val lore_storage_upload: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_upload",
            FunctionDescriptor.of(ValueLayout.JAVA_INT, ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Upload deferred content (async variant).
     */
    val lore_storage_upload_async: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_storage_upload_async",
            FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, lore_event_callback_config_t.LAYOUT),
        )
    }

    /**
     * Return the path of the directory where the library keeps its per-user data
     * as a NUL-terminated string. The string is owned by the library and must not
     * be freed by the caller.
     */
    val lore_user_directory: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_user_directory",
            FunctionDescriptor.of(ValueLayout.ADDRESS),
        )
    }

    /**
     * Return the library version as a NUL-terminated string: `LORE_INTERFACE_VERSION`,
     * then `+` and the build name. The string is owned by the library and must not
     * be freed by the caller.
     */
    val lore_version: MethodHandle by lazy {
        LoreLinker.downcall(
            "lore_version",
            FunctionDescriptor.of(ValueLayout.ADDRESS),
        )
    }
}
