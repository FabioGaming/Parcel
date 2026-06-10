CREATE TABLE IF NOT EXISTS auth.verification_challenge (
    id UUID NOT NULL PRIMARY KEY,
    account_id UUID NOT NULL,
    device_id UUID,
    recipient_email TEXT NOT NULL,
    code_hash TEXT NOT NULL,
    purpose TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    modified_at TIMESTAMP NOT NULL,
    consumed_at TIMESTAMP,
    metadata JSONB
);