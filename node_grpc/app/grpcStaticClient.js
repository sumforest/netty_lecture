/*
* node静态生成客户端
* */
let service = require("../static_codegen/proto/Student_grpc_pb")
let messages = require("../static_codegen/proto/Student_pb")

let grpc = require('grpc')
let client = new service.StudentServiceClient('localhost:8899',grpc.credentials.createInsecure())

let request = new messages.MyRequest()
request.setUsername('王五')

client.getRealNameByUsername(request,function (error,respData) {
    console.log(respData.getRealname())
})