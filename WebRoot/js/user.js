//用户管理
app.controller('userCtrl',function($scope, $http, $rootScope) {
		$scope.selectUser = function() {
			$http({
				method : 'GET',
				url : "queryUser.action",
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
				$scope.popup("#/User", "未选中数据");
			} else {
                $scope.lopopup();
				layer.confirm("确认要删除" + $scope.checked.length + "条吗?", {
					title : "提示",
					btn : [ '确定', '取消' ]
				// 按钮
				}, function() {
					var sysIdlist = [];
                    angular.forEach($scope.checked, function(data,index) {
                        sysIdlist[index] = data.userNum;
                    });
					$http({
						method : 'get',
						url : "deleteUser.action",
						params : {
                            userNums : sysIdlist
						}, // 传递数据作为字符串，从前台传到后台
					}).success(function(data) {
                        layer.closeAll();
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
				$scope.popup("#/User", "未选中数据");
			} else if ($scope.checked.length > 1) {
				$scope.popup("#/User", "只能修改一条数据");
			} else {
					$rootScope.updateusers = $scope.checked[0];
					window.location = "#/updateUser";
			}
		}
	});
// 部门管理-增
app.controller('addUserCtrl',function($scope, $http, $rootScope) {
    $http({
        method : 'GET',
        url : "querysectors.action",
        // 传递数据作为字符串，从前台传到后台
    }).success(function(data) {
    	$scope.bumen = data;
        $http({
            method : 'GET',
            url : "queryRole.action",
            // 传递数据作为字符串，从前台传到后台
        }).success(function(data) {
            $scope.rolen = data;
        }).error(function() {
            $scope.popup("#/User", "服务器连接失败");
        });
    }).error(function() {
        $scope.popup("#/User", "服务器连接失败");
    });
					$scope.adduserinInfo = function() {
						if($scope.sec==undefined||$scope.rolenn==undefined){
                            $scope.popup1("未选择部门或角色");
						}else{
                            $scope.secdata = JSON.parse($scope.sec);
                            $http({
                                method : 'POST',
                                headers : {
                                    'Content-Type' : 'application/x-www-form-urlencoded; charset=UTF-8'
                                },
                                url : "addUser.action",
                                params : {
                                    secId : $scope.secdata.secId,
                                    secName : $scope.secdata.secName,
                                    userId : $scope.userId,
                                    userName : $scope.userName,
                                    passWord : $scope.passWord,
                                    roleName : $scope.rolenn,
                                    phone : $scope.userPhone,
                                    userOA:$scope.userOA
                                }, // 传递数据作为字符串，从前台传到后台
                            }).success(function(data) {
                                $scope.popup("#/User", data);
                            }).error(function() {
                                $scope.popup("#/User", "无法连接到服务器");
                            });
						};
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
app.controller('updUserCtrl',function($scope, $http, $rootScope) {
					// 角色名称
    if ($scope.updateusers == undefined) {
        $scope.popup("#/User", "参数错误");
    } else {
        $http({
            method : 'GET',
            url : "querysectors.action",
            // 传递数据作为字符串，从前台传到后台
        }).success(function(data) {
        	var da = data;
            angular.forEach(da, function(data,index) {
               if(data.secId==$scope.updateusers.secId){
                   $scope.sec = JSON.stringify(data);
			   }
            });
            $scope.bumen = data;
            $http({
                method : 'GET',
                url : "queryRole.action",
                // 传递数据作为字符串，从前台传到后台
            }).success(function(data) {
                $scope.rolen = data;
            }).error(function() {
                $scope.popup("#/User", "服务器连接失败");
            });
        }).error(function() {
            $scope.popup("#/User", "服务器连接失败");
        });
					$scope.updateuser = function() {
                        $scope.secdata = JSON.parse($scope.sec);
                        $scope.updateusers.secId = $scope.secdata.secId;
                        $scope.updateusers.secName = $scope.secdata.secName;
                        console.log($scope.updateusers);
                        $http({
                            method : 'post',
                            url : "updateUser.action",
                            headers : {
                                'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8'
                            },
                            params : $scope.updateusers, // 传递数据作为字符串，从前台传到后台
                        }).success(function(data) {
                            $scope.popup("#/User", data);
                        }).error(function() {
                            $scope.popup("#/User", "无法连接到服务器");
                        });
					}
    }
});
// 个人信息
app.controller('perInfoCtrl',function($scope, $http, $rootScope, $cookieStore,$location) {
	$scope.person = $cookieStore.get("person");
	// console.log($scope.person);
	if ($scope.person == null || $scope.person == null) {
		$cookieStore.remove("person");
		window.location = "login.html";
	}
    $scope.perInfo = function(){
        if ($scope.perInfourl != undefined && $scope.perInfourl != null && $scope.perInfourl != "") {
            $location.path($scope.perInfourl);
		}else{
            $location.path("/perInfo");
		}
    };
	$scope.updateuser = function() {
		// console.log($scope.person);
		if ($scope.yuanpd != undefined && $scope.yuanpd != null && $scope.yuanpd != "") {
			if ($scope.xinpd != undefined && $scope.xinpd != "") {
				if($scope.qrpd != undefined && $scope.qrpd != ""){
					if($scope.xinpd == $scope.qrpd && $scope.xinpd.length == $scope.xinpd.replace(/\s+/g, "").length){
						$http({
							method : 'post',
							url : "updPassWord.action",
							headers : {
								'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8'
							},
							params : {
								oldpasswd:$scope.yuanpd,
								userNum : $scope.person.userNum,
								passWord : $scope.xinpd
							}, // 传递数据作为字符串，从前台传到后台
						}).success(function(data) {
							if (data == "修改成功"){
								$cookieStore.remove("person");
								$scope.popup("index.html", "修改成功");
							} else {
								layer.msg(data);
							}
						}).error(function() {
							layer.msg("无法连接到服务器");
						});
					}else{
						layer.msg("两次密码输入不一致");
					}
				}else{
					layer.msg("新密码不能为空");
				}
			} else {
				layer.msg("新密码不能为空");
			}
		}else{
			layer.msg("未输入原密码");
		}
	}
});