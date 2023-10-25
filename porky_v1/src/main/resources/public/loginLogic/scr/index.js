import { initializeApp } from 'firebase/app';
import { getAuth, signInWithEmailAndPassword, createUserWithEmailAndPassword } from 'firebase/auth'

const firebaseApp = initializeApp({
    // For Firebase JS SDK v7.20.0 and later, measurementId is optional
    apiKey: "AIzaSyA9oQiRvbmh2VQHbNsYI_X_jpOx-r0FboU",
    authDomain: "porky-cakes.firebaseapp.com",
    projectId: "porky-cakes",
    storageBucket: "porky-cakes.appspot.com",
    messagingSenderId: "703799900814",
    appId: "1:703799900814:web:2a6cba65fae6a2936e27df",
    measurementId: "G-XYHH2TZ2Z9"
});

const auth = getAuth(firebaseApp);

const loginEmailPassword = async () => {
    const loginEmail = txtEmail.value
    const loginPassword = txtPassword.value
  
    // step 1: try doing this w/o error handling, and then add try/catch
    const userCredentials = await signInWithEmailAndPassword(auth, loginEmail, loginPassword);
    console.log(userCredentials.user);
  
    // step 2: add error handling
    // try {
    //   await signInWithEmailAndPassword(auth, loginEmail, loginPassword)
    // }
    // catch(error) {
    //   console.log(`There was an error: ${error}`)
    //   showLoginError(error)
    // }
  }

const createAccount = async () => {
    const email = txtEmail.value
    const password = txtPassword.value
  
    try {
      const userCredentials = await createUserWithEmailAndPassword(auth, email, password)
      console.log(userCredentials.user);
    }
    catch(error) {
      console.log(`There was an error: ${error}`)
      showLoginError(error)
    } 
}

btnLogin.addEventListener("click", loginEmailPassword);
btnSignup.addEventListener("click", createAccount);