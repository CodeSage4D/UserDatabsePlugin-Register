var exec = require('cordova/exec');

var UserDatabasePlugin = {
    // Method to create the database
    createDatabase: function(databaseName, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'UserDatabasePlugin', 'createDatabase', [databaseName]);
    },
    // Method to insert user data
    insertUserData: function(userData, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'UserDatabasePlugin', 'insertUserData', [userData]);
    },
    // Method to get user data
    getUserData: function(username, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'UserDatabasePlugin', 'getUserData', [username]);
    },
    // Method to update user data
    updateUserData: function(userData, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'UserDatabasePlugin', 'updateUserData', [userData]);
    },
    // Method to delete user data
    deleteUserData: function(username, successCallback, errorCallback) {
        exec(successCallback, errorCallback, 'UserDatabasePlugin', 'deleteUserData', [username]);
    }
};

module.exports = UserDatabasePlugin;
