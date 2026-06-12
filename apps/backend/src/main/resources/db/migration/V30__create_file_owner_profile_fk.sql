ALTER TABLE storage.file
ADD CONSTRAINT fk_file_owner_profile
FOREIGN KEY (owner_profile_id)
REFERENCES profile.profile(id)
ON DELETE CASCADE;