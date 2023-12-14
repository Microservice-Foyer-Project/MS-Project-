const Departement  = require('../models/Departement'); // Assurez-vous d'ajuster le chemin selon votre structure de fichiers




// Opération Create (Création d'un utilisateur)
exports.createDepartement = async (req, res) => {
  
    const departement = new Departement ({
        nom:req.body.nom,
        responsable:req.body.responsable,
        nombreProfesseurs:req.body.nombreProfesseurs,
        specialite:req.body.specialite,
    })

    departement.save()
    .then(data => {
        res.json(departement)
        res.send("Successfully added departement" + data.nom);
    }).catch(err => {
        res.status(500).send({message:`Error creating departement ${err.message}`});
    });
};



// Opération Read (Lecture de tous les utilisateurs)
exports.getAllDepartement = async (req, res) => {
  try {
    const departements = await Departement.find();
    res.json(departements);
  } catch (error) {
    console.error('Error fetching departement:', error);
    res.status(500).send('Internal Server Error');
  }
};



exports.getDepartementById = async (req, res) => {
  try {
    const departementId = req.params.id;
    const departement = await Departement.findById(departementId);

    if (!departement) {
      return res.status(404).send('Departement not found');
    }

    res.json(departement);
  } catch (error) {
    console.error('Error fetching departement by ID:', error);
    res.status(500).send('Internal Server Error');
  }
};



exports.updateDepartementById = async (req, res) => {
  
   
    const departementId = req.params.id;
    const {nom, responsable, nombreProfesseurs, specialite } = req.body;

    const departement = await Departement.findById(departementId);

    if (!departement) {
      return res.status(404).send('Departement not found');
    }

    await departement.updateOne({nom, responsable, nombreProfesseurs, specialite })
    
    .then(data => {
        res.send("Successfully updated " );
    }).catch(err => {
        res.status(500).send({message:`Error creating departement ${err.message}`});
    });
  
};




exports.deleteDepartementById = async (req, res) => {
  try {
    const departementId = req.params.id;
    const departement = await Departement.findByIdAndDelete(departementId);

    if (!departement) {
      return res.status(404).send('Department not found');
    }

    res.send('Department deleted successfully');
  } catch (error) {
    console.error('Error deleting department by ID:', error);
    res.status(500).send('Internal Server Error');
  }
};