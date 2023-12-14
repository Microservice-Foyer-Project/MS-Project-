const mongoose = require('mongoose');

const DepartementSchema = mongoose.Schema({
    id: Number,
    nom:String,
    responsable:String,
    nombreProfesseurs:Number,
    specialite:String
}, {
    timestamps: true 
});

module.exports = mongoose.model('Departement', DepartementSchema);
