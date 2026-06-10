ALTER TABLE auth.verification_challenge
ADD CONSTRAINT fk_verification_challenge_account
FOREIGN KEY (account_id)
REFERENCES auth.account(id)
ON DELETE CASCADE;