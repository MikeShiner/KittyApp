db = db.getSiblingDB('test');

// Creates the user that will be used for setting up testDB
db.createUser(
   {
     user: "testAdmin",
     pwd: "password",
     roles:
       [
        {
			role: "dbOwner",
			db: "test"
		},
       ]
   }
);