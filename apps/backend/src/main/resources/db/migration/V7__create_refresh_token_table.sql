CREATE TABLE IF NOT EXISTS auth.refresh_token (
    id UUID PRIMARY KEY NOT NULL,
    account_id UUID NOT NULL,
    device_id TEXT NOT NULL,
    token_hash TEXT NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL,
    consumed_at TIMESTAMP
);