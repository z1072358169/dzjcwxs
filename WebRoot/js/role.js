//角色管理
app.controller('roleCtrl', function($scope, $http, $rootScope) {
	$scope.selectsec = function() {
		$http({
			method : 'GET',
			url : "queryRole.action",
			params : {
				roleName : $scope.roless,
				roleRemarks : $scope.roless,
			}, // 传递数据作为字符串，从前台传到后台
		}).success(function(data) {
			$scope.fenyeq(data);
		}).error(function() {
			$scope.popup1("服务器连接失败");
		});
	}
	$scope.selectsec();

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
		}
		// console.log(JSON.stringify($scope.nmae));
		// console.log($scope.checked);
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
		}
	};

	// 删除
	$scope.deleteone = function() {
		if ($scope.checked.length == 0) {
			$scope.popup1("未选中数据");
		} else {
			layer.confirm("确认要删除" + $scope.checked.length + "条吗?", {
				title : "提示",
				btn : [ '确定', '取消' ]
			// 按钮
			}, function() {
                var sysIdlist = [];
                angular.forEach($scope.checked, function(data,index) {
                    sysIdlist[index] = data.roleNum;
                });
				var url = "deleteRoleList.action";
				$http({
					method : 'get',
					url : url,
					params : {
                        roleNums : sysIdlist
					}, // 传递数据作为字符串，从前台传到后台
				}).success(function(data) {
					layer.confirm('删除成功', {
						title: "提示",
						btn: ['确定'] //按钮
					}, function() {
						location.reload();
					});
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
            $rootScope.roledata = $scope.checked[0];
			window.location = "#/updateRole";
		}
	}
});
// 部门管理-增
app.controller('addroleCtrl', function($scope, $http, $rootScope) {
	$scope.load = function() {
		$('#exampleqx').multiselect({
			buttonWidth : '80%',
			enableFiltering : true,
			enableClickableOptGroups : true,
			enableCollapsibleOptGroups : true,
			maxHeight : 200,
			includeSelectAllOption : true,
			selectAllText : '全选',
			nonSelectedText : '请选择'
		});
	}
	$scope.addroleinInfo = function() {
		var data = $('#exampleqx').val();
        if(data!=null){
            var data2 = $('#exampleqx').val()[0];
            for ( var i = 0; i < data.length - 1; i++) {
                data2 = data2 + ',' + data[i + 1];
            }
            data2 = "{" + data2 + "}";
            $http({
                method : 'POST',
                url : 'addRoleSubmit.action',
                params : {
                    roleName : $scope.roleName,
                    permissions : data2,
                    roleRemarks : $scope.roleRemarks
                }, // 传递数据作为字符串，从前台传到后台
            }).success(function(data) {
                if (data == 1) {
                    $scope.popup("#/Role", "添加成功");
                } else {
                    $scope.popup("#/Role", "添加失败");
                }
            }).error(function() {
                $scope.popup1("无法连接到服务器");
            });
		}else{
            $scope.popup1("权限未选择");
		}
	};
});


app.controller('updroleCtrl',function($scope, $http, $rootScope) {
    if ($scope.roledata == undefined) {
        $scope.popup("#/Role", "参数错误");
    } else {
        $scope.load = function() {
            $('#examplexqx').multiselect({
                buttonWidth : '80%',
                enableFiltering : true,
                enableClickableOptGroups : true,
                enableCollapsibleOptGroups : true,
                maxHeight : 200,
                includeSelectAllOption : true,
                selectAllText : '全选',
                nonSelectedText : '请选择'
            });
            var roleid2 = 0;
            angular.forEach($scope.roledata.permissions, function(data,index) {
    			if(data==true){
    				var role1='';
    				role1 = "option[value='\""+index+ "\":" + data+"']";
    				$(role1, $('#examplexqx')).prop('selected', true);
    			}
    			if(roleid2==Object.keys($scope.roledata.permissions).length-1){
    				//$('#examplexqx').multiselect('val', role1);  
    				$('#examplexqx').multiselect('refresh');  
    			}
    			roleid2++;
    		});
        }
        $scope.updaterole = function() {
            var data = $('#examplexqx').val();
            if(data!=null){
                var data2 = $('#examplexqx').val()[0];
                for ( var i = 0; i < data.length - 1; i++) {
                    data2 = data2 + ',' + data[i + 1];
                }
                data2 = "{" + data2 + "}";
                $scope.roledata.permissions = data2;
			}
            $http(
                {
                    method : 'post',
                    url : "updateRoleSubmit.action",
                    headers : {
                        'Content-Type' : 'application/x-www-form-urlencoded; charset=utf-8'
                    },
                    params : $scope.roledata, // 传递数据作为字符串，从前台传到后台
                }).success(function(data) {
                if (data == 1) {
                    $scope.popup("#/Role", "修改成功");
                } else {
                    $scope.popup1("修改失败");
                }
            }).error(function() {
                $scope.popup1("无法连接到服务器");
            });
        }
	}
});