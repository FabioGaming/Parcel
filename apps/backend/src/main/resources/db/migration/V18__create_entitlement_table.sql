CREATE TABLE IF NOT EXISTS profile.entitlement (
    id UUID NOT NULL PRIMARY KEY,
    profile_id UUID NOT NULL,
    key TEXT NOT NULL,
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    value JSONB NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);