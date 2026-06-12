ALTER TABLE storage.file
ADD CONSTRAINT fk_file_folder
FOREIGN KEY (folder_id)
REFERENCES storage.folder(id)
ON DELETE CASCADE;