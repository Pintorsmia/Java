var app = require('express')();
var http = require('http').Server(app);
var io = require('socket.io')(http);
var compteur = 25;
var msg = "";

io.on('connect', function(socket){
    console.log("Client connected")
    io.emit('compteur',compteur);

    socket.on('increment', function(){
        compteur++;
        io.emit('compteur', compteur)
    });

    socket.on('decrement', function(){
        compteur--;
        io.emit('compteur', compteur)
    });

    socket.on('raz', function(){
        compteur=0;
        io.emit('compteur', compteur)
    });
    
    socket.on('receive', function(message){
        io.emit("server", message);
    });
});








app.get('/', function(req, res){
res.sendfile("./index.html");
});
http.listen(3000, function(){
console.log('listening on *:3000');
});
