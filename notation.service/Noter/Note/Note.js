const router         = require('express').Router()
const { Connexion }  = require('../Connection/Connection');

/* COMMENT PART*/
//Adding
router.post("/Comment", (req, res) => {
    const Body         = req.body;
    const Matricule    = Body.Matricule;
    const Comment      = Body.Comment;
    const Work_id      = Body.Work_id;
    const Date         = Body.Date;
    let Insert_comment = "Insert into comment(Matricule, Comment, Work_id, Date) values(?, ?, ?, ?)";
   
    if(!Matricule || !Comment || !Date || !Work_id){
        return res.status(400).json({
            Message: "Fill all the blanks please !"
        });
    }
    
    Connexion.query(Insert_comment, [Matricule, Comment, Work_id, Date], (err, results) => {
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

//Reading all comments
router.get("/Display_comment", (req, res) =>{
    let Display_comment = "SELECT * FROM comment";

    Connexion.query(Display_comment, (err, results) => {
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

//Reading details
router.get("/Display_details_comment/:id", (req, res) =>{
    const Work_id       = req.params.id;
    let Display_comment = "SELECT * FROM Comment WHERE Work_id = ?";

    if(!Work_id){
        return res.status(400).json({
            Message: "Error !"
        });
    }

    Connexion.query(Display_comment, [Work_id], (err, results) => {
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

//Deleting
router.delete("/Delete_comment/:id", (req, res) =>{
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
router.put("/Modify_comment/:id", (req, res) =>{
    const Body         = req.body;
    const Id           = req.params.id;
    const Comment      = Body.Comment;
    let Modify_comment = "UPDATE comment SET Comment = ? WHERE Id = ?";

    if(!Id || !Comment){
        return res.status(400).json({
            Message: "Please fill the blank !"
        });
    }

    Connexion.query(Modify_comment, [Comment, Id], (err, results) => {
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
/* END */

/* EVALUATION PART*/
//Adding
router.post("/Add_rating", (req, res) => {
    const Body           = req.body;
    const Rating         = Body.Rating;
    const Publication_id = Body.Publication_id;
    const Matricule      = Body.Matricule;
    let Insert_evaluer   = "Insert into evaluate(Rating, Publication_id, Matricule) values(?, ?, ?)";
   
    if(!Rating || !Publication_id || !Matricule){
        return res.status(400).json({
            Message: "Fill all the blanks please !"
        });
    }
    
    Connexion.query(Insert_evaluer, [Rating, Publication_id, Matricule], (err, results) => {
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
router.get("/Display_rating", (req, res) =>{
    let Display_evaluate = "SELECT * FROM evaluate";

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
/* END */

module.exports = router