const express = require('express');
const mongoose = require('mongoose');
const eurekaConfig = require('./eureka-config');

// Créer une instance d'Express
const app = express();
const departementRouter = require('./routes/departement')


app.use(express.json());
app.use('/departement', departementRouter);



mongoose.connect('mongodb://root:root@mongodb:27017/departement_db', {
    useNewUrlParser: true,
    authSource: "admin"
}).then(() => {
    console.log("Successfully connected to the database");    
}).catch(error => {
    console.log('Could not connect to the database.', error);
    process.exit();
});



app.get('/', (req, res) => {
  res.send('Hello, World!');
});




app.listen(3000, () => {
  console.log(`Server is listening on port ${3000}`);
});


// Enregistrement de l'instance dans Eureka
eurekaConfig.start((error) => {
  if (error) {
    console.log(error);
  } else {
    console.log('Eureka registration successful');
  }
});