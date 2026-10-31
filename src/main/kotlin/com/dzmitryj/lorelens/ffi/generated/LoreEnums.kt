// Generated from lore.h 0.12.0 by :codegen. Do not edit.
package com.dzmitryj.lorelens.ffi.generated

/**
 * Which authentication path a client takes if a server advertises both its
 * gRPC auth service and an OIDC issuer. A path the server does not
 * advertise cannot be taken.
 */
object lore_auth_mode_t {
    /**
     * Follow the server's preference: the OIDC path if the server marks it
     * preferred, the gRPC path otherwise.
     */
    const val LORE_AUTH_MODE_AUTO: Int = 0
    /**
     * The gRPC path, through the auth service at `auth_url`.
     */
    const val LORE_AUTH_MODE_GRPC: Int = 1
    /**
     * The OIDC path, through the advertised OIDC issuer.
     */
    const val LORE_AUTH_MODE_OIDC: Int = 2
}

/**
 * Where a branch is located.
 */
object lore_branch_location_t {
    /**
     * A branch held locally.
     */
    const val LORE_BRANCH_LOCATION_LOCAL: Int = 0
    /**
     * A branch held on the server.
     */
    const val LORE_BRANCH_LOCATION_REMOTE: Int = 1
}

/**
 * The codec a payload is compressed with before it is stored.
 * 
 * Every stored fragment records the codec it was written with, so a mode selected here decides
 * what later writes use and never what already stored content is read back as.
 */
object lore_compression_mode_t {
    /**
     * No mode was selected; the built-in default applies, which is Zstd.
     */
    const val LORE_COMPRESSION_MODE_NOT_SPECIFIED: Int = 0
    /**
     * Store payloads verbatim, compressing nothing.
     */
    const val LORE_COMPRESSION_MODE_NO_COMPRESSION: Int = 1
    /**
     * LZ4, which costs less to compress than Zstd and stores more bytes.
     */
    const val LORE_COMPRESSION_MODE_LZ4: Int = 2
    /**
     * Oodle, deprecated and refused: a write under this mode fails.
     */
    const val LORE_COMPRESSION_MODE_OODLE: Int = 3
    /**
     * Zstandard, at the configured level.
     */
    const val LORE_COMPRESSION_MODE_ZSTD: Int = 4
}

/**
 * Small discriminator enum for the per-item terminal events of the revision-tree API.
 * 
 * Narrower than the general library error code: an event embeds this so a caller can branch on
 * the common cases cheaply, without reading a message. The cost is that it names only five
 * outcomes, so errors outside them arrive as `Internal`. The storage API carries a full
 * [`LoreErrorDetail`] on its per-item events instead, and no longer uses this enum.
 * 
 * The values are the error codes themselves, taken from the registry in
 * `lore_base::error`, so a code read from a per-item event means the same
 * thing as the code on `Complete.status`. This enum names the subset a
 * per-item event can carry; it is not a second numbering.
 * 
 */
object lore_error_code_t {
    /**
     * No error; the operation succeeded.
     */
    const val LORE_ERROR_CODE_NONE: Int = 0
    /**
     * The arguments supplied to the operation were invalid.
     */
    const val LORE_ERROR_CODE_INVALID_ARGUMENTS: Int = 3
    /**
     * A content-addressable object could not be found in any store.
     */
    const val LORE_ERROR_CODE_ADDRESS_NOT_FOUND: Int = 80
    /**
     * An internal error occurred.
     */
    const val LORE_ERROR_CODE_INTERNAL: Int = -1
    /**
     * The backing store is overloaded; the caller should retry later.
     */
    const val LORE_ERROR_CODE_SLOW_DOWN: Int = 31
}

/**
 * An event delivered to a callback. Each variant names a kind of event and
 * carries the data for that event.
 */
object lore_event_id_t {
    /**
     * A progress update.
     */
    const val LORE_EVENT_PROGRESS: Int = 0
    /**
     * An error encountered during an operation. A terminal failure is
     * reported on the `Complete` event in its `error` field.
     */
    const val LORE_EVENT_ERROR: Int = 1
    /**
     * An operation completed.
     */
    const val LORE_EVENT_COMPLETE: Int = 2
    /**
     * A metadata key and value.
     */
    const val LORE_EVENT_METADATA: Int = 3
    /**
     * A log message.
     */
    const val LORE_EVENT_LOG: Int = 4
    /**
     * The final event of a callback stream.
     */
    const val LORE_EVENT_END: Int = 5
    /**
     * A maintenance message.
     */
    const val LORE_EVENT_MAINTENANCE: Int = 6
    /**
     * An authentication URL for the user to visit.
     */
    const val LORE_EVENT_AUTH_URL: Int = 7
    /**
     * Information about the authenticated user.
     */
    const val LORE_EVENT_AUTH_USER_INFO: Int = 8
    /**
     * An authentication token for the user.
     */
    const val LORE_EVENT_AUTH_USER_TOKEN: Int = 9
    /**
     * The resolved identity of the user.
     */
    const val LORE_EVENT_AUTH_IDENTITY: Int = 10
    /**
     * A branch was created.
     */
    const val LORE_EVENT_BRANCH_CREATE: Int = 11
    /**
     * More than one instance of a branch was found.
     */
    const val LORE_EVENT_BRANCH_MULTIPLE_INSTANCE: Int = 12
    /**
     * A branch was archived.
     */
    const val LORE_EVENT_BRANCH_ARCHIVE: Int = 13
    /**
     * The start of a branch listing.
     */
    const val LORE_EVENT_BRANCH_LIST_BEGIN: Int = 14
    /**
     * One entry in a branch listing.
     */
    const val LORE_EVENT_BRANCH_LIST_ENTRY: Int = 15
    /**
     * The end of a branch listing.
     */
    const val LORE_EVENT_BRANCH_LIST_END: Int = 16
    /**
     * The start of a merge abort.
     */
    const val LORE_EVENT_BRANCH_MERGE_ABORT_BEGIN: Int = 17
    /**
     * The end of a merge abort.
     */
    const val LORE_EVENT_BRANCH_MERGE_ABORT_END: Int = 18
    /**
     * Information about a branch.
     */
    const val LORE_EVENT_BRANCH_INFO: Int = 19
    /**
     * The start of a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_BEGIN: Int = 20
    /**
     * The start of the changes in a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_CHANGE_BEGIN: Int = 21
    /**
     * One change in a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_CHANGE: Int = 22
    /**
     * The end of the changes in a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_CHANGE_END: Int = 23
    /**
     * The start of the conflicts in a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_CONFLICT_BEGIN: Int = 24
    /**
     * One conflict in a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_CONFLICT: Int = 25
    /**
     * The end of the conflicts in a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_CONFLICT_END: Int = 26
    /**
     * The end of a branch diff.
     */
    const val LORE_EVENT_BRANCH_DIFF_END: Int = 27
    /**
     * One entry in a listing of latest branch revisions.
     */
    const val LORE_EVENT_BRANCH_LATEST_LIST_ENTRY: Int = 28
    /**
     * A file in conflict during a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_CONFLICT_FILE: Int = 29
    /**
     * A link was skipped during a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_LINK_SKIPPED: Int = 30
    /**
     * A file conflict was marked unresolved during a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_UNRESOLVE_FILE: Int = 31
    /**
     * A revision was marked unresolved during a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_UNRESOLVE_REVISION: Int = 32
    /**
     * The start of merging changes into a file.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_FILE_BEGIN: Int = 33
    /**
     * Merging changes into a file.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_FILE: Int = 34
    /**
     * The end of merging changes into a file.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_FILE_END: Int = 35
    /**
     * The start of merging a fragment.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_BEGIN: Int = 36
    /**
     * Progress while merging a fragment.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_PROGRESS: Int = 37
    /**
     * The end of merging a fragment.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_FRAGMENT_END: Int = 38
    /**
     * A revision merged into the target.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_REVISION: Int = 39
    /**
     * The start of synchronizing data for a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_SYNC_BEGIN: Int = 40
    /**
     * The end of synchronizing data for a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_INTO_SYNC_END: Int = 41
    /**
     * A file conflict was resolved during a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_RESOLVE_FILE: Int = 42
    /**
     * A revision was resolved during a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_RESOLVE_REVISION: Int = 43
    /**
     * The start of a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_START_BEGIN: Int = 44
    /**
     * The end of starting a merge.
     */
    const val LORE_EVENT_BRANCH_MERGE_START_END: Int = 45
    /**
     * The start of a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_START_BEGIN: Int = 46
    /**
     * The end of starting a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_START_END: Int = 47
    /**
     * The start of a cherry-pick abort.
     */
    const val LORE_EVENT_CHERRY_PICK_ABORT_BEGIN: Int = 48
    /**
     * The end of a cherry-pick abort.
     */
    const val LORE_EVENT_CHERRY_PICK_ABORT_END: Int = 49
    /**
     * A file in conflict during a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_CONFLICT_FILE: Int = 50
    /**
     * A file conflict was marked unresolved during a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_UNRESOLVE_FILE: Int = 51
    /**
     * A revision was marked unresolved during a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_UNRESOLVE_REVISION: Int = 52
    /**
     * A file conflict was resolved during a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_RESOLVE_FILE: Int = 53
    /**
     * A revision was resolved during a cherry-pick.
     */
    const val LORE_EVENT_CHERRY_PICK_RESOLVE_REVISION: Int = 54
    /**
     * The start of a revert.
     */
    const val LORE_EVENT_REVERT_START_BEGIN: Int = 55
    /**
     * The end of starting a revert.
     */
    const val LORE_EVENT_REVERT_START_END: Int = 56
    /**
     * The start of a revert abort.
     */
    const val LORE_EVENT_REVERT_ABORT_BEGIN: Int = 57
    /**
     * The end of a revert abort.
     */
    const val LORE_EVENT_REVERT_ABORT_END: Int = 58
    /**
     * A file conflict was resolved during a revert.
     */
    const val LORE_EVENT_REVERT_RESOLVE_FILE: Int = 59
    /**
     * A revision was resolved during a revert.
     */
    const val LORE_EVENT_REVERT_RESOLVE_REVISION: Int = 60
    /**
     * A file in conflict during a revert.
     */
    const val LORE_EVENT_REVERT_CONFLICT_FILE: Int = 61
    /**
     * A file conflict was marked unresolved during a revert.
     */
    const val LORE_EVENT_REVERT_UNRESOLVE_FILE: Int = 62
    /**
     * A revision was marked unresolved during a revert.
     */
    const val LORE_EVENT_REVERT_UNRESOLVE_REVISION: Int = 63
    /**
     * A branch was protected.
     */
    const val LORE_EVENT_BRANCH_PROTECT: Int = 64
    /**
     * A branch was pushed.
     */
    const val LORE_EVENT_BRANCH_PUSH: Int = 65
    /**
     * The start of updating a revision during a push.
     */
    const val LORE_EVENT_BRANCH_PUSH_REVISION_UPDATE_BEGIN: Int = 66
    /**
     * The end of updating a revision during a push.
     */
    const val LORE_EVENT_BRANCH_PUSH_REVISION_UPDATE_END: Int = 67
    /**
     * The start of pushing a fragment.
     */
    const val LORE_EVENT_BRANCH_PUSH_FRAGMENT_BEGIN: Int = 68
    /**
     * Progress while pushing a fragment.
     */
    const val LORE_EVENT_BRANCH_PUSH_FRAGMENT_PROGRESS: Int = 69
    /**
     * The end of pushing a fragment.
     */
    const val LORE_EVENT_BRANCH_PUSH_FRAGMENT_END: Int = 70
    /**
     * The start of creating a branch during a push.
     */
    const val LORE_EVENT_BRANCH_PUSH_BRANCH_CREATE_BEGIN: Int = 71
    /**
     * The end of creating a branch during a push.
     */
    const val LORE_EVENT_BRANCH_PUSH_BRANCH_CREATE_END: Int = 72
    /**
     * The start of pushing a revision.
     */
    const val LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_BEGIN: Int = 73
    /**
     * An update while pushing a revision.
     */
    const val LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_UPDATE: Int = 74
    /**
     * The end of pushing a revision.
     */
    const val LORE_EVENT_BRANCH_PUSH_REVISION_PUSH_END: Int = 75
    /**
     * A branch was reset.
     */
    const val LORE_EVENT_BRANCH_RESET: Int = 76
    /**
     * The start of switching the active branch.
     */
    const val LORE_EVENT_BRANCH_SWITCH_BEGIN: Int = 77
    /**
     * The end of switching the active branch.
     */
    const val LORE_EVENT_BRANCH_SWITCH_END: Int = 78
    /**
     * A branch was unprotected.
     */
    const val LORE_EVENT_BRANCH_UNPROTECT: Int = 79
    /**
     * Information about a file.
     */
    const val LORE_EVENT_FILE_INFO: Int = 80
    /**
     * A diff for a file.
     */
    const val LORE_EVENT_FILE_DIFF: Int = 81
    /**
     * The hash of a file.
     */
    const val LORE_EVENT_FILE_HASH: Int = 82
    /**
     * The history of a file.
     */
    const val LORE_EVENT_FILE_HISTORY: Int = 83
    /**
     * A file was written.
     */
    const val LORE_EVENT_FILE_WRITE: Int = 84
    /**
     * A file was obliterated.
     */
    const val LORE_EVENT_FILE_OBLITERATE: Int = 85
    /**
     * A dump of a file.
     */
    const val LORE_EVENT_FILE_DUMP: Int = 86
    /**
     * The start of adding file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_ADD_BEGIN: Int = 87
    /**
     * One entry while adding file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_ADD_ENTRY: Int = 88
    /**
     * The end of adding file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_ADD_END: Int = 89
    /**
     * The start of removing file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_REMOVE_BEGIN: Int = 90
    /**
     * One entry while removing file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_REMOVE_ENTRY: Int = 91
    /**
     * The end of removing file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_REMOVE_END: Int = 92
    /**
     * The start of listing file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_LIST_BEGIN: Int = 93
    /**
     * A file in a dependency listing.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_LIST_FILE: Int = 94
    /**
     * One entry in a file dependency listing.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_LIST_ENTRY: Int = 95
    /**
     * The end of the entries for one file in a dependency listing.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_LIST_FILE_END: Int = 96
    /**
     * The end of listing file dependencies.
     */
    const val LORE_EVENT_FILE_DEPENDENCY_LIST_END: Int = 97
    /**
     * The start of a file reset.
     */
    const val LORE_EVENT_FILE_RESET_BEGIN: Int = 98
    /**
     * Progress during a file reset.
     */
    const val LORE_EVENT_FILE_RESET_PROGRESS: Int = 99
    /**
     * The end of a file reset.
     */
    const val LORE_EVENT_FILE_RESET_END: Int = 100
    /**
     * One file reset.
     */
    const val LORE_EVENT_FILE_RESET_FILE: Int = 101
    /**
     * A path was excluded by a filter.
     */
    const val LORE_EVENT_FILTER_EXCLUDE: Int = 102
    /**
     * The start of staging files.
     */
    const val LORE_EVENT_FILE_STAGE_BEGIN: Int = 103
    /**
     * Progress while staging files.
     */
    const val LORE_EVENT_FILE_STAGE_PROGRESS: Int = 104
    /**
     * The end of staging files.
     */
    const val LORE_EVENT_FILE_STAGE_END: Int = 105
    /**
     * The revision involved in staging files.
     */
    const val LORE_EVENT_FILE_STAGE_REVISION: Int = 106
    /**
     * One file staged.
     */
    const val LORE_EVENT_FILE_STAGE_FILE: Int = 107
    /**
     * The start of unstaging files.
     */
    const val LORE_EVENT_FILE_UNSTAGE_BEGIN: Int = 108
    /**
     * Progress while unstaging files.
     */
    const val LORE_EVENT_FILE_UNSTAGE_PROGRESS: Int = 109
    /**
     * The end of unstaging files.
     */
    const val LORE_EVENT_FILE_UNSTAGE_END: Int = 110
    /**
     * The revision involved in unstaging files.
     */
    const val LORE_EVENT_FILE_UNSTAGE_REVISION: Int = 111
    /**
     * One file unstaged.
     */
    const val LORE_EVENT_FILE_UNSTAGE_FILE: Int = 112
    /**
     * A fragment was written.
     */
    const val LORE_EVENT_FRAGMENT_WRITE: Int = 113
    /**
     * A layer was added.
     */
    const val LORE_EVENT_LAYER_ADD: Int = 114
    /**
     * One entry in a layer listing.
     */
    const val LORE_EVENT_LAYER_ENTRY: Int = 115
    /**
     * A layer was removed.
     */
    const val LORE_EVENT_LAYER_REMOVE: Int = 116
    /**
     * One staged entry in a layer listing.
     */
    const val LORE_EVENT_LAYER_STAGED_ENTRY: Int = 117
    /**
     * A link's branch in the linked repository was created or reused.
     */
    const val LORE_EVENT_LINK_BRANCH_CREATE: Int = 118
    /**
     * A link was changed.
     */
    const val LORE_EVENT_LINK_CHANGE: Int = 119
    /**
     * One entry in a link listing.
     */
    const val LORE_EVENT_LINK_ENTRY: Int = 120
    /**
     * Detailed information about a single link.
     */
    const val LORE_EVENT_LINK_INFO: Int = 121
    /**
     * The start of a file lock acquire report.
     */
    const val LORE_EVENT_LOCK_FILE_ACQUIRE_BEGIN: Int = 122
    /**
     * A file concerning the lock acquire report.
     */
    const val LORE_EVENT_LOCK_FILE_ACQUIRE: Int = 123
    /**
     * The start of a file lock status report.
     */
    const val LORE_EVENT_LOCK_FILE_STATUS_BEGIN: Int = 124
    /**
     * One file lock status entry.
     */
    const val LORE_EVENT_LOCK_FILE_STATUS: Int = 125
    /**
     * The start of a file lock query.
     */
    const val LORE_EVENT_LOCK_FILE_QUERY_BEGIN: Int = 126
    /**
     * One file lock query result.
     */
    const val LORE_EVENT_LOCK_FILE_QUERY: Int = 127
    /**
     * The start of a file lock release report.
     */
    const val LORE_EVENT_LOCK_FILE_RELEASE_BEGIN: Int = 128
    /**
     * A file concerning the lock release report.
     */
    const val LORE_EVENT_LOCK_FILE_RELEASE: Int = 129
    /**
     * Metadata was cleared on a file.
     */
    const val LORE_EVENT_METADATA_CLEAR_FILE: Int = 130
    /**
     * Metadata was cleared on a revision.
     */
    const val LORE_EVENT_METADATA_CLEAR_REVISION: Int = 131
    /**
     * A path was ignored.
     */
    const val LORE_EVENT_PATH_IGNORE: Int = 132
    /**
     * A repository was created.
     */
    const val LORE_EVENT_REPOSITORY_CREATE: Int = 133
    /**
     * The start of a repository clone.
     */
    const val LORE_EVENT_REPOSITORY_CLONE_BEGIN: Int = 134
    /**
     * Progress during a repository clone.
     */
    const val LORE_EVENT_REPOSITORY_CLONE_PROGRESS: Int = 135
    /**
     * The end of a repository clone that succeeded. A clone that fails sends none, and reports its
     * outcome on the complete event as every clone does.
     */
    const val LORE_EVENT_REPOSITORY_CLONE_END: Int = 136
    /**
     * The start of resolving dependencies.
     */
    const val LORE_EVENT_DEPENDENCY_RESOLVE_BEGIN: Int = 137
    /**
     * One item while resolving dependencies.
     */
    const val LORE_EVENT_DEPENDENCY_RESOLVE_ITEM: Int = 138
    /**
     * The end of resolving dependencies.
     */
    const val LORE_EVENT_DEPENDENCY_RESOLVE_END: Int = 139
    /**
     * Data about a repository.
     */
    const val LORE_EVENT_REPOSITORY_DATA: Int = 140
    /**
     * A repository configuration value.
     */
    const val LORE_EVENT_REPOSITORY_CONFIG_GET: Int = 141
    /**
     * The start of a repository dump.
     */
    const val LORE_EVENT_REPOSITORY_DUMP_BEGIN: Int = 142
    /**
     * The end of a repository dump.
     */
    const val LORE_EVENT_REPOSITORY_DUMP_END: Int = 143
    /**
     * One entry in a repository listing.
     */
    const val LORE_EVENT_REPOSITORY_LIST_ENTRY: Int = 144
    /**
     * An instance of a repository.
     */
    const val LORE_EVENT_REPOSITORY_INSTANCE: Int = 145
    /**
     * The start of verifying repository state.
     */
    const val LORE_EVENT_REPOSITORY_VERIFY_STATE_BEGIN: Int = 146
    /**
     * The end of verifying repository state.
     */
    const val LORE_EVENT_REPOSITORY_VERIFY_STATE_END: Int = 147
    /**
     * A fragment verified in a repository.
     */
    const val LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT: Int = 148
    /**
     * A fragment match found while verifying a repository.
     */
    const val LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT_MATCH: Int = 149
    /**
     * A remote fragment checked while verifying a repository.
     */
    const val LORE_EVENT_REPOSITORY_VERIFY_FRAGMENT_REMOTE: Int = 150
    /**
     * A dump of repository state.
     */
    const val LORE_EVENT_REPOSITORY_STATE_DUMP: Int = 151
    /**
     * One node in a repository state dump.
     */
    const val LORE_EVENT_REPOSITORY_STATE_DUMP_NODE: Int = 152
    /**
     * The revision involved in a repository status report.
     */
    const val LORE_EVENT_REPOSITORY_STATUS_REVISION: Int = 153
    /**
     * One file in a repository status report.
     */
    const val LORE_EVENT_REPOSITORY_STATUS_FILE: Int = 154
    /**
     * File counts in a repository status report.
     */
    const val LORE_EVENT_REPOSITORY_STATUS_COUNT: Int = 155
    /**
     * A summary of a repository status report.
     */
    const val LORE_EVENT_REPOSITORY_STATUS_SUMMARY: Int = 156
    /**
     * A result from querying the immutable store.
     */
    const val LORE_EVENT_REPOSITORY_STORE_IMMUTABLE_QUERY: Int = 157
    /**
     * The start of committing a revision.
     */
    const val LORE_EVENT_REVISION_COMMIT_BEGIN: Int = 158
    /**
     * Progress while committing a revision.
     */
    const val LORE_EVENT_REVISION_COMMIT_PROGRESS: Int = 159
    /**
     * The end of committing a revision.
     */
    const val LORE_EVENT_REVISION_COMMIT_END: Int = 160
    /**
     * The committed revision.
     */
    const val LORE_EVENT_REVISION_COMMIT_REVISION: Int = 161
    /**
     * Information about a revision.
     */
    const val LORE_EVENT_REVISION_INFO: Int = 162
    /**
     * A change in a revision's delta.
     */
    const val LORE_EVENT_REVISION_INFO_DELTA: Int = 163
    /**
     * One file in a revision diff.
     */
    const val LORE_EVENT_REVISION_DIFF_FILE: Int = 164
    /**
     * A revision found by a search.
     */
    const val LORE_EVENT_REVISION_FIND: Int = 165
    /**
     * The history of a revision.
     */
    const val LORE_EVENT_REVISION_HISTORY: Int = 166
    /**
     * One entry in a revision history.
     */
    const val LORE_EVENT_REVISION_HISTORY_ENTRY: Int = 167
    /**
     * The start of restoring a file from a revision.
     */
    const val LORE_EVENT_REVISION_RESTORE_FILE_BEGIN: Int = 168
    /**
     * A file restored from a revision.
     */
    const val LORE_EVENT_REVISION_RESTORE_FILE: Int = 169
    /**
     * The end of restoring a file from a revision.
     */
    const val LORE_EVENT_REVISION_RESTORE_FILE_END: Int = 170
    /**
     * The start of restoring a fragment.
     */
    const val LORE_EVENT_REVISION_RESTORE_FRAGMENT_BEGIN: Int = 171
    /**
     * Progress while restoring a fragment.
     */
    const val LORE_EVENT_REVISION_RESTORE_FRAGMENT_PROGRESS: Int = 172
    /**
     * The end of restoring a fragment.
     */
    const val LORE_EVENT_REVISION_RESTORE_FRAGMENT_END: Int = 173
    /**
     * The revision being restored.
     */
    const val LORE_EVENT_REVISION_RESTORE_REVISION: Int = 174
    /**
     * The start of synchronizing data for a restore.
     */
    const val LORE_EVENT_REVISION_RESTORE_SYNC_BEGIN: Int = 175
    /**
     * The end of synchronizing data for a restore.
     */
    const val LORE_EVENT_REVISION_RESTORE_SYNC_END: Int = 176
    /**
     * A revision was resolved.
     */
    const val LORE_EVENT_REVISION_RESOLVE: Int = 177
    /**
     * The target revision of a sync.
     */
    const val LORE_EVENT_REVISION_SYNC_TARGET: Int = 178
    /**
     * One file synced.
     */
    const val LORE_EVENT_REVISION_SYNC_FILE: Int = 179
    /**
     * Progress during a revision sync.
     */
    const val LORE_EVENT_REVISION_SYNC_PROGRESS: Int = 180
    /**
     * The revision involved in a sync.
     */
    const val LORE_EVENT_REVISION_SYNC_REVISION: Int = 181
    /**
     * A bisect result.
     */
    const val LORE_EVENT_REVISION_BISECT: Int = 182
    /**
     * A notification that a branch was created.
     */
    const val LORE_EVENT_NOTIFICATION_BRANCH_CREATED: Int = 183
    /**
     * A notification that a branch was deleted.
     */
    const val LORE_EVENT_NOTIFICATION_BRANCH_DELETED: Int = 184
    /**
     * A notification that a branch was pushed.
     */
    const val LORE_EVENT_NOTIFICATION_BRANCH_PUSHED: Int = 185
    /**
     * A notification that a resource was locked.
     */
    const val LORE_EVENT_NOTIFICATION_RESOURCE_LOCKED: Int = 186
    /**
     * A notification that a resource was unlocked.
     */
    const val LORE_EVENT_NOTIFICATION_RESOURCE_UNLOCKED: Int = 187
    /**
     * A notification that a subscription was created.
     */
    const val LORE_EVENT_NOTIFICATION_SUBSCRIBED: Int = 188
    /**
     * A notification that a subscription was removed.
     */
    const val LORE_EVENT_NOTIFICATION_UNSUBSCRIBED: Int = 189
    /**
     * A shared store was created.
     */
    const val LORE_EVENT_SHARED_STORE_CREATE: Int = 190
    /**
     * Information about a shared store.
     */
    const val LORE_EVENT_SHARED_STORE_INFO: Int = 191
    /**
     * List of all shared stores.
     */
    const val LORE_EVENT_SHARED_STORE_LIST: Int = 192
    /**
     * One staged entry in a link listing.
     */
    const val LORE_EVENT_LINK_STAGED_ENTRY: Int = 193
    /**
     * A store was opened.
     */
    const val LORE_EVENT_STORAGE_OPENED: Int = 194
    /**
     * A put item completed.
     */
    const val LORE_EVENT_STORAGE_PUT_ITEM_COMPLETE: Int = 195
    /**
     * The header for a get item.
     */
    const val LORE_EVENT_STORAGE_GET_HEADER: Int = 196
    /**
     * A data payload for a get item.
     */
    const val LORE_EVENT_STORAGE_GET_DATA: Int = 197
    /**
     * A get item completed.
     */
    const val LORE_EVENT_STORAGE_GET_ITEM_COMPLETE: Int = 198
    /**
     * A get-metadata item completed.
     */
    const val LORE_EVENT_STORAGE_GET_METADATA_ITEM_COMPLETE: Int = 199
    /**
     * A copy item completed.
     */
    const val LORE_EVENT_STORAGE_COPY_ITEM_COMPLETE: Int = 200
    /**
     * An obliterate item completed.
     */
    const val LORE_EVENT_STORAGE_OBLITERATE_ITEM_COMPLETE: Int = 201
    /**
     * An upload item completed.
     */
    const val LORE_EVENT_STORAGE_UPLOAD_ITEM_COMPLETE: Int = 202
    /**
     * A revision tree was loaded.
     */
    const val LORE_EVENT_REVISION_TREE_LOADED: Int = 203
    /**
     * A resolve-path call completed.
     */
    const val LORE_EVENT_REVISION_TREE_RESOLVE_PATH_COMPLETE: Int = 204
    /**
     * One child node in a revision tree.
     */
    const val LORE_EVENT_REVISION_TREE_CHILD: Int = 205
    /**
     * Information about a revision tree node.
     */
    const val LORE_EVENT_REVISION_TREE_NODE_INFO: Int = 206
    /**
     * The path of a revision tree node.
     */
    const val LORE_EVENT_REVISION_TREE_NODE_PATH: Int = 207
    /**
     * An add call completed.
     */
    const val LORE_EVENT_REVISION_TREE_ADD_COMPLETE: Int = 208
    /**
     * A delete call completed.
     */
    const val LORE_EVENT_REVISION_TREE_DELETE_COMPLETE: Int = 209
    /**
     * A modify call completed.
     */
    const val LORE_EVENT_REVISION_TREE_MODIFY_COMPLETE: Int = 210
    /**
     * A move call completed.
     */
    const val LORE_EVENT_REVISION_TREE_MOVE_COMPLETE: Int = 211
    /**
     * A metadata-set call completed.
     */
    const val LORE_EVENT_REVISION_TREE_METADATA_SET_COMPLETE: Int = 212
    /**
     * A metadata-get call completed.
     */
    const val LORE_EVENT_REVISION_TREE_METADATA_GET_COMPLETE: Int = 213
    /**
     * A commit call completed.
     */
    const val LORE_EVENT_REVISION_TREE_COMMIT_COMPLETE: Int = 214
    /**
     * A close call completed.
     */
    const val LORE_EVENT_REVISION_TREE_CLOSE_COMPLETE: Int = 215
    /**
     * A list-children call began; carries the target repository and revision.
     */
    const val LORE_EVENT_REVISION_TREE_LIST_CHILDREN_BEGIN: Int = 216
    /**
     * Revision-record metadata for a loaded revision tree.
     */
    const val LORE_EVENT_REVISION_TREE_INFO: Int = 217
    /**
     * A mutable-load item completed.
     */
    const val LORE_EVENT_STORAGE_MUTABLE_LOAD_ITEM_COMPLETE: Int = 218
    /**
     * A mutable-store item completed.
     */
    const val LORE_EVENT_STORAGE_MUTABLE_STORE_ITEM_COMPLETE: Int = 219
    /**
     * A mutable-compare-and-swap item completed.
     */
    const val LORE_EVENT_STORAGE_MUTABLE_COMPARE_AND_SWAP_ITEM_COMPLETE: Int = 220
    /**
     * One key-value entry in a mutable listing.
     */
    const val LORE_EVENT_STORAGE_MUTABLE_LIST_ENTRY: Int = 221
    /**
     * A mutable-list item completed.
     */
    const val LORE_EVENT_STORAGE_MUTABLE_LIST_ITEM_COMPLETE: Int = 222
    /**
     * A store eviction pass began.
     */
    const val LORE_EVENT_EVICTION_BEGIN: Int = 223
    /**
     * One bucket was evicted during a store eviction pass.
     */
    const val LORE_EVENT_EVICTION_PROGRESS: Int = 224
    /**
     * A store eviction pass ended.
     */
    const val LORE_EVENT_EVICTION_END: Int = 225
    /**
     * A store compaction pass began.
     */
    const val LORE_EVENT_COMPACTION_BEGIN: Int = 226
    /**
     * One group was compacted during a store compaction pass.
     */
    const val LORE_EVENT_COMPACTION_PROGRESS: Int = 227
    /**
     * A store compaction pass ended.
     */
    const val LORE_EVENT_COMPACTION_END: Int = 228
    /**
     * A batch write call on a revision tree completed as a whole.
     */
    const val LORE_EVENT_REVISION_TREE_BATCH_COMPLETE: Int = 229
    /**
     * A metadata-clear entry completed.
     */
    const val LORE_EVENT_REVISION_TREE_METADATA_CLEAR_COMPLETE: Int = 230
    /**
     * What a commit has cost so far, or in total once it has drained its writes.
     */
    const val LORE_EVENT_REVISION_COMMIT_STATS: Int = 231
    /**
     * What a push has cost so far, or in total once it has finished.
     */
    const val LORE_EVENT_BRANCH_PUSH_STATS: Int = 232
    /**
     * The status of the background service.
     */
    const val LORE_EVENT_SERVICE_STATUS: Int = 233
    /**
     * A log message captured by the service outside command execution.
     */
    const val LORE_EVENT_SERVICE_MESSAGE: Int = 234
    /**
     * An interactive login is still waiting for the user's approval.
     */
    const val LORE_EVENT_AUTH_PENDING: Int = 235
    /**
     * One leaf fragment and its payload for a get-resolved item.
     */
    const val LORE_EVENT_STORAGE_GET_FRAGMENT: Int = 236
    /**
     * One range of a file's lines, attributed to the revision that last changed them.
     */
    const val LORE_EVENT_FILE_AUDIT: Int = 237
}

/**
 * The change applied to a file.
 */
object lore_file_action_t {
    /**
     * The file is unchanged.
     */
    const val LORE_FILE_ACTION_KEEP: Int = 0
    /**
     * The file was added.
     */
    const val LORE_FILE_ACTION_ADD: Int = 1
    /**
     * The file was deleted.
     */
    const val LORE_FILE_ACTION_DELETE: Int = 2
    /**
     * The file was moved to a new path.
     */
    const val LORE_FILE_ACTION_MOVE: Int = 3
    /**
     * The file was copied from another path.
     */
    const val LORE_FILE_ACTION_COPY: Int = 4
}

/**
 * What a range of lines resolved to, or why it did not resolve.
 * 
 * An outcome is named the same way wherever it is reported, as
 * `binary-in-history` rather than `binaryInHistory`.
 */
object lore_file_audit_outcome_t {
    /**
     * Resolved to the revision that last changed the lines.
     */
    const val LORE_FILE_AUDIT_OUTCOME_ATTRIBUTED: Int = 0
    /**
     * Differs on disk from the revision the audit read, so no revision holds it.
     */
    const val LORE_FILE_AUDIT_OUTCOME_UNCOMMITTED: Int = 1
    /**
     * The revision budget ran out before the lines resolved.
     */
    const val LORE_FILE_AUDIT_OUTCOME_BUDGET_EXHAUSTED: Int = 2
    /**
     * A version the walk had to compare no longer holds its content, the
     * address it is stored at surviving the payload.
     */
    const val LORE_FILE_AUDIT_OUTCOME_OBLITERATED: Int = 3
    /**
     * A version the walk had to compare holds binary content, which cannot be
     * compared line by line.
     */
    const val LORE_FILE_AUDIT_OUTCOME_BINARY_IN_HISTORY: Int = 4
    /**
     * The chain continues in a linked repository that is unauthorized or out
     * of reach.
     */
    const val LORE_FILE_AUDIT_OUTCOME_LINK_UNAVAILABLE: Int = 5
    /**
     * A version the walk had to compare is not held locally, and the instance
     * reads its local store alone.
     */
    const val LORE_FILE_AUDIT_OUTCOME_CONTENT_UNAVAILABLE: Int = 6
    /**
     * The walk ended with an error before it reached the lines. The error
     * arrives on the completion event.
     */
    const val LORE_FILE_AUDIT_OUTCOME_UNRESOLVED: Int = 7
}

/**
 * Kind of value a stored key refers to.
 */
object lore_key_type_t {
    /**
     * Key has no specific type.
     */
    const val LORE_KEY_TYPE_UNTYPED: Int = 0
    /**
     * Key refers to branch metadata.
     */
    const val LORE_KEY_TYPE_BRANCH_METADATA: Int = 1
    /**
     * Key refers to a branch identifier.
     */
    const val LORE_KEY_TYPE_BRANCH_ID: Int = 2
    /**
     * Key refers to a pointer to a branch's latest revision.
     */
    const val LORE_KEY_TYPE_BRANCH_LATEST_POINTER: Int = 3
    /**
     * Key refers to repository metadata.
     */
    const val LORE_KEY_TYPE_REPOSITORY_METADATA: Int = 4
    /**
     * Key refers to a repository identifier.
     */
    const val LORE_KEY_TYPE_REPOSITORY_ID: Int = 5
    /**
     * Key refers to a repository instance.
     */
    const val LORE_KEY_TYPE_INSTANCE: Int = 6
    /**
     * Key maps to an immutable content hash, written by `lore_storage_put_resolved` and read by
     * `lore_storage_get_resolved`. Those two commands do not carry a key type on the wire,
     * because this is the only one they operate on; a publish large enough to fragment falls
     * back to an ordinary mutable store write, which does carry it like any other type.
     */
    const val LORE_KEY_TYPE_RESOLVE: Int = 7
}

/**
 * Staged change to a link itself, as opposed to content inside it.
 */
object lore_link_staged_state_t {
    /**
     * The link carries no staged change.
     */
    const val LORE_LINK_STAGED_STATE_NONE: Int = 0
    /**
     * The link was added and is not committed yet.
     */
    const val LORE_LINK_STAGED_STATE_ADDED: Int = 1
    /**
     * The link was removed and the removal is not committed yet.
     */
    const val LORE_LINK_STAGED_STATE_REMOVED: Int = 2
    /**
     * The link's pin was changed and is not committed yet.
     */
    const val LORE_LINK_STAGED_STATE_MODIFIED: Int = 3
}

/**
 * Severity level of a log message.
 */
object lore_log_level_t {
    /**
     * No logging.
     */
    const val LORE_LOG_LEVEL_NONE: Int = 0
    /**
     * Most detailed tracing messages.
     */
    const val LORE_LOG_LEVEL_TRACE: Int = 1
    /**
     * Debugging messages.
     */
    const val LORE_LOG_LEVEL_DEBUG: Int = 2
    /**
     * Informational messages.
     */
    const val LORE_LOG_LEVEL_INFO: Int = 3
    /**
     * Warnings about unexpected but recoverable situations.
     */
    const val LORE_LOG_LEVEL_WARN: Int = 4
    /**
     * Errors.
     */
    const val LORE_LOG_LEVEL_ERROR: Int = 5
}

/**
 * The kind of value held by a metadata entry.
 * 
 * This is both the tag a caller passes across the API and the tag written into
 * a stored metadata buffer — the same type, so the two cannot drift apart.
 * 
 * There is deliberately no zero value: a zero-initialized field has not chosen
 * a type and must not be passed as one.
 */
object lore_metadata_type_t {
    /**
     * A content address: 48 bytes, the 32-byte hash followed by the 16-byte
     * context.
     */
    const val LORE_METADATA_TYPE_ADDRESS: Int = 1
    /**
     * A boolean: exactly one byte, where any non-zero value is true.
     */
    const val LORE_METADATA_TYPE_BOOLEAN: Int = 2
    /**
     * A context identifier: 16 raw bytes.
     */
    const val LORE_METADATA_TYPE_CONTEXT: Int = 3
    /**
     * A content hash: 32 raw bytes.
     */
    const val LORE_METADATA_TYPE_HASH: Int = 4
    /**
     * An unsigned 64-bit integer: 8 bytes, little-endian.
     */
    const val LORE_METADATA_TYPE_NUMERIC: Int = 5
    /**
     * Text: UTF-8 bytes, not terminated.
     */
    const val LORE_METADATA_TYPE_STRING: Int = 6
    /**
     * Raw bytes, stored exactly as supplied and of any length.
     */
    const val LORE_METADATA_TYPE_BINARY: Int = 255
}

/**
 * The change staged on a node for the next revision. `None` is a node the
 * current revision holds unchanged; every other value is an edit that has not
 * been committed yet.
 */
object lore_node_staged_action_t {
    /**
     * No staged change.
     */
    const val LORE_NODE_STAGED_ACTION_NONE: Int = 0
    /**
     * Staged for addition; the node is not in the revision it was loaded from.
     */
    const val LORE_NODE_STAGED_ACTION_ADD: Int = 1
    /**
     * Staged with rewritten content fields.
     */
    const val LORE_NODE_STAGED_ACTION_MODIFY: Int = 2
    /**
     * Staged for removal; the node is dropped when the revision is committed.
     */
    const val LORE_NODE_STAGED_ACTION_DELETE: Int = 3
    /**
     * Staged at a new path or under a new name.
     */
    const val LORE_NODE_STAGED_ACTION_MOVE: Int = 4
    /**
     * Staged as a copy of another node.
     */
    const val LORE_NODE_STAGED_ACTION_COPY: Int = 5
}

/**
 * The kind of a tracked node.
 */
object lore_node_type_t {
    /**
     * A directory.
     */
    const val LORE_NODE_TYPE_DIRECTORY: Int = 0
    /**
     * A file.
     */
    const val LORE_NODE_TYPE_FILE: Int = 1
    /**
     * A symbolic link.
     */
    const val LORE_NODE_TYPE_LINK: Int = 2
}

/**
 * What a revision specifier names on a branch.
 */
object lore_revision_resolve_target_t {
    /**
     * A revision by its number on the branch.
     */
    const val LORE_REVISION_RESOLVE_TARGET_NUMBER: Int = 1
    /**
     * The latest revision of the branch.
     */
    const val LORE_REVISION_RESOLVE_TARGET_LATEST: Int = 2
    /**
     * A revision by its whole hash signature, taken on the branch.
     */
    const val LORE_REVISION_RESOLVE_TARGET_SIGNATURE: Int = 3
}

/**
 * Whether a repository being created or cloned should be backed by a shared store.
 * 
 * `Inherit` is zero so a zero-initialized C struct keeps following the machine's
 * `use_shared_store_automatically` setting, as callers have always relied on. `Disabled` exists
 * because that inherited setting is otherwise unconditional: without it, a caller on a machine
 * that opts in automatically has no way to ask for a repository backed by its own store.
 */
object lore_shared_store_mode_t {
    /**
     * Follow the machine's `use_shared_store_automatically` global setting.
     */
    const val LORE_SHARED_STORE_MODE_INHERIT: Int = 0
    /**
     * Always back the repository with a shared store.
     */
    const val LORE_SHARED_STORE_MODE_ENABLED: Int = 1
    /**
     * Never back the repository with a shared store, whatever the global config says.
     */
    const val LORE_SHARED_STORE_MODE_DISABLED: Int = 2
}

/**
 * Virtual File System type for repository operations.
 * 
 * When not `None`, the `vfs` field causes the repository to create a Virtual File System
 * as the repository directory instead of materializing files directly on disk.
 */
object lore_vfs_type_t {
    /**
     * Use no VFS, store all files using the regular file system
     */
    const val LORE_VFS_TYPE_NONE: Int = 0
    /**
     * Use whichever VFS is suggested based on the user's environment
     */
    const val LORE_VFS_TYPE_DEFAULT: Int = 1
    /**
     * Use SWFS as a VFS
     */
    const val LORE_VFS_TYPE_SWFS: Int = 2
}

