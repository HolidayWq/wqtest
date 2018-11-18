// 定义服务层:
app.service("showService",function($http){
	//不分页查询所有
	this.findAll=function () {
		return $http.get("/show/list");
    };

    //搜索内容
	this.search=function (startTime,endTime) {
		return $http.get("/show/search?startTime="+startTime+"&endTime="+endTime);
    };

    //查询列表分页
    this.findAllPage=function(page,size,searchEntity){
        return $http.post("/show/listPage?page="+page+"&size="+size,searchEntity);
    }
});