ALTER TABLE platform.invite
ADD CONSTRAINT fk_invite_claimed_by_account
FOREIGN KEY (claimed_by_account_id)
REFERENCES auth.account(id);