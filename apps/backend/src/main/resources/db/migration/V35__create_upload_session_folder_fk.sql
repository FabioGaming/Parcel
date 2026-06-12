ALTER TABLE storage.upload_session
ADD CONSTRAINT fk_upload_session_folder
FOREIGN KEY (folder_id)
REFERENCES storage.folder(id)
ON DELETE CASCADE;