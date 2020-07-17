/**
 * GRPC Node实现客户端调用Java服务端（动态生成）
 */
let PROTO_FILE_PATH = '/Users/sen/Documents/codeHub/node_grpc/proto/Student.proto';
// 导入GPRC依赖
let grpc = require('grpc');
// 获取stub
let grpcService = grpc.load(PROTO_FILE_PATH).com.sen.proto;
// 使用不安全协议链接
let client = new grpcService.StudentService('localhost:8899',grpc.credentials.createInsecure());

client.getRealNameByUsername({username:'李四'},(error,respData)=>{
    console.log(respData);
});