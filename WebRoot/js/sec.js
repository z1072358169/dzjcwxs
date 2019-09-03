//部门管理
app.controller('secCtrl',function($scope, $http, $rootScope) {
		$scope.selectUser = function() {
			$http({
				method : 'GET',
				url : "querysectors.action",
				 // 传递数据作为字符串，从前台传到后台
			}).success(function(data) {
				$scope.fenyeq(data);
                $scope.checked = [];
                $scope.select_all = false;
			}).error(function() {
				$scope.popup("#/User", "服务器连接失败");
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
			};
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
			// console.log(JSON.stringify($scope.nmae));
			// console.log($scope.checked);
		};
		// 单击选择
		$scope.selectOne = function() {
			angular.forEach($scope.items, function(x) {
				var index = $scope.checked.indexOf(x);
				if (x.checked && index === -1) {
					$scope.checked.push(x);
					$rootScope.user = x;
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
		// 删除
		$scope.deleteone = function() {
			if ($scope.checked.length == 0) {
				$scope.popup1("未选中数据");
			} else {
                $scope.lopopup();
				layer.confirm("确认要删除" + $scope.checked.length + "条吗?", {
					title : "提示",
					btn : [ '确定', '取消' ]
				// 按钮
				}, function() {
					var sysIdlist = [];
                    angular.forEach($scope.checked, function(data,index) {
                        sysIdlist[index] = data.sectorsNum;
                    });
					var url = "deleteSectorsList.action";
					$http({
						method : 'get',
						url : url,
						params : {
                            sectorsNums : sysIdlist
						}, // 传递数据作为字符串，从前台传到后台
					}).success(function(data) {
                        $scope.popup1("删除成功");
                        $scope.selectUser();
					}).error(function() {
						$scope.popup1("删除失败");
					});
				}, function() {
                    layer.closeAll();
				});
			}
		};
		// 根据num查找器具
		$scope.selecteone = function() {
			if ($scope.checked.length == 0) {
				$scope.popup1("未选中数据");
			} else if ($scope.checked.length > 1) {
				$scope.popup1("只能修改一条数据");
			} else {
					$rootScope.updatesec = $scope.checked[0];
					window.location = "#/updatesec";
			}
		}
	});
// 部门管理-增
app.controller('addsecCtrl',function($scope, $http, $rootScope) {

					$scope.adduserinInfo = function() {
						$http({
								method : 'POST',
								headers : {
									'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
								},
								url : "addSectorsSubmit.action",
								params : {
                                    secId : $scope.secId,
                                    secName : $scope.secName,
                                    secRemarks : $scope.secRemarks
								}, // 传递数据作为字符串，从前台传到后台
							}).success(function(data) {
                            $scope.popup("#/sec", data);
						}).error(function() {
							$scope.popup("#/sec", "无法连接到服务器");
						});
					};
				});

app.directive('repeatFinish', function($timeout) {
	return {
		restrict : 'A',
		link : function(scope, elem, attr) {
			// 当前循环至最后一个
			if (scope.$last === true) {
				$timeout(function() {
					// 向父控制器传递事件消息
					scope.$emit('repeatFinishCallback');
				}, 100);
			}
		}
	}
});
// 用户管理-改
app.controller('updsecCtrl',function($scope, $http, $rootScope) {
					// 角色名称
    if ($scope.updatesec == undefined) {
        $scope.popup("#/sec", "参数错误");
    } else {
    	console.log($scope.updatesec);
					$scope.updateuser = function() {
                        $http({
                            method : 'post',
                            url : "updateSectorsSubmit.action",
                            params : $scope.updatesec, // 传递数据作为字符串，从前台传到后台
                        }).success(function(data) {
                            $scope.popup("#/sec", data);
                        }).error(function() {
                            $scope.popup("#/sec", "无法连接到服务器");
                        });

					}
    }
});