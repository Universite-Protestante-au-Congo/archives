const express        = require('express');
const app            = express();
const bodyparser     = require('body-parser');
const { Connexion }  = require('./Connection/Connection');
const PORT           = process.env.PÖRT || 9000;
const Comment        = require('./Comment/Comment');

app.use(bodyparser.json({type:'application/json'}));
app.use(bodyparser.urlencoded({extended:true}));
app.use(express.json());

//The APIs routes
app.use("/", Comment);


Connexion.connect(function(error){
    if(error) console.log(error);
    else console.log("You are logged in!");
});

app.listen(PORT, () => {
    console.log('The server started!')
});

