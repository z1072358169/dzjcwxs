//筛选统计
app.controller('wfStatisticsCtrl', function($scope, $http, $rootScope,$cookieStore) {
	$scope.person = $cookieStore.get("person");
	if ($scope.person == null || $scope.person == ""){
		$cookieStore.remove("person");
		window.location = "index.html";
	};
	//查询
    $http({
        method : 'get',
        url : GserverURL + "queryAll.action"
    }).success(function(data) {
        $scope.params = data[0];
    }).error(function() {
        $scope.popup1('无法连接到服务器');
    });
	$http({
		method : 'GET',
		url : GserverURL + "queryUser.action",
		 // 传递数据作为字符串，从前台传到后台
	}).success(function(data) {
		$scope.user = data;
	}).error(function() {
		$scope.popup("#/User", "服务器连接失败");
	});
	function today(){
	    var today=new Date();
	    var h=today.getFullYear();
	    var m=today.getMonth()+1;
	    var d=today.getDate();
	    var hh=today.getHours();
	    var mm=today.getMinutes();
	    var ss=today.getSeconds();
	    m= m<10?"0"+m:m;     
	    d= d<10?"0"+d:d;
	    hh = hh < 10 ? "0" + hh:hh;
	    mm = mm < 10 ? "0" +  mm:mm;
	    ss = ss < 10 ? "0" + ss:ss;
	    return h+"-"+m+"-"+d;
	};
	$("#starttime").val(today()+" "+"00:00:00");
	$("#endtime").val(today()+" "+"23:59:59");
	$scope.chaxunzts = function(){
        $scope.lopopup();
        $http({
            method : 'get',
            url : GserverURL + "finduserandcountold.action",
            //url : GserverURL + "finduserandcountold.action",
            params:{
            	startTime:$("#starttime").val(),//时间
            	endTime:$("#endtime").val(),//时间
            	userName:$scope.data_user,//筛选人
            	WFDM:$scope.data_d//违法行为
            }
        }).success(function(data) {
            layer.closeAll('loading');
            var da = data;
            if(da!=""&&da!=null){
                var ssy = {
                    userName:"合计",
                    tovoid:0,
                    pass:0,
                    allTotal:0
                };
                var deletelist = [];
                angular.forEach(da,function(dat,index){
                    if(dat.tovoid!=0||dat.pass!=0||dat.allTotal!=0){
                        deletelist.push(dat);
                    }
                    ssy.tovoid = ssy.tovoid+dat.tovoid;
                    ssy.pass = ssy.pass+dat.pass;
                    ssy.allTotal = ssy.allTotal+dat.allTotal;
                });
                deletelist.push(ssy);
            }
            $scope.saixuandata = deletelist;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
    };
    $scope.chaxunzts();
});
