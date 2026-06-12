ALTER TABLE storage.folder
ADD CONSTRAINT fk_folder_parent_folder
FOREIGN KEY (parent_folder_id)
REFERENCES storage.folder(id)
ON DELETE CASCADE;