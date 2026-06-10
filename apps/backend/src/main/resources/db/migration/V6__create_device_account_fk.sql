ALTER TABLE auth.device
ADD CONSTRAINT fk_device_account
FOREIGN KEY (account_id)
REFERENCES auth.account(id)
ON DELETE CASCADE;