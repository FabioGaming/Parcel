CREATE TABLE IF NOT EXISTS profile.profile (
    id UUID NOT NULL PRIMARY KEY,
    display_name TEXT NOT NULL,
    avatar_url TEXT,
    avatar_file_id UUID UNIQUE,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);