CREATE TABLE IF NOT EXISTS storage.upload_session (
    id UUID NOT NULL PRIMARY KEY,
    profile_id UUID NOT NULL,
    folder_id UUID,
    object_key TEXT NOT NULL,
    file_name TEXT NOT NULL,
    mime_type TEXT NOT NULL,
    expected_size_bytes BIGINT NOT NULL,
    status TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    uploaded_at TIMESTAMP NOT NULL,
    completed_at TIMESTAMP NOT NULL,
    failure_reason TEXT
);