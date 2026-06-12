ALTER TABLE storage.quota
ADD CONSTRAINT fk_quota_profile
FOREIGN KEY (profile_id)
REFERENCES profile.profile
ON DELETE CASCADE;