//白名单
app.controller('whiteListCtrl', function($scope, $http, $rootScope,$cookieStore) {
	$scope.person = $cookieStore.get("person");
	if ($scope.person == null || $scope.person == ""){
		$cookieStore.remove("person");
		window.location = "index.html";
	};
	$scope.data_cc = "";
	$scope.data_c = "";
	 //查询
	$scope.shuaxin = function(){
        $http({
            method : 'get',
            url : "http://192.168.100.158:8080/doselectwhitelist",
            params:{
            	hphm:$scope.data_cc+$scope.data_c//号牌号码
            }
        }).success(function(data) {
            $scope.fenyeq(data);
            $scope.checked = [];
            $scope.select_all = false;
        }).error(function() {
            $scope.popup1('无法连接到服务器');
        });
	};
    $scope.shuaxin();
	// 全选
	$scope.checked = [];
	$scope.selectAll = function() {
		if ($scope.select_all) {
			$scope.checked = [];
			angular.forEach($scope.items, function(x) {
				x.checked = true;
				$scope.checked.push(x);
			})
		} else {
			angular.forEach($scope.items, function(x) {
				x.checked = false;
				$scope.checked = [];
			})
		}
		// console.log($scope.checked);
	};
	// 双击选择
	$scope.selecttwo = function(x) {

		if (x.checked) {
			x.checked = false;
		} else if (!x.checked) {
			x.checked = true;
		};
		var index = $scope.checked.indexOf(x);
		if (x.checked && index === -1) {
			$scope.checked.push(x);
		} else if (!x.checked && index !== -1) {
			$scope.checked.splice(index, 1);
		};
		if ($scope.items.length === $scope.checked.length) {
			$scope.select_all = true;
		} else {
			$scope.select_all = false;
		};
	};
	// 单击选择
	$scope.selectOne = function() {
		angular.forEach($scope.items, function(x) {
			var index = $scope.checked.indexOf(x);
			if (x.checked && index === -1) {
				$scope.checked.push(x);
			} else if (!x.checked && index !== -1) {
				$scope.checked.splice(index, 1);
			};
		});
		if ($scope.items.length === $scope.checked.length) {
			$scope.select_all = true;
		} else {
			$scope.select_all = false;
		};
	};
	//添加
	$scope.addcanshu = function(){
		$("#sysid").val();
		$("#hphm").val();
		$("#hpzl").val();
		$("#usebusiness").val();
		$("#start_time").val();
		$("#end_time").val();
		$("#remark").val();
		$("#tjxg").val(1);
		layer.open({
            type : 2,
            title : '数据管理',
            shadeClose : true,
            shade : 0.8,
            area: ['850px', '600px'],
            content : "tpl/whitelisttj.html",
            end:function () {
            	if($("#ztpd").val()!=""){
            		$scope.popup1($("#ztpd").val());
            		$("#ztpd").val("");
            	}
            	$scope.shuaxin();
            }
        });
	};
	//修改
    $scope.updcanshu = function(){
    	if($scope.checked.length>1){
            layer.msg('只能选择1条数据！');
		}else if($scope.checked.length==0){
            layer.msg('未选择数据！');
		}else{
			$("#sysid").val($scope.checked[0].sysid);
			$("#hphm").val($scope.checked[0].hphm);
			$("#hpzl").val($scope.checked[0].hpzl);
			$("#usebusiness").val($scope.checked[0].usebusiness);
			$("#start_time").val($scope.checked[0].start_time);
			$("#end_time").val($scope.checked[0].end_time);
			$("#remark").val($scope.checked[0].remark);
			$("#tjxg").val(2);
			layer.open({
	            type : 2,
	            title : '数据管理',
	            shadeClose : true,
	            shade : 0.8,
	            area: ['850px', '600px'],
	            content : "tpl/whitelisttj.html",
	            end:function () {
	            	if($("#ztpd").val()!=""){
	            		$scope.popup1($("#ztpd").val());
	            		$("#ztpd").val("");
	            	}
	            	$scope.shuaxin();
	            }
	        });
		};
    };
	// 删除
	$scope.delIllegal = function() {
        $scope.lopopup();
        var idlist = [];
        angular.forEach($scope.checked, function(data,index) {
        	idlist[index] = data.sysid;
		});
			layer.confirm("确认要作废这" + $scope.checked.length
					+ "条吗?", {
				title: "提示",
			btn: ['确定', '取消'] //按钮
            }, function() {
                $http({
                    method : 'get',
                    url : "http://192.168.100.158:8080/dodeletewhitelist",
                    params : {
                    	nums : idlist
                    }, // 传递数据作为字符串，从前台传到后台
                }).success(function(data) {
                    $scope.popup1('删除成功');
                    $scope.shuaxin();
                }).error(function() {
                    $scope.popup1('无法连接到服务器');
                });
            }, function() {
                layer.closeAll();
            });
	};

	/*$scope.selecteone1 = function() {
		if ($scope.checked.length == 0) {
			alert("未选中数据");
		} else if ($scope.checked.length > 1) {
			alert("只能选择一条数据");
		} else {
			var url = "http://localhost:8080/jjzdoa/selectTaskByNum.action";
			$http({
				method : 'get',
				url : url,
				params : {
					taskNum : $scope.checked
				}, // 传递数据作为字符串，从前台传到后台
			}).success(function(data) {
				$rootScope.taskNumu = data.taskNum;
				$rootScope.taskSummaryu = data.taskSummary;
				$rootScope.taskFromu = data.taskFrom;
				$rootScope.fbPhoneu = data.fbPhone;
				$rootScope.taskLevelu = data.taskLevel;
				$rootScope.zxManu = data.zxMan;
				$rootScope.taskRemarksu = data.taskRemarks;
				window.location = "#/updateTask";
			}).error(function() {
				alert("服务器连接失败");
			});
		}
		;
	}*/
});