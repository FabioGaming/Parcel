ALTER TABLE storage.usage
ADD CONSTRAINT fk_usage_profile
FOREIGN KEY (profile_id)
REFERENCES profile.profile(id)
ON DELETE CASCADE;