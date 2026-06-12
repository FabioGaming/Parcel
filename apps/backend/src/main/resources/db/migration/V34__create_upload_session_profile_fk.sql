ALTER TABLE storage.upload_session
ADD CONSTRAINT fk_upload_session_profile
FOREIGN KEY (profile_id)
REFERENCES profile.profile(id)
ON DELETE CASCADE;