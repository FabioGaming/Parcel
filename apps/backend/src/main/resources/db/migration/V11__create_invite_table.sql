CREATE TABLE IF NOT EXISTS platform.invite (
    id UUID NOT NULL PRIMARY KEY,
    recipient_email TEXT NOT NULL,
    code_hash TEXT NOT NULL,
    invited_by_account_id UUID NOT NULL,
    claimed_by_account_id UUID,
    created_at TIMESTAMP NOT NULL,
    expires_at TIMESTAMP NOT NULL,
    claimed_at TIMESTAMP,
    metadata JSONB,
    role TEXT NOT NULL
);