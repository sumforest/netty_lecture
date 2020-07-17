/*
* GRPC 静态代码生成服务端
* */
let service = require('../static_codegen/proto/Student_grpc_pb')
let messages = require('../static_codegen/proto/Student_pb')

let grpc = require('grpc')
let server = new grpc.Server()

server.addService(service.StudentServiceService,{
    // 实现接口方法
    getRealNameByUsername: getRealNameByUsername,
    getUsersByAge: getUsersByAge,
    getUsersByAges: getUsersByAges,
    biTack: biTack
})

server.bind('localhost:8899', grpc.ServerCredentials.createInsecure());
server.start();

function getRealNameByUsername(call,callback) {
    console.log('request:%s',call.request.getUsername())
    let response = new messages.MyResponse();
    response.setRealname("赵六")
    callback(null,response)
}

function getUsersByAges() {

}

function biTack() {

}

function getUsersByAge() {

}

function getUsersByAges() {

}

function biTack() {

}