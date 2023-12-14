const express = require('express');
const mongoose = require('mongoose');

// Créer une instance d'Express
const app = express();
const departementRouter = require('./routes/departement')


app.use(express.json());
app.use('/departement', departementRouter);



mongoose.connect('mongodb+srv://user:ESInIsqTcO2QwOUn@cluster0.dwlccnt.mongodb.net/', {
    useNewUrlParser: true
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