CREATE TABLE IF NOT EXISTS platform.setting (
    id UUID NOT NULL PRIMARY KEY,
    key TEXT NOT NULL UNIQUE,
    value JSONB NOT NULL,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    is_secret BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,
    updated_by_account_id UUID NOT NULL
);