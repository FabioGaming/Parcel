CREATE TABLE IF NOT EXISTS auth.device (
    id UUID PRIMARY KEY NOT NULL,
    device_id TEXT NOT NULL,
    device_name TEXT NOT NULL,
    account_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    last_seen_at TIMESTAMP NOT NULL,
    verified_at TIMESTAMP
);