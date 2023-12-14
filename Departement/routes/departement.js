const express = require("express")
const router = express.Router();
const departement = require('../controllers/DepartementController')


router.post('/create', departement.createDepartement)
router.patch('/update/:id', departement.updateDepartementById)
router.get('/all' ,departement.getAllDepartement)
router.get('/:id', departement.getDepartementById)
router.delete('/:id', departement.deleteDepartementById)

module.exports = router