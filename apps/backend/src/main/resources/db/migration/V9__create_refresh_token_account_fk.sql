ALTER TABLE auth.refresh_token
ADD CONSTRAINT fk_refresh_token_account
FOREIGN KEY (account_id)
REFERENCES auth.account(id)
ON DELETE CASCADE;