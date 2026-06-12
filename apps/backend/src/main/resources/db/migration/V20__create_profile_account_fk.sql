ALTER TABLE profile.profile
ADD CONSTRAINT fk_profile_account
FOREIGN KEY (id)
REFERENCES auth.account(id)
ON DELETE CASCADE;