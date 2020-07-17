/**
 * GPRC Node服务端实现，供Java客户端调用（动态代码生成）
 */
let PROTO_FILE_PATH = '/Users/sen/Documents/codeHub/node_grpc/proto/Student.proto';
// 导入GPRC依赖
let grpc = require('grpc');
// 获取stub
let grpcService = grpc.load(PROTO_FILE_PATH).com.sen.proto;

// 创建服务端对象
let server = new grpc.Server();
// 添加接口实现
server.addService(grpcService.StudentService.service,{
    // 实现接口方法
    getRealNameByUsername: getRealNameByUsername,
    getUsersByAge: getUsersByAge,
    getUsersByAges: getUsersByAges,
    biTack: biTack
})
// 绑定启动地址、端口;以不安全的方式启动
server.bind('localhost:8899',grpc.ServerCredentials.createInsecure());
server.start();

/**
 * 接口实现
 * @param call 服务端请求参数
 * @param callback 参数读取后回调；第一个参数，发生错误时返回对应，第二个参数正确返回结果
 */
function getRealNameByUsername(call,callback) {
    console.log('username'+call.request.username)
    callback(null,{realname:'张三'})
}

function getUsersByAge() {

}

function getUsersByAges() {

}

function biTack() {

}