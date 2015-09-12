-- users in system
insert into account(account_name , password) values('user1', 'password1');
insert into account(account_name , password) values('user2', 'password2');



-- oauth client details
insert into client_details(   client_id, client_secret,  resource_ids,   scopes,          grant_types,                                  authorities)
                    values(   'demo' ,  'demosecret',    null,           'openid,read',   'authorization_code,refresh_token,password',  null );