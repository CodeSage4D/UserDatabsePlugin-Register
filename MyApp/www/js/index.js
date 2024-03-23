document.addEventListener('deviceready', onDeviceReady, false);

function onDeviceReady(){
    console.log('Device is ready'); // Device is ready
    // Add event listeners and login page.
    document.getElementById('registerBtn').addEventListener('click', registerUser);
    document.getElementById('loginBtn').addEventListener('click', loginUser);
}

// Function
function registerUser(){
    // Call the registerUser Plugin function 
    cordova.plugins.UserDatabasePlugin.registerUser(useData, registerSuccess, registerError);

    // function registerSuccess(result){
    //     console.log(result);
    //     document.getElementById('userData').innerHTML = result;
    // }
}

function registerSuccess(){
    console.log ('user registered successfully');
    // document.getElementById('userData').innerHTML = result;
    // window.location.href = "index.html";
    // window.location.reload();
}

function registerError(error){
    console.error('error registering user: ' + error);
    // Handle error here (e.g. show error message. )
}

function login(){
    // Call the loginUser Plugin function 
    cordova.plugins.UserDatabasePlugin.loginUser(useData, loginSuccess, loginError);

    // function loginSuccess(result){
    //     console.log(result);
    //     document.getElementById('userData').innerHTML = result;
    // }
}

function loginSuccess(userData){
    console.log ('user logged in successfully');
    // document.getElementById('userData').innerHTML = result;
    // window.location.href = "index.html";
    // window.location.reload();
}

function loginError(error){
    console.error("error logging in user: " + error);
    // Handle error here (e.g. show error message. )
    // var errorElement = document.getElementById('error');
    // errorElement.innerText = error;
    // errorElement.style.display = 'block';
}