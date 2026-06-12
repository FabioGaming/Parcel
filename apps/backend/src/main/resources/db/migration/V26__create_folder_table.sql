CREATE TABLE IF NOT EXISTS storage.folder (
    id UUID NOT NULL PRIMARY KEY,
    owner_profile_id UUID NOT NULL,
    parent_folder_id UUID,
    name TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL
);