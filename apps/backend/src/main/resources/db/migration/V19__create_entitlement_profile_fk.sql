ALTER TABLE profile.entitlement
ADD CONSTRAINT fk_entitlement_profile
FOREIGN KEY (profile_id)
REFERENCES profile.profile(id)
ON DELETE CASCADE;