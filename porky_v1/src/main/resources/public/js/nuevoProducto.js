// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
    apiKey: "AIzaSyA9oQiRvbmh2VQHbNsYI_X_jpOx-r0FboU",
    authDomain: "porky-cakes.firebaseapp.com",
    projectId: "porky-cakes",
    storageBucket: "porky-cakes.appspot.com",
    messagingSenderId: "703799900814",
    appId: "1:703799900814:web:2a6cba65fae6a2936e27df",
    measurementId: "G-XYHH2TZ2Z9"
};

const app = firebase.initializeApp(firebaseConfig);

const storage = firebase.storage();

const inp = document.querySelector(".inp");
const progressbar = document.querySelector(".progress");
const img = document.querySelector(".img");
const body = document.querySelector("body");
const metaData = document.querySelector(".metaData");
const images = document.querySelector(".inputImgUrl");
const loading = document.querySelector(".loading");
const imageUpload = document.querySelector(".imageUpload");
const completeMsg = document.querySelector(".completeMsg");
let file;
let files;
let fileName;
let progress;
let uploadedFileName;

const selectImage = () => {
    inp.click();
  };
  const getImageData = (e) => {
    files = e.target.files;
    for (let i = 0; i < files.length; i++) {
        let imageData =  document.createElement("span");
        imageData.className ='filedata';
        imageData.style.display ='block';
        imageData.innerHTML = files[i].name;
        metaData.appendChild(imageData);
    }
  };

  const uploadImage = async () => {
    for (let i = 0; i < files.length; i++) {
        let url = await uploadProcess(files[i],Math.round(Math.random()*9999) + files[i].name);
        if(url){
            loading.style.display='none';
            let image = document.createElement("input");
            //image.style.display='block';
            image.setAttribute('type', 'text');
            image.setAttribute('value', url);
            image.setAttribute('name', 'img_producto' + i);
            image.setAttribute('id', 'img_producto' + i);
            image.className ='inputIMG';
            images.appendChild(image);
        }
        if(i===files.length-1){
            completeMsg.innerHTML = `${files.length} files uploaded successfully`;
        }
    }
  };

  const uploadProcess = (file, fileName) => {
    return new Promise((resolve, reject) => {
      const storageRef = storage.ref().child("test");
      const folderRef = storageRef.child(fileName);
      const uploadtask = folderRef.put(file);
      uploadtask.on(
        "state_changed",
        (snapshot) => {
            loading.style.display='block';
          progress =
            (snapshot.bytesTransferred / snapshot.totalBytes) * 100;
          progress = Math.round(progress);
          progressbar.style.width = progress + "%";
          progressbar.innerHTML = progress + "%";
          uploadedFileName = snapshot.ref.name;
        },
        (error) => {
          reject(error);
        },
        () => {
          storage
            .ref("test")
            .child(uploadedFileName)
            .getDownloadURL()
            .then((url) => {
              console.log("URL", url);
              resolve(url);
            });
        }
      );
    });
  };