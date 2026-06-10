ALTER TABLE auth.refresh_token
ADD CONSTRAINT fk_refresh_token_device
FOREIGN KEY (device_id)
REFERENCES auth.device(device_id)
ON DELETE CASCADE;