ALTER TABLE platform.invite
ADD CONSTRAINT fk_invite_invited_by_account
FOREIGN KEY (invited_by_account_id)
REFERENCES auth.account(id);