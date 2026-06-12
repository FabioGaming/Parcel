ALTER TABLE storage.folder
ADD CONSTRAINT fk_folder_owner_profile
FOREIGN KEY (owner_profile_id)
REFERENCES profile.profile(id)
ON DELETE CASCADE;