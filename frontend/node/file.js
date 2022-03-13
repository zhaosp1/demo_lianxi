//node的file文件模块


//#######阻塞代码实例
var fs = require("fs");
var desktop="C:\\Users\\alice\\Desktop\\";
var data = fs.readFileSync(desktop+"#常用网址.txt");

console.log(data.toString());
console.log("程序执行结束!");




//######非阻塞代码实例
var fs1 = require("fs");

fs1.readFile(desktop+'#常用网址.txt', function (err, data) {
    if (err) return console.error(err);
    console.log(data.toString());
});

console.log("程序执行结束!");