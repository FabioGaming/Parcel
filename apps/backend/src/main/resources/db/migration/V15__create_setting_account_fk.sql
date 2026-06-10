ALTER TABLE platform.setting
ADD CONSTRAINT fk_setting_updated_by_account
FOREIGN KEY (updated_by_account_id)
REFERENCES auth.account(id);