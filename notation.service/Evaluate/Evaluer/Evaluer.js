const router         = require('express').Router()
const { Connexion }  = require('../Connection/Connection');

//Addin
router.post("/AjouterCote", (req, res) => {
    const Body    = req.body;
    const note    = Body.note;
    const identifiant  = Body.identifiant;
    const Matricule  = Body.Matricule;
    let Insert_evaluer = "Insert into evaluer(note, identifiant, Matricule) values(?, ?, ?)";
   
    if(!note || !identifiant || !Matricule){
        return res.status(400).json({
            Message: "Fill all the blanks please !"
        });
    }
    
    Connexion.query(Insert_evaluer, [note, identifiant, Matricule], (err, results) => {
        if(err){
            return res.status(400).json({
                Message: "An error occurred !"
            });
        }

        return res.status(400).json({
            Success: 1,
            Data: Body
        })
    })                          
})

//Reading
router.get("/Display_evaluate", (req, res) =>{
    let Display_evaluate = "SELECT * FROM evaluer";

    Connexion.query(Display_evaluate, (err, results) => {
        if(err){
            return res.status(400).json({
                Message: "An error occurred !"
            });
        }
    
        return res.status(200).json({
            Success: 1,
            Data: results
        }) 
})
})

/*Deleting
router.delete("/Delete_evaluate/:id", (req, res) =>{
    const Id           = req.params.id;
    let Delete_comment = "DELETE FROM Comment WHERE Id = ?";

    if(!Id){
        return res.status(400).json({
            Message: "Error !"
        });
    }

    Connexion.query(Delete_comment, [Id], (err, results) => {
        if(err){
            return res.status(400).json({
                Message: "An error occurred !"
            });
        }
    
        return res.status(200).json({
            Success: "The row was successfully deleted"
        }) 
})
})

//Modifying
router.put("/Modify_evaluer/:id", (req, res) =>{
    const Body         = req.body;
    const id           = req.params.id;
    const Comment      = Body.Comment;
    let Modify_evaluer = "UPDATE evaluer SET Comment = ? WHERE Id = ?";

    if(!id || !note){
        return res.status(400).json({
            Message: "Please fill the blank !"
        });
    }

    Connexion.query(Modify_evaluer, [id,note], (err, results) => {
        if(err){
            return res.status(400).json({
                Message: "An error occurred !"
            });
        }
    
        return res.status(200).json({
            Success: "The change was made successfully !"
        }) 
})
})
*/
module.exports = router