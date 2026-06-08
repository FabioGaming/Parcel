CREATE TABLE IF NOT EXISTS auth.account (
  id UUID NOT NULL PRIMARY KEY,
  email TEXT NOT NULL,
  profile_id UUID NULL,
  created_at TIMESTAMP NOT NULL,
  modified_at TIMESTAMP NOT NULL,
  verified_at TIMESTAMP,
  account_role INTEGER
);