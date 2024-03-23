package cordova.plugin.user.database;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Import the DatabaseHelper class
import cordova.plugin.user.database.DatabaseHelper;

public class UserDatabasePlugin extends CordovaPlugin {

    // Database helper object
    private DatabaseHelper dbHelper;

    // Method to execute the plugin
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // Handle different plugin actions based on the provided action string
        if (action.equals("createDatabase")) {
            String databaseName = args.getString(0);
            createDatabase(databaseName, callbackContext);
            return true;
        } else if (action.equals("insertUserData")) {
            JSONObject userData = args.getJSONObject(0);
            insertUserData(userData, callbackContext);
            return true;
        } else if (action.equals("getUserData")) {
            String username = args.getString(0);
            getUserData(username, callbackContext);
            return true;
        } else if (action.equals("updateUserData")) {
            JSONObject userData = args.getJSONObject(0);
            updateUserData(userData, callbackContext);
            return true;
        } else if (action.equals("deleteUserData")) {
            String username = args.getString(0);
            deleteUserData(username, callbackContext);
            return true;
        }
        return false;
    }

    // Method to create the database
    private void createDatabase(String databaseName, CallbackContext callbackContext) {
        // Initialize the database helper if it's not already initialized
        if (dbHelper == null) {
            // dbHelper = new DatabaseHelper(cordova.getActivity().getApplicationContext(), databaseName);
            dbHelper = new DatabaseHelper(cordova.getActivity().getApplicationContext());
            // Open the database
            dbHelper.getWritableDatabase(); // Extra code added
        }
        // Check if database created successfully and notify the callback
        if (dbHelper != null) {
            callbackContext.success("Database created successfully: " + databaseName);
        } else {
            callbackContext.error("Failed to create database: " + databaseName);
        }
    }

    // Method to insert user data into the database
    private void insertUserData(JSONObject userData, CallbackContext callbackContext) {
        // Check if the database helper is initialized
        if (dbHelper == null) {
            callbackContext.error("Database not initialized. Please create database first.");
            return;
        }
        try {
            // Parse user data from the JSON object
            String username = userData.getString("username");
            String name = userData.getString("name");
            String email = userData.getString("email");
            String password = userData.getString("password");
            // Insert user data into the database and notify the callback
            boolean success = dbHelper.insertUserData(username, name, email, password);
            if (success) {
                callbackContext.success("User data inserted successfully");
            } else {
                callbackContext.error("Failed to insert user data");
            }
        } catch (JSONException e) {
            callbackContext.error("Error parsing user data: " + e.getMessage());
        }
    }

    // Method to get user data from the database
    private void getUserData(String username, CallbackContext callbackContext) {
        // Check if the database helper is initialized
        if (dbHelper == null) {
            callbackContext.error("Database not initialized. Please create database first.");
            return;
        }
        // Fetch user data from the database and notify the callback
        JSONObject userData = dbHelper.getUserData(username);
        if (userData != null) {
            callbackContext.success(userData);
        } else {
            callbackContext.error("User not found");
        }
    }

    // Method to update user data in the database
    private void updateUserData(JSONObject userData, CallbackContext callbackContext) {
        // Check if the database helper is initialized
        if (dbHelper == null) {
            callbackContext.error("Database not initialized. Please create database first.");
            return;
        }
        try {
            // Parse user data from the JSON object
            String username = userData.getString("username");
            String name = userData.getString("name");
            String email = userData.getString("email");
            String password = userData.getString("password");
            // Update user data in the database and notify the callback
            boolean success = dbHelper.updateUserData(username, name, email, password);
            if (success) {
                callbackContext.success("User data updated successfully");
            } else {
                callbackContext.error("Failed to update user data");
            }
        } catch (JSONException e) {
            callbackContext.error("Error parsing user data: " + e.getMessage());
        }
    }

    // Method to delete user data from the database
    private void deleteUserData(String username, CallbackContext callbackContext) {
        // Check if the database helper is initialized
        if (dbHelper == null) {
            callbackContext.error("Database not initialized. Please create database first.");
            return;
        }
        // Delete user data from the database and notify the callback
        boolean success = dbHelper.deleteUserData(username);
        if (success) {
            callbackContext.success("User data deleted successfully");
        } else {
            callbackContext.error("Failed to delete user data");
        }
    }
}
