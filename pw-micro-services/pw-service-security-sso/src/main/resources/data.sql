-- users in system
insert into users(username, password, enabled, first_name, last_name, email_address, account_non_expired, account_non_locked, credentials_non_expired)
            values( 'user1', 'password1', TRUE, 'admin', 'admin', 'admin@na.com', TRUE, TRUE, TRUE);

-- oauth client details
# insert into client_details(   client_id, client_secret,  resource_ids,   scopes,          grant_types,                                  authorities)
#                     values(   'demo' ,  'demosecret',    null,           'openid,read',   'authorization_code,refresh_token,password',  null );