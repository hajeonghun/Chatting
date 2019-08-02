var net = require('net');
var sockets = [];  // 소켓배열에는 연결된 클라이언트를 저장함
// 서버를 생성
var server = net.createServer(function(socket){
	console.log(socket.address().address + " connected.");
    var nickname = 'Guest' + Math.floor(Math.random() * 100);
    sockets.push({nickname:nickname,socket:socket});
	// client로 부터 오는 data를 화면에 출력
	socket.on('data', function(data){
        var message = data.toString('UTF-8');
        // \\close 입력시 클라이언트 접속 종료
        if(message == '\\close'){
            socket.end();
        }
        //데이터 도착 시 모든 소켓에 쓰기
        sockets.forEach(function(client){
            var socket=client.socket;
            socket.write(message);
            
  
        })});

	// client와 접속이 끊기는 메시지 출력
	socket.on('close', function(){
        console.log('client disconnted.');
        
	});
	// client가 접속하면 화면에 출력해주는 메시지
    socket.write('welcome to server');
    // 클라이언트가 접속을 종료하면 발생하는 이벤트
    socket.on('end', function() {  
        var i = sockets.indexOf(socket);
        // 배열의 i번째 위치부터 1개를 제거
		sockets.splice(i, 1);  
	});

});



// Port 3000으로 접속이 가능하도록 대기
server.listen(3000, function(){
    console.log('linsteing on 3000..');
    
    // 에러가 발생할 경우 화면에 에러메시지 출력
server.on('error', function(err){
	console.log('err'+ err	);
    });
});

function writeData(socket, data){
    var success = !socket.write(data);
    if (!success){
      (function(socket, data){
        socket.once('drain', function(){
          writeData(socket, data);
        });
      })(socket, data);
    }
}