//过滤器
app.filter('replacepursfxs', function () {//过滤器
    return function (input) {
        switch(input)
        {
            case 0:return '未启用'; break;
            case 1:return '启用'; break;
        }
    }
});
app.filter('replacepurmuban', function () {//过滤器
    return function (input) {
        switch(input)
        {
            case "":return '未画模板'; break;
            case "1":return '已画模板'; break;
            case "2":return '未画模板，暂时不要数据'; break;
            case "3":return '港区'; break;
        }
    }
});
//点位管理
app.controller('PointManagementCtrl', function($scope, $http, $rootScope) {
    $scope.items = [];
    //查询
    $scope.selectUser = function() {
        $http({
            method : 'GET',
            url : "querySblukou.action",
            // 传递数据作为字符串，从前台传到后台
        }).success(function(data) {
            $scope.fenyeq(data);
            $scope.checked = [];
            $scope.select_all = false;
        }).error(function() {
            $scope.popup1("服务器连接失败");
        });
    };
    $scope.selectUser();
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
        layer.open({
            type: 1 //Page层类型
            ,btn:["保存","取消"]
            ,title: '添加'
            ,skin: 'layui-layer-prompt'
            ,content: "<div>" +"编号："+
			"<input type='text' class='layui-layer-input' id='aid'>" +
            "名称："+
			"<input type='text' class='layui-layer-input' id='bvalue'>" +
			"</div>"
            ,yes: function(index, layero){
                $scope.lopopup();
            	var data = {};
            	var url = $scope.acheck.urlz + ".action";
            	data[$scope.acheck.data_a] = $("#aid").val();
                data[$scope.acheck.data_b] = $("#bvalue").val();
                $http({
                    method : 'get',
                    url : url,
                    params:data
                }).success(function(data) {
                    $scope.popup1(data);
                    $scope.shuaxin($scope.acheck);
                }).error(function() {
                    $scope.popup1('无法连接到服务器');
                });
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
            layer.open({
                type: 1 //Page层类型
                //,area: ['500px', '300px']
                ,btn:["保存","取消"]
                ,title: '修改'
                ,skin: 'layui-layer-prompt'
                ,content: "<div>" +"编号："+
                "<input type='text' class='layui-layer-input' value='"+ $scope.checked[0].codeid +"' id='aid'>" +
                "名称："+
                "<input type='text' class='layui-layer-input' value='"+ $scope.checked[0].value +"' id='bvalue'>" +
                "</div>"
                ,yes: function(index, layero){
                    $scope.lopopup();
                    var data = {};
                    var url = $scope.acheck.urlg + ".action";
                    data["sysId"] = $scope.checked[0].sysId;
                    data[$scope.acheck.data_a] = $("#aid").val();
                    data[$scope.acheck.data_b] = $("#bvalue").val();
                    console.log(data);
                    $http({
                        method : 'get',
                        url : url,
                        params : data, // 传递数据作为字符串，从前台传到后台
                    }).success(function(data) {
                        $scope.popup1(data);
                        $scope.shuaxin($scope.acheck);
                    }).error(function() {
                        $scope.popup1('无法连接到服务器');
                    });
                }
            });
		};
    };
	// 删除
	$scope.delIllegal = function() {
		if ($scope.checked.length == 0) {
            layer.msg('未选中数据！');
		} else {
			layer.confirm("确认要删除这" + $scope.checked.length
					+ "条吗?", {
				title: "提示",
			btn: ['确定', '取消'] //按钮
		}, function() {
                $scope.lopopup();
                var sysIdlist = [];
                angular.forEach($scope.checked, function(data,index) {
                    sysIdlist[index] = data.sysId;
                });
                var url = $scope.acheck.urls + ".action";
			$http({
				method : 'get',
				url : url,
				params : {
					sysIds : sysIdlist
				}, // 传递数据作为字符串，从前台传到后台
			}).success(function(data) {
				$scope.popup1('删除成功');
                $scope.shuaxin($scope.acheck);
			}).error(function() {
				$scope.popup1('无法连接到服务器');
			});
		}, function() {
			    layer.closeAll();
		});
		}
	};
    //分页
    $scope.fenyeq = function(datax) {
        $scope.data = datax;
        //分页总数
        $scope.pageSize = 15;
        $scope.zongshu = $scope.data.length;
        $scope.pages = Math.ceil($scope.data.length / $scope.pageSize); //分页数
        $scope.newPages = $scope.pages > 5 ? 5 : $scope.pages;
        $scope.pageList = [];
        $scope.selPage = 1;
        //设置表格数据源(分页)
        $scope.setData = function() {
            $scope.items = $scope.data.slice(($scope.pageSize * ($scope.selPage - 1)), ($scope.selPage * $scope.pageSize)); //通过当前页数筛选出表格当前显示数据
        }
        $scope.items = $scope.data.slice(0, $scope.pageSize);
        //分页要repeat的数组
        for(var i = 0; i < $scope.newPages; i++) {
            $scope.pageList.push(i + 1);
        }
        //打印当前选中页索引
        $scope.selectPage = function(page) {
            //不能小于1大于最大
            if(page < 1 || page > $scope.pages) return;
            //最多显示分页数5
            if(page > 2) {
                //因为只显示5个页数，大于2页开始分页转换
                var newpageList = [];
                for(var i = (page - 3); i < ((page + 2) > $scope.pages ? $scope.pages : (page + 2)); i++) {
                    newpageList.push(i + 1);
                }
                $scope.pageList = newpageList;
            }
            $scope.selPage = page;
            $scope.setData();
            $scope.isActivePage(page);
            //			console.log("选择的页：" + page);
        };
        //设置当前选中页样式
        $scope.isActivePage = function(page) {
            return $scope.selPage == page;
        };
        //上一页
        $scope.Previous = function() {
            $scope.selectPage($scope.selPage - 1);
        };
        //下一页
        $scope.Next = function() {
            $scope.selectPage($scope.selPage + 1);
        };
    };
});