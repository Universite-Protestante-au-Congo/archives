const express        = require('express');
const app            = express();
const bodyparser     = require('body-parser');
const { Connexion }  = require('./Connection/Connection');
const PORT           = process.env.PÖRT || 9000;

app.use(bodyparser.json({type:'application/json'}));
app.use(bodyparser.urlencoded({extended:true}));
app.use(express.json());

Connexion.connect(function(error){
    if(error) console.log(error);
    else console.log("You are logged in!");
});

app.get("/user", (req, res) => {
    res.json({ 
        user: "Nathan katanga",
        Message:"My API is working"
    });
});

app.listen(PORT, () => {
    console.log('The server started!')
});

