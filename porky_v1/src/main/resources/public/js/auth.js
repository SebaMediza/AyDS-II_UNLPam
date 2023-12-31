const firebaseConfig = {
  apiKey: "AIzaSyA9oQiRvbmh2VQHbNsYI_X_jpOx-r0FboU",
  authDomain: "porky-cakes.firebaseapp.com",
  projectId: "porky-cakes",
  storageBucket: "porky-cakes.appspot.com",
  messagingSenderId: "703799900814",
  appId: "1:703799900814:web:2a6cba65fae6a2936e27df",
  measurementId: "G-XYHH2TZ2Z9"
};

// Initialize Firebase
firebase.initializeApp(firebaseConfig);
// Initialize variables
const auth = firebase.auth()
const database = firebase.database()

// Set up our register function
function register() {
  // Get all our input fields
  email = document.getElementById('email').value
  password = document.getElementById('password').value
  //full_name = document.getElementById('full_name').value

  // Validate input fields
  if (validate_email(email) == false || validate_password(password) == false) {
    alert('Email or Password is Outta Line!!')
    return
    // Don't continue running the code
  }
  if (validate_field(full_name) == false) {
    alert('One or More Extra Fields is Outta Line!!')
    return
  }

  // Move on with Auth
  auth.createUserWithEmailAndPassword(email, password)
    .then(function () {
      // Declare user variable
      var user = auth.currentUser
      window.location.href = 'http://localhost:4567/home?uid=' + user.uid;
    })
    .catch(function (error) {
      // Firebase will use this to alert of its errors
      var error_code = error.code
      var error_message = error.message
      alert(error_message)
    })
}

// Set up our login function
function login() {
  // Get all our input fields
  email = document.getElementById('email').value
  password = document.getElementById('password').value
  // Validate input fields
  if (validate_email(email) == false || validate_password(password) == false) {
    const msj = 'Email or Password are Outta Line!!';
    var miDiv = document.getElementById('errorAuth');
    var msjError = document.createElement('p');
    msjError.innerHTML = msj;
    miDiv.innerHTML = msjError.outerHTML;
    return
    // Don't continue running the code
  }

  auth.signInWithEmailAndPassword(email, password)
    .then(function () {
      // Declare user variable
      var user = auth.currentUser
      window.location.href = 'http://localhost:4567/home?uid=' + user.uid;
    })
    .catch(function (error) {
      // Firebase will use this to alert of its errors
      if (error) {
        const msj = 'Email or Password are Incorrect!!';
        var miDiv = document.getElementById('errorAuth');
        var msjError = document.createElement('p');
        msjError.innerHTML = msj;
        miDiv.innerHTML = msjError.outerHTML;
        return
      }
    })
}

function logOut() {
  var uid = headres.get('uid')
  auth.singOut(uid)
}


// Validate Functions
function validate_email(email) {
  expression = /^[^@]+@\w+(\.\w+)+\w$/
  if (expression.test(email) == true) {
    // Email is good
    return true
  } else {
    // Email is not good
    return false
  }
}

function validate_password(password) {
  // Firebase only accepts lengths greater than 6
  if (password < 6) {
    return false
  } else {
    return true
  }
}

function validate_field(field) {
  if (field == null) {
    return false
  }
  if (field.length <= 0) {
    return false
  } else {
    return true
  }
}