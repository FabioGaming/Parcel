ALTER TABLE profile.profile
ADD CONSTRAINT fk_avatar_file
FOREIGN KEY (avatar_file_id)
REFERENCES storage.file(id)
ON DELETE CASCADE;