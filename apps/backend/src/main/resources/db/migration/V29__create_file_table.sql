CREATE TABLE IF NOT EXISTS storage.file (
    id UUID NOT NULL PRIMARY KEY,
    owner_profile_id UUID NOT NULL,
    folder_id UUID,
    name TEXT NOT NULL,
    mime_type TEXT NOT NULL,
    size_bytes BIGINT NOT NULL,
    storage_key TEXT NOT NULL,
    checksum TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);