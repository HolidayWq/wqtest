// 定义控制器:
app.controller("showController",function($scope,$controller,$http,showService){
	// AngularJS中的继承:伪继承
	$controller('baseController',{$scope:$scope});

	//定义搜索中的内容
	$scope.searchTime={startTime:null,endTime:null};

	//不分页查询所有
	$scope.findAll=function () {
		showService.findAll().success(function (response) {
			//将后台的数据添加到$scope.list中
			$scope.listAll=response;
        });
    };

    //获取所有的信息  分页
    $scope.getPage=function(page,size){
        //发送请求获取数据
        showService.findAllPage(page,size,$scope.searchEntity).success(function(response){
            //集合数据
            $scope.list = response.list;
            //分页数据
            $scope.paginationConf.totalItems=response.total;
        });
    };

    //搜索
	$scope.search=function () {
		//alert(1);
        //$scope.searchTime.endTime = $scope.searchTime.endTime + " 23:59:59";
		showService.search($scope.searchTime.startTime,$scope.searchTime.endTime).success(function (response) {
            //将查询到的集合传给$scope.searchEntity
			//$scope.searchEntity = response;
			$scope.list=response;//将查询到的再赋值给list
            //$scope.searchTime={};
        })
    }

});
