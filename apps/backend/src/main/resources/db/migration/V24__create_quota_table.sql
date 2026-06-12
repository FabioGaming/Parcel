CREATE TABLE IF NOT EXISTS storage.quota (
    id UUID NOT NULL PRIMARY KEY,
    profile_id UUID NOT NULL UNIQUE,
    max_bytes BIGINT NOT NULL DEFAULT 0,
    reserved_bytes BIGINT NOT NULL DEFAULT 0,
    used_bytes BIGINT NOT NULL DEFAULT 0,
    updated_at TIMESTAMP NOT NULL
);